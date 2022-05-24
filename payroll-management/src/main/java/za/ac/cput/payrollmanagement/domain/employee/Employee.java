package za.ac.cput.payrollmanagement.domain.employee;

import za.ac.cput.payrollmanagement.domain.lookup.AddressType;

import java.util.Objects;

public class Employee {
    private final String employeeNumber, firstName, middleName, lastName;

    private Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeNumber='" + employeeNumber + '\'' + ", firstName='" + firstName + '\'' + ", middleName='" + middleName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this.equals(o)) return true;
        if (o.equals(null) || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber.equals(employee.employeeNumber);
    }


    public static class EmployeeId {
        private final String employeeNumber, firstName, middleName, lastName;

        public EmployeeId(String employeeNumber, String firstName, String middleName, String lastName) {
            this.employeeNumber = employeeNumber;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeId that = (EmployeeId) o;
            return employeeNumber.equals(that.employeeNumber) && firstName.equals(that.firstName) && middleName.equals(that.middleName) && lastName.equals(that.lastName);
        }
    }

    public static class Builder {
        private String employeeNumber, firstName, middleName, lastName;

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.middleName = employee.middleName;
            this.lastName = employee.lastName;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
