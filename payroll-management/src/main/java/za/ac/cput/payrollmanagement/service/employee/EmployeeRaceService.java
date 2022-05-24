package za.ac.cput.payrollmanagement.service.employee;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeRace;
import za.ac.cput.payrollmanagement.service.IService;

import java.util.List;

public interface EmployeeRaceService extends IService<EmployeeRace, EmployeeRace.EmployeeRaceId> {
    List<EmployeeRace> findByEmployeeNumber(String employeeNumber);
}
