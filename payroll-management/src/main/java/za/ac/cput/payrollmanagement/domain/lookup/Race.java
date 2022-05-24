package za.ac.cput.payrollmanagement.domain.lookup;

import java.util.Objects;

public class Race {
    private final String id, name;

    private Race(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class RaceId {
        private final String id;
        private final String name;

        public RaceId(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RaceId raceId = (RaceId) o;
            return id.equals(raceId.id) && name.equals(raceId.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Builder {
        private String id, name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Race race) {
            this.id = race.id;
            this.name = race.name;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }

}
