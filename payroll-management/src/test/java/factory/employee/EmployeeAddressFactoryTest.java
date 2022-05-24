package factory.employee;

import za.ac.cput.payrollmanagement.domain.employee.EmployeeAddress;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeAddressFactoryTest extends TestCase {

    @Test
    public void buildWithSuccess(){
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .build("awdawdawdad", "adadwawda", "dawdawd");
        System.out.println(employeeAddress);
        Assertions.assertNotNull(employeeAddress);

    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeAddressFactory
                        .build(null, "dawdawd", "dawdwad"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertSame("employee number is required!", exceptionMessage);
    }
}