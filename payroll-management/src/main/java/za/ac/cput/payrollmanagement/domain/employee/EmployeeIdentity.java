package za.ac.cput.payrollmanagement.domain.employee;

import java.util.Objects;

public class EmployeeIdentity {
    private final String identityTypeid, identity, employeeNumber;

    private EmployeeIdentity(Builder builder) {
        this.identityTypeid = builder.identityTypeid;
        this.identity = builder.identity;
        this.employeeNumber = builder.employeeNumber;
    }

    public String getIdentityTypeid() {
        return identityTypeid;
    }

    public String getIdentity() {
        return identity;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return "EmployeeIdentity{" + "identityTypeid='" + identityTypeid + '\'' + ", identity='" + identity + '\'' + ", employeeNumber='" + employeeNumber + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeIdentity that = (EmployeeIdentity) o;
        return identityTypeid.equals(that.identityTypeid) && employeeNumber.equals(that.employeeNumber) && identity.equals(that.identity);
    }

    //EmployeeIdentityId => ID Identifier for Employee Identity
    public static class EmployeeIdentityId {
        private final String employeeNumber;
        private final String identityTypeId;
        private String identity;

        public EmployeeIdentityId(String employeeNumber, String identityTypeId, String identity) {
            this.employeeNumber = employeeNumber;
            this.identityTypeId = identityTypeId;
            this.identity = identity;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getIdentityTypeId() {
            return identityTypeId;
        }

        public String getIdentity() {
            return identity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeIdentityId that = (EmployeeIdentityId) o;
            return employeeNumber.equals(that.employeeNumber) && identityTypeId.equals(that.identityTypeId) && identity.equals(that.identity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, identityTypeId, identity);
        }
    }

    public static class Builder {
        private String identityTypeid, identity, employeeNumber;

        public Builder identityTypeid(String identityTypeid) {
            this.identityTypeid = identityTypeid;
            return this;
        }

        public Builder identity(String identity) {
            this.identity = identity;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder copy(EmployeeIdentity employeeIdentity) {
            this.employeeNumber = employeeIdentity.employeeNumber;
            this.identity = employeeIdentity.identity;
            this.identityTypeid = employeeIdentity.identityTypeid;
            return this;
        }

        public EmployeeIdentity build() {
            return new EmployeeIdentity(this);
        }
    }


}
