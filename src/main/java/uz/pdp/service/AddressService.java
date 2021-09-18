package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.model.AddressDto;

public interface AddressService {
    ResponseEntity<?> add(AddressDto dto);

    ResponseEntity<?> edit(Long id, AddressDto dto);

    ResponseEntity<?> getList();

    ResponseEntity<?> get(Long id);

    ResponseEntity<?> delete(Long id);
}
