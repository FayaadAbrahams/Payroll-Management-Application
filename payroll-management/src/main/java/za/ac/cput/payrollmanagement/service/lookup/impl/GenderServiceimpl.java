package za.ac.cput.payrollmanagement.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.lookup.Gender;
import za.ac.cput.payrollmanagement.repository.lookup.GenderRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.GenderRepositoryimpl;
import za.ac.cput.payrollmanagement.service.lookup.GenderService;

import java.util.Optional;
@Service
public class GenderServiceimpl implements GenderService {
    private static GenderService SERVICE;
    private final GenderRepository repository;

    private GenderServiceimpl() {
        this.repository = GenderRepositoryimpl.genderRepository();
    }

    public static GenderService getService() {
        if (SERVICE == null) SERVICE = new GenderServiceimpl();
        return SERVICE;
    }

    @Override
    public Gender save(Gender gender) {
        return this.repository.save(gender);
    }

    @Override
    public Optional<Gender> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Gender gender) {
        this.repository.delete(gender);
    }
}
