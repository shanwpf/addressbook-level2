package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 272009";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be of format: BLOCK, STREETNAME, UNIT, POSTALCODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+[,].+[,].+[,].+";
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTALCODE_INDEX = 3;
    private static final String COMMA_DELIM = ", ";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] split = trimmedAddress.split(COMMA_DELIM);
        this.block = new Block(split[BLOCK_INDEX]);
        this.street = new Street(split[STREET_INDEX]);
        this.unit = new Unit(split[UNIT_INDEX]);
        this.postalCode = new PostalCode(split[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.block.toString() + COMMA_DELIM + this.street.toString()
                + COMMA_DELIM + this.unit.toString() + COMMA_DELIM + this.postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).getBlock())
                && this.street.equals(((Address) other).getStreet())
                && this.unit.equals(((Address) other).getUnit())
                && this.postalCode.equals(((Address) other).getPostalCode())); // state check
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Block getBlock() {
        return block;
    }

    public Street getStreet() {
        return street;
    }

    public Unit getUnit() {
        return unit;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}
