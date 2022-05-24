package za.ac.cput.payrollmanagement.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.lookup.AddressType;
import za.ac.cput.payrollmanagement.factory.lookup.AddressTypeFactory;
import za.ac.cput.payrollmanagement.repository.lookup.AddressTypeRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.AddressTypeRepositoryimpl;
import za.ac.cput.payrollmanagement.service.lookup.AddressTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {
    private static AddressTypeService SERVICE;
    private final AddressTypeRepository repository;

    private AddressTypeServiceImpl() {
        this.repository = AddressTypeRepositoryimpl.addressTypeRepository();
    }

    public static AddressTypeService getService() {
        if (SERVICE == null) SERVICE = new AddressTypeServiceImpl();
        return SERVICE;
    }

    @Override
    public AddressType save(AddressType addressType) {
        return this.repository.save(addressType);
    }

    @Override
    public Optional<AddressType> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(AddressType addressType) {
        this.repository.delete(addressType);
    }

    @Override
    public List<AddressType> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<AddressType> addressType = read(id);
        if (addressType.isPresent()) delete(addressType.get());
    }
}
