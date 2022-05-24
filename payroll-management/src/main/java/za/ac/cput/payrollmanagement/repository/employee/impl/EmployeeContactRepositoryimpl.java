package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeContact;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeContactFactory;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeContactRepositoryimpl implements EmployeeContactRepository {
    private static EmployeeContactRepositoryimpl EMPLOYEE_CONTACT_REPOSITORY;
    private final List<EmployeeContact> employeeContactList;

    private EmployeeContactRepositoryimpl() {
        this.employeeContactList = new ArrayList<>();
    }

    public static EmployeeContactRepositoryimpl getRepository() {
        if (EMPLOYEE_CONTACT_REPOSITORY == null) EMPLOYEE_CONTACT_REPOSITORY = new EmployeeContactRepositoryimpl();
        return EMPLOYEE_CONTACT_REPOSITORY;
    }

    public EmployeeContact save(EmployeeContact employeeContact) {
        EmployeeContact.EmployeeContactId employeeContactId = EmployeeContactFactory.buildId(employeeContact);
        new EmployeeContact.EmployeeContactId(employeeContact.getEmployeeNumber(), employeeContact.getContactTypeId(), employeeContact.getContact());
        Optional<EmployeeContact> read = read(employeeContactId);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeContactList.add(employeeContact);
        return employeeContact;
    }

    //Pulling the wrong method
    public Optional<EmployeeContact> read(EmployeeContact.EmployeeContactId employeeContactId) {
        return this.employeeContactList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeContactId.getEmployeeNumber()))
                .filter(g -> g.getContactTypeId().equalsIgnoreCase(employeeContactId.getContactTypeId()))
                .filter(g -> g.getContact().equalsIgnoreCase(employeeContactId.getContact()))
                .findFirst();

    }

    public void delete(EmployeeContact employeeContact) {
        this.employeeContactList.remove(employeeContact);
    }

    public List<EmployeeContact> findAll() {
        return this.employeeContactList;
    }


    @Override
    public List<EmployeeContact> findByEmployeeNumber(String employeeNumber) {
        return this.employeeContactList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeNumber))
                .collect(Collectors.toList());
    }
}
