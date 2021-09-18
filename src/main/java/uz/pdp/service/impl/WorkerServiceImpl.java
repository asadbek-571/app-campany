package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.entity.Company;
import uz.pdp.entity.Department;
import uz.pdp.entity.Worker;
import uz.pdp.mapper.MapstructMapper;
import uz.pdp.model.DepartmentDto;
import uz.pdp.model.WorkerDto;
import uz.pdp.repository.AddressRepo;
import uz.pdp.repository.DepartmentRepo;
import uz.pdp.repository.WorkerRepo;
import uz.pdp.service.WorkerService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepo workerRepo;
    private final DepartmentRepo departmentRepo;
    private final AddressRepo addressRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(WorkerDto dto) {

        Optional<Address> addressOptional = addressRepo.findById(dto.getAddressId());
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");

        Optional<Department> department = departmentRepo.findById(dto.getDepartmentId());
        if (department.isEmpty())
            return ResponseEntity.status(404).body("Department not found");

        workerRepo.save(mapstructMapper.toWorker(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, WorkerDto dto) {

        Optional<Worker> workerOptional = workerRepo.findById(id);
        if (workerOptional.isEmpty())
            return ResponseEntity.status(404).body("Worker not found");

        Optional<Address> addressOptional = addressRepo.findById(dto.getAddressId());
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");

        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty())
            return ResponseEntity.status(404).body("Department not found");

        workerRepo.save(mapstructMapper.toWorker(workerOptional.get(), dto));
        return ResponseEntity.status(202).body(dto);
    }

    @Override
    public ResponseEntity<?> get(Long id) {

        Optional<Worker> workerOptional = workerRepo.findById(id);
        if (workerOptional.isEmpty())
            return ResponseEntity.status(404).body("Worker not found");
        return ResponseEntity.status(200).body(workerOptional.get());
    }

    @Override
    public ResponseEntity<?> getList() {
        return ResponseEntity.status(200).body(workerRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {

        Optional<Worker> workerOptional = workerRepo.findById(id);
        if (workerOptional.isEmpty())
            return ResponseEntity.status(404).body("Worker not found");
        workerRepo.delete(workerOptional.get());
        return ResponseEntity.status(200).body(mapstructMapper.toWorkerDto(workerOptional.get()));
    }
}
