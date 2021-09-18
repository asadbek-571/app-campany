package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.model.WorkerDto;

public interface WorkerService {
    ResponseEntity<?> add(WorkerDto dto);

    ResponseEntity<?> edit(Long id, WorkerDto dto);

    ResponseEntity<?> get(Long id);

    ResponseEntity<?> getList();

    ResponseEntity<?> delete(Long id);

}
