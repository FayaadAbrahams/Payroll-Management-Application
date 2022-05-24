package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeGender;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeGenderFactory;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeGenderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeGenderRepositoryimpl implements EmployeeGenderRepository {
    private static EmployeeGenderRepositoryimpl EMPLOYEE_GENDER_REPOSITORY;
    private final List<EmployeeGender> employeeGenderList;

    private EmployeeGenderRepositoryimpl() {
        this.employeeGenderList = new ArrayList<>();
    }

    public static EmployeeGenderRepositoryimpl getRepository() {
        if (EMPLOYEE_GENDER_REPOSITORY == null) EMPLOYEE_GENDER_REPOSITORY = new EmployeeGenderRepositoryimpl();
        return EMPLOYEE_GENDER_REPOSITORY;
    }

    public EmployeeGender save(EmployeeGender employeeGender) {
        EmployeeGender.EmployeeGenderId employeeGenderId = EmployeeGenderFactory.buildId(employeeGender);
        new EmployeeGender.EmployeeGenderId(employeeGender.getEmployeeNumber(), employeeGender.getGenderId());
        Optional<EmployeeGender> read = read(employeeGenderId);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeGenderList.add(employeeGender);
        return employeeGender;
    }

    public Optional<EmployeeGender> read(EmployeeGender.EmployeeGenderId employeeGenderId) {
        return this.employeeGenderList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeGenderId.getEmployeeNumber()))
                .filter(g -> g.getGenderId().equalsIgnoreCase(employeeGenderId.getGenderId()))
                .findFirst();
    }


    public void delete(EmployeeGender employeeGender) {
        this.employeeGenderList.remove(employeeGender);
    }


    public List<EmployeeGender> findByEmployeeNumber(String employeenumber) {
        return this.employeeGenderList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeenumber))
                .collect(Collectors.toList());

    }
}
