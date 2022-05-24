package za.ac.cput.payrollmanagement.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.lookup.IdentityType;
import za.ac.cput.payrollmanagement.repository.lookup.IdentityTypeRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.IdentityTypeRepositoryimpl;
import za.ac.cput.payrollmanagement.service.lookup.IdentityTypeService;

import java.util.Optional;
@Service
public class IdentityTypeServiceImpl implements IdentityTypeService {
    private static IdentityTypeService SERVICE;
    private final IdentityTypeRepository repository;

    private IdentityTypeServiceImpl() {
        this.repository = IdentityTypeRepositoryimpl.identityTypeRepository();
    }

    public static IdentityTypeService getService() {
        if (SERVICE == null) SERVICE = new IdentityTypeServiceImpl();
        return SERVICE;
    }

    @Override
    public IdentityType save(IdentityType identityType) {
        return this.repository.save(identityType);
    }

    @Override
    public Optional<IdentityType> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(IdentityType identityType) {
        this.repository.delete(identityType);
    }
}
