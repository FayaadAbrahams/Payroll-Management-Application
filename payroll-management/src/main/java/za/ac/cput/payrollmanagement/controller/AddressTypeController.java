package za.ac.cput.payrollmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.payrollmanagement.domain.lookup.AddressType;
import za.ac.cput.payrollmanagement.factory.lookup.AddressTypeFactory;
import za.ac.cput.payrollmanagement.service.lookup.AddressTypeService;

import java.util.List;

@RestController
@RequestMapping("payroll/address-type/")
@Slf4j
public class AddressTypeController {
    private final AddressTypeService addressTypeService;

    @Autowired
    public AddressTypeController(@RequestBody AddressTypeService addressTypeService) {
        this.addressTypeService = addressTypeService;
    }

    @PostMapping("save")
    public ResponseEntity<AddressType> save(AddressType addressType) {
        //Used to call error messages
        log.info("Save request: {}", addressType);
        //Old Skool method to get request
        System.out.println(String.format("Save request: %s", addressType));
        AddressType obj = AddressTypeFactory.build(addressType.getId(), addressType.getName());
        AddressType save = addressTypeService.save(obj);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<AddressType> read(@PathVariable String id) {
        //Used to call error messages
        log.info("Read request: {}", id);
        AddressType addressType = this.addressTypeService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(addressType);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request: {}", id);
        this.addressTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<AddressType>> findAll() {
        List<AddressType> addressTypes = this.addressTypeService.findAll();
        return ResponseEntity.ok(addressTypes);
    }
}
