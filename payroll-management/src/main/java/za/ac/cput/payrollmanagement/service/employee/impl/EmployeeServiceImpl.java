package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.Employee;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeRepository;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl SERVICE;
    private final EmployeeRepository repository;

    private EmployeeServiceImpl() {
        this.repository = EmployeeRepositoryimpl.getRepository();
    }

    public static EmployeeService getService() {
        if (SERVICE == null) SERVICE = new EmployeeServiceImpl();
        return SERVICE;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(Employee.EmployeeId employeeId) {
        return this.repository.read(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);

    }

    @Override
    public List<Employee> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
