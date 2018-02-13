package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Superclass for a person's contact details
 */
public class Contact {
    public final String value;
    protected boolean isPrivate;

    /**
     * Validates value based on given validationRegex
     *
     * @param validationRegex Validity regex from child implementation
     * @param constraints Exception message from child implementation
     * @throws IllegalValueException if given string is invalid
     */
    public Contact(String value, boolean isPrivate, String validationRegex, String constraints) throws IllegalValueException {
        String trimmedValue = value.trim();
        if(!isValid(trimmedValue, validationRegex)) {
            throw new IllegalValueException(constraints);
        }
        this.value = trimmedValue;
        this.isPrivate = isPrivate;
    }

    private boolean isValid(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
