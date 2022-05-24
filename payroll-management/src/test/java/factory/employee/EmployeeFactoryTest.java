package factory.employee;

import za.ac.cput.payrollmanagement.domain.employee.Employee;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.payrollmanagement.factory.employee.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeFactoryTest extends TestCase {
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build("", "", "",""));
        System.out.println(exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("employeeNumber"));
    }

void buildWithSuccess(){
    Employee employee = EmployeeFactory
            .build("test-number","test-first-name",null,"test-last-name");
    System.out.println(employee);
    assertAll(
        () -> Assertions.assertNotNull(employee),
        () -> Assertions.assertNotNull(employee.getMiddleName())
     );
}
}