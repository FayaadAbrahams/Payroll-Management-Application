package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeGender;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeGenderRepository;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeGenderRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeGenderService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeGenderServiceImpl implements EmployeeGenderService {
    private static EmployeeGenderServiceImpl SERVICE;
    private final EmployeeGenderRepository repository;

    private EmployeeGenderServiceImpl() {
        this.repository = EmployeeGenderRepositoryimpl.getRepository();
    }

    public static EmployeeGenderService getService() {
        if (SERVICE == null) SERVICE = new EmployeeGenderServiceImpl();
        return SERVICE;
    }

    @Override
    public EmployeeGender save(EmployeeGender employeeGender) {
        return this.repository.save(employeeGender);
    }

    @Override
    public Optional<EmployeeGender> read(EmployeeGender.EmployeeGenderId employeeGenderId) {
        return this.repository.read(employeeGenderId);
    }

    @Override
    public void delete(EmployeeGender employeeGender) {
        this.repository.delete(employeeGender);

    }

    @Override
    public List<EmployeeGender> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
