package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.entity.Company;
import uz.pdp.mapper.MapstructMapper;
import uz.pdp.model.AddressDto;
import uz.pdp.model.CompanyDto;
import uz.pdp.repository.AddressRepo;
import uz.pdp.repository.CompanyRepo;
import uz.pdp.service.CompanyService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final AddressRepo addressRepo;
    private final CompanyRepo companyRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(CompanyDto dto) {

        Optional<Address> addressOptional = addressRepo.findById(dto.getAddressId());
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");
        companyRepo.save(mapstructMapper.toCompany(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, CompanyDto dto) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isEmpty())
            return ResponseEntity.status(404).body("Company not found");
        Optional<Address> addressOptional = addressRepo.findById(dto.getAddressId());
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");
        companyRepo.save(mapstructMapper.toCompany(companyOptional.get(),dto));
        return ResponseEntity.status(202).body(dto);
    }

    @Override
    public ResponseEntity<?> get(Long id) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isEmpty())
            return ResponseEntity.status(404).body("Company not found");
        return ResponseEntity.status(200).body(companyOptional.get());
    }

    @Override
    public ResponseEntity<?> getList() {
        return ResponseEntity.status(200).body(companyRepo.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isEmpty())
            return ResponseEntity.status(404).body("Company not found");
        companyRepo.delete(companyOptional.get());
        return ResponseEntity.status(200).body(mapstructMapper.toCompanyDto(companyOptional.get()));
    }
}
