package za.ac.cput.payrollmanagement.domain.employee;

import java.util.Objects;

public class EmployeeGender {
    private final String employeeNumber, genderId;

    private EmployeeGender(Builder builder) {
        this.genderId = builder.genderId;
        this.employeeNumber = builder.employeeNumber;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public static class EmployeeGenderId {
        private String employeeNumber, genderId;

        public EmployeeGenderId(String employeeNumber, String genderId) {
            this.employeeNumber = employeeNumber;
            this.genderId = genderId;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getGenderId() {
            return genderId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeGenderId that = (EmployeeGenderId) o;
            return employeeNumber.equals(that.employeeNumber) && genderId.equals(that.genderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, genderId);
        }
    }
    @Override
    public String toString() {
        return "EmployeeGender{" + "employeeNumber='" + employeeNumber + '\'' + ", genderId='" + genderId + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }


    @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(o==null|| getClass() != o.getClass()) return false;
        EmployeeGender that = (EmployeeGender) o;
        return genderId.equals(that.genderId) && employeeNumber.equals(that.employeeNumber);
    }

    public static class Builder {
        private String employeeNumber, genderId;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder copy(EmployeeGender employeeGender) {
            this.employeeNumber = employeeGender.employeeNumber;
            this.genderId = employeeGender.genderId;
            return this;
        }

        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
    }
}
