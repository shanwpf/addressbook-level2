package seedu.addressbook.data.person;

import java.util.Objects;

public class Block {
    private String value;

    public Block(String value) {
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
        Block block = (Block) o;
        return Objects.equals(value, block.value);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
