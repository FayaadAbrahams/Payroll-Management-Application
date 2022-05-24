package za.ac.cput.payrollmanagement.domain.employee;

import java.util.Objects;

public class EmployeeRace {
    private final String employeeNumber, raceId;

    private EmployeeRace(Builder builder) {
        this.raceId = builder.raceId;
        this.employeeNumber = builder.employeeNumber;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public static class EmployeeRaceId{
        private String employeeNumber, raceId;

        public EmployeeRaceId(String employeeNumber, String raceId) {
            this.employeeNumber = employeeNumber;
            this.raceId = raceId;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public String getRaceId() {
            return raceId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeRaceId that = (EmployeeRaceId) o;
            return employeeNumber.equals(that.employeeNumber) && raceId.equals(that.raceId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeNumber, raceId);
        }
    }
    @Override
    public String toString() {
        return "EmployeeRace{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", raceId='" + raceId + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }


    public static class Builder {
        private String employeeNumber, raceId;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder employeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder copy(EmployeeRace employeeRace){
            this.employeeNumber = employeeRace.employeeNumber;
            this.raceId = employeeRace.raceId;
            return this;
        }

        public EmployeeRace build(){
            return new EmployeeRace(this);
        }
    }

}
