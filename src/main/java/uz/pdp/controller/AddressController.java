package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.model.AddressDto;
import uz.pdp.service.AddressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody AddressDto dto){
        return service.add(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable(value = "id")Long id,@RequestBody AddressDto dto){
        return service.edit(id,dto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> get(@PathVariable(value = "id")Long id){
        return service.get(id);
    }

    @GetMapping("/getList")
    private ResponseEntity<?> getList(){
        return service.getList();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
        return service.delete(id);
    }

}
