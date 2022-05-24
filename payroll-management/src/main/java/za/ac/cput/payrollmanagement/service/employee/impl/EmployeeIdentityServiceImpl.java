package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeIdentity;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeIdentityRepository;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeIdentityRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeIdentityService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeIdentityServiceImpl implements EmployeeIdentityService {
    private static EmployeeIdentityServiceImpl SERVICE;
    private final EmployeeIdentityRepository repository;

    private EmployeeIdentityServiceImpl() {
        this.repository = EmployeeIdentityRepositoryimpl.getRepository();
    }

    public static EmployeeIdentityService getService() {
        if (SERVICE == null) SERVICE = new EmployeeIdentityServiceImpl();
        return SERVICE;
    }

    @Override
    public EmployeeIdentity save(EmployeeIdentity employeeIdentity) {
        return this.repository.save(employeeIdentity);
    }

    @Override
    public Optional<EmployeeIdentity> read(EmployeeIdentity.EmployeeIdentityId employeeIdentityId) {
        return this.repository.read(employeeIdentityId);
    }

    @Override
    public void delete(EmployeeIdentity employeeIdentity) {
        this.repository.delete(employeeIdentity);

    }

    @Override
    public List<EmployeeIdentity> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
