package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeContact;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeContactRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeContactService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {
    private static EmployeeContactServiceImpl SERVICE;
    private final EmployeeContactRepositoryimpl repository;

    private EmployeeContactServiceImpl() {
        this.repository = EmployeeContactRepositoryimpl.getRepository();
    }

    public static EmployeeContactService getService() {
        if (SERVICE == null) SERVICE = new EmployeeContactServiceImpl();
        return SERVICE;
    }

    @Override
    public EmployeeContact save(EmployeeContact employeeContact) {
        return this.repository.save(employeeContact);
    }

    @Override
    public Optional<EmployeeContact> read(EmployeeContact.EmployeeContactId employeeContactId) {
        return this.repository.read(employeeContactId);
    }

    @Override
    public void delete(EmployeeContact employeeContact) {
        this.repository.delete(employeeContact);

    }

    @Override
    public List<EmployeeContact> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
