package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Address;
import uz.pdp.mapper.MapstructMapper;
import uz.pdp.model.AddressDto;
import uz.pdp.repository.AddressRepo;
import uz.pdp.service.AddressService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(AddressDto dto) {
        addressRepo.save(mapstructMapper.toAddress(dto));
        return ResponseEntity.status(201).body(dto);
    }

    @Override
    public ResponseEntity<?> edit(Long id, AddressDto dto) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");
        addressRepo.save(mapstructMapper.toAddress(addressOptional.get(), dto));
        return ResponseEntity.status(202).body(dto);
    }

    @Override
    public ResponseEntity<?> getList() {
        return ResponseEntity.status(200).body(addressRepo.findAll());
    }

    @Override
    public ResponseEntity<?> get(Long id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");
        return ResponseEntity.status(200).body(addressOptional.get());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isEmpty())
            return ResponseEntity.status(404).body("Address not found");
        AddressDto addressDto = mapstructMapper.toAddressDto(addressOptional.get());
        addressRepo.delete(addressOptional.get());
        return ResponseEntity.status(200).body(addressDto);
    }
}
