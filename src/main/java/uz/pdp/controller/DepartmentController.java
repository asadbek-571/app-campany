package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity.Department;
import uz.pdp.model.AddressDto;
import uz.pdp.model.DepartmentDto;
import uz.pdp.service.AddressService;
import uz.pdp.service.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody DepartmentDto dto) {
        return service.add(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody DepartmentDto dto) {
        return service.edit(id, dto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> get(@PathVariable(value = "id") Long id) {
        return service.get(id);
    }

    @GetMapping("/getList")
    private ResponseEntity<?> getList() {
        return service.getList();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return service.delete(id);
    }

}
