package za.ac.cput.payrollmanagement.repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.ContactType;
import za.ac.cput.payrollmanagement.repository.lookup.ContactTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactTypeRepositoryimpl implements ContactTypeRepository {
    private static ContactTypeRepositoryimpl CONTACT_TYPE_REPOSITORY;
    private final List<ContactType> contactTypeList;

    private ContactTypeRepositoryimpl() {
        this.contactTypeList = new ArrayList<>();
    }

    public static ContactTypeRepositoryimpl contactTypeRepository() {
        if (CONTACT_TYPE_REPOSITORY == null) CONTACT_TYPE_REPOSITORY = new ContactTypeRepositoryimpl();
        return CONTACT_TYPE_REPOSITORY;
    }

    public ContactType save(ContactType contactType) {
        // Check if gender exists, if yes update and return if success
        Optional<ContactType> read = read(contactType.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.contactTypeList.add(contactType);
        return contactType;
    }

    public Optional<ContactType> read(String id) {
        return this.contactTypeList.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(ContactType employeeIdentity) {
        // finds the employeeIdentity if needed and delete
        this.contactTypeList.remove(employeeIdentity);
    }

    public List<ContactType> findAll() {
        return null;
    }
}
