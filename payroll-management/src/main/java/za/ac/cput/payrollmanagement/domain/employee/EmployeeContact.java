package za.ac.cput.payrollmanagement.domain.employee;

import java.util.Objects;

public class EmployeeContact {
    private final String employeeNumber, contactTypeId, contact;

    private EmployeeContact(Builder builder) {
        this.contactTypeId = builder.contactTypeId;
        this.contact = builder.contact;
        this.employeeNumber = builder.employeeNumber;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getContact() {
        return contact;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" + "employeeNumber='" + employeeNumber + '\'' + ", contactTypeid='" + contactTypeId + '\'' + ", contact='" + contact + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeContact that = (EmployeeContact) o;
        return employeeNumber.equals(that.employeeNumber) && contactTypeId.equals(that.contactTypeId);
    }

    public static class EmployeeContactId {
        private String employeeNumber, contactTypeId, contact;

        public EmployeeContactId(String employeeNumber, String contactTypeId, String contact) {
            this.employeeNumber = employeeNumber;
            this.contactTypeId = contactTypeId;
            this.contact = contact;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getContactTypeId() {
            return contactTypeId;
        }

        public String getContact() {
            return contact;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeContactId that = (EmployeeContactId) o;
            return employeeNumber.equals(that.employeeNumber) && contactTypeId.equals(that.contactTypeId) && contact.equals(that.contact);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, contactTypeId, contact);
        }
    }

    public static class Builder {
        private String employeeNumber, contactTypeId, contact;

        public Builder contactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }


        public Builder copy(EmployeeContact employeeContact) {
            this.contactTypeId = employeeContact.contactTypeId;
            this.contact = employeeContact.contact;
            this.employeeNumber = employeeContact.employeeNumber;
            return this;
        }

        public EmployeeContact build() {
            return new EmployeeContact(this);
        }

    }

}

