package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.model.DepartmentDto;

public interface DepartmentService {
    ResponseEntity<?> add(DepartmentDto dto);

    ResponseEntity<?> edit(Long id, DepartmentDto dto);

    ResponseEntity<?> get(Long id);

    ResponseEntity<?> getList();

    ResponseEntity<?> delete(Long id);
}
