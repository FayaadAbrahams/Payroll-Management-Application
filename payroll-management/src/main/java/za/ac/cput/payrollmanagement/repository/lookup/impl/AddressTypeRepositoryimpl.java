package za.ac.cput.payrollmanagement.repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.AddressType;
import za.ac.cput.payrollmanagement.repository.lookup.AddressTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressTypeRepositoryimpl implements AddressTypeRepository {
    private static AddressTypeRepositoryimpl ADDRESS_TYPE_REPOSITORY;
    private final List<AddressType> addressTypeList;

    private AddressTypeRepositoryimpl() {
        this.addressTypeList = new ArrayList<>();
    }

    public static AddressTypeRepositoryimpl addressTypeRepository() {
        if (ADDRESS_TYPE_REPOSITORY == null) ADDRESS_TYPE_REPOSITORY = new AddressTypeRepositoryimpl();
        return ADDRESS_TYPE_REPOSITORY;
    }

    public AddressType save(AddressType addressType) {
        // Check if gender exists, if yes update and return if success
        Optional<AddressType> read = read(addressType.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.addressTypeList.add(addressType);
        return addressType;
    }

    public Optional<AddressType> read(String id) {
        return this.addressTypeList.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(AddressType employeeIdentity) {
        // finds the employeeIdentity if needed and delete
        this.addressTypeList.remove(employeeIdentity);
    }

    public List<AddressType> findAll() {
        return null;
    }

}
