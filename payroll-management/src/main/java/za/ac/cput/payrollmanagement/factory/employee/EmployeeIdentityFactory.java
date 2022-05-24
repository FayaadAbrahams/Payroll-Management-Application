package za.ac.cput.payrollmanagement.factory.employee;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeIdentity;
import za.ac.cput.payrollmanagement.helper.StringHelper;

public class EmployeeIdentityFactory {
    public static EmployeeIdentity build(String employeeNumber, String identityTypeId, String identity) {
        StringHelper.checkStringParam("employeeNumber", employeeNumber);
        StringHelper.checkStringParam("identityTypeID", identityTypeId);
        StringHelper.checkStringParam("identity", identity);

        return new EmployeeIdentity.Builder().employeeNumber(employeeNumber).identityTypeid(identityTypeId).identity(identity).build();
    }

    public static EmployeeIdentity.EmployeeIdentityId buildId(EmployeeIdentity employeeIdentity) {
        return new EmployeeIdentity.EmployeeIdentityId
                (employeeIdentity.getEmployeeNumber(),
                employeeIdentity.getIdentityTypeid(),
                        employeeIdentity.getIdentity());
    }
}
