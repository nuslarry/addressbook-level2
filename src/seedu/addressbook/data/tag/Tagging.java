package seedu.addressbook.data.tag;
import seedu.addressbook.data.person.Person;

import java.util.ArrayList;

//an association class related Tag,Person
public class Tagging {
	private Person person;
	private Tag tag;
	private TagOperationFlag operation;

	/**
	 * Common container for all tagging association
	 */
	private static ArrayList<Tagging> TaggingList;

	private static enum TagOperationFlag {
		addTag, deleteTag
	}

	public Tagging(Person person, Tag tag, TagOperationFlag operation) {
		this.person = person;
		this.tag = tag;
		this.operation = operation;
	}

	public static Tagging addTagging(Person person, Tag tag, int operation) {
		Tagging tagging = new Tagging(person, tag, Tagging.TagOperationFlag.addTag);
		TaggingList.add(tagging);
		return tagging;
	}

	public static Tagging deleteTagging(Person person, Tag tag, int operation) {
		Tagging tagging = new Tagging(person, tag, Tagging.TagOperationFlag.deleteTag);
		TaggingList.add(tagging);
		return tagging;
	}
	public static String printAllTagging(){
		String returnString="";
		String space=" ";
		String newLine="\n";
		for(int i=0; i<TaggingList.size(); i++){
			if(TaggingList.get(i).operation==Tagging.TagOperationFlag.addTag){
				returnString+="+";				
			}else if(TaggingList.get(i).operation==Tagging.TagOperationFlag.deleteTag){
				returnString+="-";
			}
			returnString+=space;
			returnString+=TaggingList.get(i).person.getName();
			returnString+=space;
			returnString+=TaggingList.get(i).tag.toString();
			returnString+=newLine;
       }
		return returnString;
	}

}