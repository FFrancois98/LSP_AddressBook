import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
	// person Array
	Person  persons[];
	int count; 	// array counter
	boolean needSave; // the variable to assign saving
	
	private static Scanner x; // the scanner for searching the text file and editing
	
	public AddressBook() {
		// TODO Auto-generated constructor stub
		this.count = 0;
		this.needSave = false;
	}
	
	public void addContact(Person contact, String filepath, int inx) {
		
		try {
			// create file that are editable.
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// adds the contact to the addressbook. 
			pw.println(contact.lastName + "," + contact.firstName + "|" + contact.address + "|"
					+ contact.city + "|" + contact.state + "|" + 
					contact.zip + "|" + contact.phone);
			pw.flush();
			pw.close();
		}
		catch (Exception e) {
			System.out.println("There was aproblem adding the contact to the address book.");
		}
	}
	// get - set for boolean
	public boolean isNeedSave() {
		return needSave;
	}
	public void setNeedSave(boolean needSave) {
		this.needSave = needSave;
	}
	
	public void removeContact(Person contact, String searchTerm, String filepath, int inx) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		String lname = ""; String fname = ""; String addy = ""; 
		String cty = ""; String state = ""; String zip = ""; 
		String phNum = "";
		
		try {
			// create file that are editable.
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// creates a scanner to read the file
			x = new Scanner(new File(filepath));
			x.useDelimiter("[|,\n]");
			
			while(x.hasNext()) {
				// reads in the current address book info
				lname = x.next();
				fname = x.next();
				addy = x.next();
				cty = x.next();
				state = x.next();
				zip = x.next();
				phNum = x.next();
				
				if (!lname.equals(searchTerm)) {
					// if the contact is not being deleted, the contact is
					// printed to the new temp file. if the contact is
					// being deleted, it is ignored and not rinted in the
					// new file.
					pw.println(lname + "," + fname + "|" + addy + "|"
							+ cty + "|" + state	+ "|" + zip + "|" + phNum);
				}
				
			}
			
			x.close();		// closes the scanner
			pw.flush();		// cleans the printer stream
			pw.close();		// closes the printer
			oldFile.delete();	// deletes the current the address book
			
			// renames the temp file to the address book filepath
			File dump = new File(filepath); 
			newFile.renameTo(dump);
		}
		catch(Exception e) {
			System.out.println("There was an error with removing the contact from the address book. :(");
		}
		
	}
	
	public void updateContact(Person contact, String searchTerm, String filepath, int inx) {
		String tempFile = "temp.txt"; 		// creates a temp address book txt file
		File oldFile = new File(filepath);	// the current address book being edited
		File newFile = new File(tempFile);  // the new edited address book 
		
		// the variable for the current address book
		String lname = ""; String fname = ""; String addy = ""; 
		String cty = ""; String state = ""; String zip = ""; 
		String phNum = "";
		
		try {
			// create file that are editable.
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// creates a scanner to read the file
			x = new Scanner(new File(filepath));
			x.useDelimiter("[|,\n]");
			
			while (x.hasNext()) {
				// reads in the current address book info
				lname = x.next();
				fname = x.next();
				addy = x.next();
				cty = x.next();
				state = x.next();
				zip = x.next();
				phNum = x.next();
				
				if (lname.equals(searchTerm)) {
					// searches and checks the last name. 
					// if true, the contact is edited and printed to the
					// temp address book file.
					pw.println(lname + "," + fname + "|" + contact.address + "|"
							+ contact.city + "|" + contact.state + "|" + 
							contact.zip + "|" + contact.phone);
				}
				else {
					// if not true, the current contact is just printed
					// in the temp file.
					
					pw.println(lname + "," + fname + "|" + addy + "|"
							+ cty + "|" + state	+ "|" + zip + "|" + phNum);
				}
			}
			x.close();		// closes the scanner
			pw.flush();		// cleans the printer stream
			pw.close();		// closes the printer
			oldFile.delete();	// deletes the current the address book
			
			// renames the temp file to the address book filepath
			File dump = new File(filepath); 
			newFile.renameTo(dump);
			
		}
		catch (Exception e) {
			
			// if there is an error read an creating the files,
			// it doesn't cause memory leaks, and crash the program.
			System.out.println("There was an error updating the contact. :(");
		}
		
	}

}
