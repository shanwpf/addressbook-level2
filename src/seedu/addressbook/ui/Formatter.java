package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

/**
 * Formats messages to be displayed to the user
 */
public class Formatter {

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Offset to convert from 0-index to 1-index **/
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public Formatter() {}

    /**
     * Formats the message that shows the entered command
     */
    public static String getFormattedEnteredCommand(String input) {
        return formatMessage("[Command entered:" + input + "]");
    }

    /**
     * Formats messages for a consistent UI layout by adding decorations
     */
    private static String formatMessage(String... message) {
        final StringBuilder formatted = new StringBuilder();
        for(String m : message) {
            formatted.append(LINE_PREFIX)
                    .append(m.replace("\n", LS + LINE_PREFIX))
                    .append("\n");
        }

        return formatted.substring(0, formatted.length()-1);
    }

    /**
     * Formats the welcome message
     */
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

    /**
     * Formats the goodbye message
     */
    public static String getFormattedGoodbyeMessage() {
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     * Formats the command result
     */
    public static String getFormattedResult(CommandResult result) {
        return formatMessage(result.feedbackToUser, DIVIDER);
    }

    /**
     * Formats the init failed message
     */
    public static String getFormattedInitFailedMessage() {
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Formats the enter command message
     */
    public static String getEnterCommandMessage() {
        return formatMessage("Enter command: ");
    }

    /**
     * Formats a list of persons
     */
    public static String getFormattedIndexedList(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatMessage(formatted.toString());
    }

    /**
     * Formats an entry from a list of persons
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
