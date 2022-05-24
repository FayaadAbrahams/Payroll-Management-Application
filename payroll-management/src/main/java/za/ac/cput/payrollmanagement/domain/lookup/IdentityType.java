package za.ac.cput.payrollmanagement.domain.lookup;

import java.util.Objects;

public class IdentityType {
    private final String id, name;

    private IdentityType(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static class IdentityTypeId {
        private final String id;
        private final String name;

        public IdentityTypeId(String id, String name) {
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
            IdentityTypeId that = (IdentityTypeId) o;
            return id.equals(that.id) && name.equals(that.name);
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

        public Builder copy(IdentityType identityType) {
            this.id = identityType.id;
            this.name = identityType.name;
            return this;
        }

        public IdentityType build() {
            return new IdentityType(this);
        }
    }
}
