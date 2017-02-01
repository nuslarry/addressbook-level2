package seedu.addressbook.ui;

import java.util.List;

public class Formatter {
	
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private  static final String LINE_PREFIX = "|| "; 
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    
    private static final String DIVIDER = "===================================================";
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    private static final String COMMAND_PROMPT = "Enter command: ";
    private static final String COMMAND_ECHO = "Command entered:";
    
    
    /** Formats a single message for user */
    public static String formatUserMessage(String message) {
         return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 1;
        for (String listItem : listItems) {
            formatted.append(formatIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    public static String getLinePrefix(){
    	return LINE_PREFIX;
    }
    public static String getLs(){
    	return LS;
    }  
    public static String getDivider(){
    	return DIVIDER;
    }  
    public static String getCommandPrompt(){
    	return COMMAND_PROMPT;
    }  
    public static String getCommandEcho(){
    	return COMMAND_ECHO;
    }  
}