package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TypicalPersons;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private AddressBook addressBook;
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        // Before sorting: bill, amy, dan, candy
        // Expected after sorting: amy, bill, candy, dan
        assertSortCommandBehavior(new UniquePersonList(td.amy, td.bill, td.candy, td.dan));
    }

    /**
     * Executes the sort command for the given address book and verifies
     * the order of persons in result matches persons in the expectedPersonList exactly.
     */
    private void assertSortCommandBehavior(UniquePersonList expectedPersonList) {
        SortCommand command = createSortCommand();
        command.execute();
        assertEquals(addressBook.getAllPersons(), expectedPersonList);
    }

    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        this.addressBook = new TypicalPersons().getTypicalAddressBook();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
