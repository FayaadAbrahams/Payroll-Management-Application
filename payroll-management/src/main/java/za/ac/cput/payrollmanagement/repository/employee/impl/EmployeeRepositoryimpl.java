package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.Employee;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepositoryimpl implements EmployeeRepository {
    private static EmployeeRepositoryimpl EMPLOYEE_REPOSITORY;
    private final List<Employee> employeeList;

    private EmployeeRepositoryimpl() {
        this.employeeList = new ArrayList<>();
    }

    public static EmployeeRepositoryimpl getRepository() {
        if (EMPLOYEE_REPOSITORY == null) EMPLOYEE_REPOSITORY = new EmployeeRepositoryimpl();
        return EMPLOYEE_REPOSITORY;
    }

    public Employee save(Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    public Optional<Employee> read(Employee.EmployeeId employeeId) {
        return this.employeeList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeId.getEmployeeNumber()))
                .filter(g -> g.getFirstName().equalsIgnoreCase(employeeId.getFirstName()))
                .filter(g -> g.getMiddleName().equalsIgnoreCase(employeeId.getMiddleName()))
                .filter(g -> g.getLastName().equalsIgnoreCase(employeeId.getLastName()))
                .findFirst();

    }

    public void delete(Employee employee) {
        this.employeeList.remove(employee);
    }

    public List<Employee> findAll() {
        return this.employeeList;
    }


    public List<Employee> findByEmployeeNumber(String employeeNumber) {
        return this.employeeList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeNumber))
                .collect(Collectors.toList());
    }
}
