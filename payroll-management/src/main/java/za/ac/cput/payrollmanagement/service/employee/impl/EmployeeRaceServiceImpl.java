package za.ac.cput.payrollmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.employee.EmployeeRace;
import za.ac.cput.payrollmanagement.repository.employee.EmployeeRaceRepository;
import za.ac.cput.payrollmanagement.repository.employee.impl.EmployeeRaceRepositoryimpl;
import za.ac.cput.payrollmanagement.service.employee.EmployeeRaceService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeRaceServiceImpl implements EmployeeRaceService {
    private static EmployeeRaceServiceImpl SERVICE;
    private final EmployeeRaceRepository repository;

    private EmployeeRaceServiceImpl() {
        this.repository = EmployeeRaceRepositoryimpl.getRepository();
    }

    public static EmployeeRaceService getService() {
        if (SERVICE == null) SERVICE = new EmployeeRaceServiceImpl();
        return SERVICE;
    }

    @Override
    public EmployeeRace save(EmployeeRace employeeRace) {
        return this.repository.save(employeeRace);
    }

    @Override
    public Optional<EmployeeRace> read(EmployeeRace.EmployeeRaceId employeeRaceId) {
        return this.repository.read(employeeRaceId);
    }

    @Override
    public void delete(EmployeeRace employeeRace) {
        this.repository.delete(employeeRace);

    }

    @Override
    public List<EmployeeRace> findByEmployeeNumber(String employeeNumber) {
        return this.repository.findByEmployeeNumber(employeeNumber);
    }
}
