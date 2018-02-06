package seedu.addressbook.data.person;

import java.util.Objects;

public class PostalCode {
    private String value;

    public PostalCode(String value) {
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
        PostalCode that = (PostalCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
