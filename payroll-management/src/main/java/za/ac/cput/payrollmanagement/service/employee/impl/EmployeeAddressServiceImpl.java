package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeAddressRepository;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeAddressRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeAddressService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {
    private static EmployeeAddressServiceImpl SERVICE;
    private final EmployeeAddressRepository repository;

    private EmployeeAddressServiceImpl() {
        this.repository = EmployeeAddressRepositoryimpl.getRepository();
    }

    public static EmployeeAddressService getService() {
        if (SERVICE == null)
            SERVICE = new EmployeeAddressServiceImpl();
        return SERVICE;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressId employeeAddressId) {
        return this.repository.read(employeeAddressId);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.repository.delete(employeeAddress);

    }

    @Override
    public List<EmployeeAddress> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
