package seedu.addressbook.data.person;

import java.util.Objects;

public class Street {
    private String value;

    public Street(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(value, street.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
