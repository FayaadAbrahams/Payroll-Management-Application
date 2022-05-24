package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeAddress.EmployeeAddressId;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeAddressFactory;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeAddressRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeAddressRepositoryimpl  implements EmployeeAddressRepository {
    private static EmployeeAddressRepositoryimpl EMPLOYEE_ADDRESS_REPOSITORY;
    private final List<EmployeeAddress> employeeAddressList;

    private EmployeeAddressRepositoryimpl() {
        this.employeeAddressList = new ArrayList<>();
    }

    public static EmployeeAddressRepositoryimpl getRepository() {
        if (EMPLOYEE_ADDRESS_REPOSITORY == null) EMPLOYEE_ADDRESS_REPOSITORY = new EmployeeAddressRepositoryimpl();
        return EMPLOYEE_ADDRESS_REPOSITORY;
    }

    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        EmployeeAddress.EmployeeAddressId employeeAddressId = EmployeeAddressFactory.buildId(employeeAddress);
        new EmployeeAddressId(employeeAddress.getEmployeeNumber(), employeeAddress.getAddress(), employeeAddress.addressTypeid());
        Optional<EmployeeAddress> read = read(employeeAddressId);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeAddressList.add(employeeAddress);
        return employeeAddress;
    }

    public Optional<EmployeeAddress> read(EmployeeAddressId employeeAddressId) {
        return this.employeeAddressList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeAddressId.getEmployeeNumber()))
                .filter(g -> g.getAddress().equalsIgnoreCase(employeeAddressId.getAddressTypeId()))
                .findFirst();
    }


    public void delete(EmployeeAddress employeeAddress) {
        this.employeeAddressList.remove(employeeAddress);
    }


    public List<EmployeeAddress> findByEmployeeNumber(String employeenumber) {
        return this.employeeAddressList.stream().filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeenumber)).collect(Collectors.toList());

    }
}
