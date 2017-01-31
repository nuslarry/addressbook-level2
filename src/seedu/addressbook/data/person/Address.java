package seedu.addressbook.data.person;

import seedu.addressbook.data.person.AddressBlock;
import seedu.addressbook.data.person.AddressStreet;
import seedu.addressbook.data.person.AddressUnit;
import seedu.addressbook.data.person.AddressPostalCode;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/311, Clementi Ave 2, #02-25, 999999";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Adress Format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SEPARATOR = ",";

    public final String value;
    private boolean isPrivate;
    private final AddressBlock addressBlock;
    private final AddressStreet addressStreet;
    private final AddressUnit addressUnit;
    private final AddressPostalCode addressPostalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        String[] addressElements = trimmedAddress.split(ADDRESS_SEPARATOR);
        if (!isValidAddress(addressElements)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.addressBlock = new AddressBlock(addressElements[0]);
        this.addressStreet = new AddressStreet(addressElements[1]);
        this.addressUnit = new AddressUnit(addressElements[2]);
        this.addressPostalCode = new AddressPostalCode(addressElements[3]);
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String[] stringArray) {
    	boolean ans=true;
    	if(stringArray.length!=4)ans=false;
	   	for(int i = 0; i < stringArray.length; i++) {
		     if(!stringArray[i].matches(ADDRESS_VALIDATION_REGEX)) {
		    			ans=false;
		     }
		}
	   	return ans;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
	   public String getAddressBlock() {
    	return addressBlock.getValue();
    }
    
    public String getAddressUnit() {
    	return addressUnit.getValue();
    }
    
    public String getAddressStreet() {
    	return addressStreet.getValue();
    }
    
    public String getAddressPostalCode() {
    	return addressPostalCode.getValue();
   }
}
