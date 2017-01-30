package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.AddressBlock;
import seedu.addressbook.data.person.AddressStreet;
import seedu.addressbook.data.person.AddressUnit;
import seedu.addressbook.data.person.AddressPostalCode;


/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/275A, Jurong West Street 18, #99-77, 602275";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses format: "
    															+ "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_REGEX = ",";

    public final String value;
    private final AddressBlock addressBlock;
    private final AddressStreet addressStreet;
    private final AddressUnit addressUnit;
    private final AddressPostalCode addressPostalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate; 
        String[] addressPieces = trimmedAddress.split(ADDRESS_SPLIT_REGEX);
        if (!isValidAddress(addressPieces)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.addressBlock = new AddressBlock(addressPieces[0].trim());
        this.addressStreet = new AddressStreet(addressPieces[1].trim());
        this.addressUnit = new AddressUnit(addressPieces[2].trim());
        this.addressPostalCode = new AddressPostalCode(addressPieces[3].trim());
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person Address.
     */
    public static boolean isValidAddress(String[] test) {
    	if(test.length != 4) {
    		return false;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		if(!test[i].matches(ADDRESS_VALIDATION_REGEX)) {
    			return false;
    		}
    	}
    	return true;
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