package za.ac.cput.payrollmanagement.domain.employee;

import java.util.Objects;

public class EmployeeAddress {
    private final String employeeNumber, addressTypeId, address;

    private EmployeeAddress(Builder builder) {
        this.addressTypeId = builder.addressTypeId;
        this.address = builder.address;
        this.employeeNumber = builder.employeeNumber;
    }

    public String addressTypeid() {
        return addressTypeId;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public static class EmployeeAddressId{
        private String employeeNumber, addressTypeId, address;

        public EmployeeAddressId(String employeeNumber, String addressTypeId, String address) {
            this.employeeNumber = employeeNumber;
            this.addressTypeId = addressTypeId;
            this.address = address;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getAddressTypeId() {
            return addressTypeId;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeAddressId that = (EmployeeAddressId) o;
            return employeeNumber.equals(that.employeeNumber) && addressTypeId.equals(that.addressTypeId) && address.equals(that.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, addressTypeId, address);
        }
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" + "employeeNumber='" + employeeNumber + '\'' + ", addressTypeId='" + addressTypeId + '\'' + ", address='" + address + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }


    public static class Builder {
        private String employeeNumber, addressTypeId, address;

        public Builder addressTypeId(String addressTypeId) {
            this.addressTypeId = addressTypeId;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress) {
            this.addressTypeId = employeeAddress.addressTypeId;
            this.address = employeeAddress.address;
            this.employeeNumber = employeeAddress.employeeNumber;
            return this;
        }

        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
    }

}
