package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeIdentity;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeIdentityFactory;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeIdentityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeIdentityRepositoryimpl implements EmployeeIdentityRepository {

    private static EmployeeIdentityRepositoryimpl EMPLOYEE_IDENTITY_REPOSITORY;
    private final List<EmployeeIdentity> employeeIdentityList;

    private EmployeeIdentityRepositoryimpl() {
        this.employeeIdentityList = new ArrayList<>();
    }

    public static EmployeeIdentityRepositoryimpl getRepository() {
        if (EMPLOYEE_IDENTITY_REPOSITORY == null) EMPLOYEE_IDENTITY_REPOSITORY = new EmployeeIdentityRepositoryimpl();
        return EMPLOYEE_IDENTITY_REPOSITORY;
    }

    public EmployeeIdentity save(EmployeeIdentity employeeIdentity) {
        EmployeeIdentity.EmployeeIdentityId employeeIdentityId = EmployeeIdentityFactory.buildId(employeeIdentity);
        new EmployeeIdentity.EmployeeIdentityId(employeeIdentity.getEmployeeNumber(), employeeIdentity.getIdentityTypeid(), employeeIdentity.getIdentity());
        Optional<EmployeeIdentity> read = read(employeeIdentityId);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeIdentityList.add(employeeIdentity);
        return employeeIdentity;
    }

    public Optional<EmployeeIdentity> read(EmployeeIdentity.EmployeeIdentityId employeeIdentityId) {
        return this.employeeIdentityList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeIdentityId.getEmployeeNumber()))
                .filter(g -> g.getIdentityTypeid().equalsIgnoreCase(employeeIdentityId.getIdentityTypeId()))
                .findFirst();
    }


    public void delete(EmployeeIdentity employeeIdentity) {
        this.employeeIdentityList.remove(employeeIdentity);
    }

    public List<EmployeeIdentity> findByEmployeeNumber(String employeenumber) {
        return this.employeeIdentityList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeenumber))
                .collect(Collectors.toList());

    }
}
