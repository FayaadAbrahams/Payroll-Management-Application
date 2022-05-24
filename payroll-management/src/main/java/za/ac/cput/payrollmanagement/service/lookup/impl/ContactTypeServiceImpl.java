package za.ac.cput.payrollmanagement.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.lookup.ContactType;
import za.ac.cput.payrollmanagement.repository.lookup.ContactTypeRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.ContactTypeRepositoryimpl;
import za.ac.cput.payrollmanagement.service.lookup.ContactTypeService;

import java.util.Optional;
@Service
public class ContactTypeServiceImpl implements ContactTypeService {
    private static ContactTypeService SERVICE;
    private final ContactTypeRepository repository;

    private ContactTypeServiceImpl() {
        this.repository = ContactTypeRepositoryimpl.contactTypeRepository();
    }

    public static ContactTypeService getService() {
        if (SERVICE == null) SERVICE = new ContactTypeServiceImpl();
        return SERVICE;
    }

    @Override
    public ContactType save(ContactType contactType) {
        return this.repository.save(contactType);
    }

    @Override
    public Optional<ContactType> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(ContactType contactType) {
        this.repository.delete(contactType);
    }
}
