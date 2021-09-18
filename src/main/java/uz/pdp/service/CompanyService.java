package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.model.AddressDto;
import uz.pdp.model.CompanyDto;

public interface CompanyService {
    ResponseEntity<?> add(CompanyDto dto);

    ResponseEntity<?> edit(Long id, CompanyDto dto);

    ResponseEntity<?> get(Long id);

    ResponseEntity<?> getList();

    ResponseEntity<?> delete(Long id);
}
