package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.entity.Company;
import uz.pdp.entity.Department;
import uz.pdp.mapper.MapstructMapper;
import uz.pdp.model.CompanyDto;
import uz.pdp.model.DepartmentDto;
import uz.pdp.repository.CompanyRepo;
import uz.pdp.repository.DepartmentRepo;
import uz.pdp.service.DepartmentService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeportmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final CompanyRepo companyRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(DepartmentDto dto) {

        Optional<Company> companyOptional = companyRepo.findById(dto.getCompanyId());
        if (companyOptional.isEmpty())
            return ResponseEntity.status(404).body("Company not found");
        departmentRepo.save(mapstructMapper.toDepartment(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, DepartmentDto dto) {

        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty())
            return ResponseEntity.status(404).body("Department not found");
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isEmpty())
            return ResponseEntity.status(404).body("Company not found");

        departmentRepo.save(mapstructMapper.toDepartment(department.get(), dto));
        return ResponseEntity.status(202).body(dto);
    }

    @Override
    public ResponseEntity<?> get(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty())
            return ResponseEntity.status(404).body("Department not found");
        return ResponseEntity.status(200).body(department.get());
    }

    @Override
    public ResponseEntity<?> getList() {
        return ResponseEntity.status(200).body(departmentRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty())
            return ResponseEntity.status(404).body("Department not found");
        departmentRepo.delete(department.get());
        return ResponseEntity.status(200).body(mapstructMapper.toDepartmentDto(department.get()));
    }
}
