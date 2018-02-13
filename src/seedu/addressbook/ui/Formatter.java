package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

public class Formatter {

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public Formatter() {}

    public static String getFormattedEnteredCommand(String input) {
        return LINE_PREFIX + "[Command entered: " + input + "]";
    }

    private static String formatMessage(String... message) {
        final StringBuilder formatted = new StringBuilder();
        for(String m : message) {
            formatted.append(LINE_PREFIX)
                    .append(m.replace("\n", LS + LINE_PREFIX))
                    .append("\n");
        }
        return formatted.toString().trim();
    }

    public static String getFormattedWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessage(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER
        );
    }

    public static String getFormattedGoodbyeMessage() {
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    public static String getFormattedResult(CommandResult result) {
        return formatMessage(result.feedbackToUser, DIVIDER);
    }

    public static String getFormattedInitFailedMessage() {
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    public static String getEnterCommandMessage() {
        return LINE_PREFIX + "Enter command: ";
    }

    public static String getFormattedIndexedList(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatMessage(formatted.toString());
    }

    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
