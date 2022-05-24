package za.ac.cput.payrollmanagement.repository.employee.impl;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeRace;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeRaceFactory;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeRaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRaceRepositoryimpl implements EmployeeRaceRepository {
    private static EmployeeRaceRepositoryimpl EMPLOYEE_RACE_REPOSITORY;
    private final List<EmployeeRace> employeeRaceList;

    private EmployeeRaceRepositoryimpl() {
        this.employeeRaceList = new ArrayList<>();
    }

    public static EmployeeRaceRepositoryimpl getRepository() {
        if (EMPLOYEE_RACE_REPOSITORY == null) EMPLOYEE_RACE_REPOSITORY = new EmployeeRaceRepositoryimpl();
        return EMPLOYEE_RACE_REPOSITORY;
    }

    public EmployeeRace save(EmployeeRace employeeRace) {
        EmployeeRace.EmployeeRaceId employeeRaceId = EmployeeRaceFactory.buildId(employeeRace);
        new EmployeeRace.EmployeeRaceId(employeeRace.getEmployeeNumber(), employeeRace.getRaceId());
        Optional<EmployeeRace> read = read(employeeRaceId);
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeRaceList.add(employeeRace);
        return employeeRace;
    }

    public Optional<EmployeeRace> read(EmployeeRace.EmployeeRaceId employeeRaceId) {
        return this.employeeRaceList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeeRaceId.getEmployeeNumber()))
                .filter(g -> g.getRaceId().equalsIgnoreCase(employeeRaceId.getRaceId()))
                .findFirst();
    }


    public void delete(EmployeeRace employeeRace) {
        this.employeeRaceList.remove(employeeRace);
    }


    public List<EmployeeRace> findByEmployeeNumber(String employeenumber) {
        return this.employeeRaceList.stream()
                .filter(g -> g.getEmployeeNumber().equalsIgnoreCase(employeenumber))
                .collect(Collectors.toList());

    }
}
