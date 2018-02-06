package seedu.addressbook.data.person;

import java.util.Objects;

public class Unit {
    private String value;

    public Unit(String value) {
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
        Unit unit = (Unit) o;
        return Objects.equals(value, unit.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
