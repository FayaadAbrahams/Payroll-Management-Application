package za.ac.cput.payrollmanagement.repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.IdentityType;
import za.ac.cput.payrollmanagement.repository.lookup.IdentityTypeRepository;
import za.ac.cput.payrollmanagement.repository.lookup.RaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdentityTypeRepositoryimpl implements IdentityTypeRepository {
    private static IdentityTypeRepositoryimpl IDENTITY_TYPE_REPOSITORY;
    private final List<IdentityType> identityTypeList;

    private IdentityTypeRepositoryimpl() {
        this.identityTypeList = new ArrayList<>();
    }

    public static IdentityTypeRepositoryimpl identityTypeRepository() {
        if (IDENTITY_TYPE_REPOSITORY == null) IDENTITY_TYPE_REPOSITORY = new IdentityTypeRepositoryimpl();
        return IDENTITY_TYPE_REPOSITORY;
    }

    public IdentityType save(IdentityType identityType) {
        // Check if gender exists, if yes update and return if success
        Optional<IdentityType> read = read(identityType.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.identityTypeList.add(identityType);
        return identityType;
    }

    public Optional<IdentityType> read(String id) {
        return this.identityTypeList.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(IdentityType employeeIdentity) {
        // finds the employeeIdentity if needed and delete
        this.identityTypeList.remove(employeeIdentity);
    }

    public List<IdentityType> findAll() {
        return null;
    }
}
