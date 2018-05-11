import java.io.*;
import java.util.*;


public class AddressBook {
	
	// the variable to assign saving
	private String filepath;
	// the scanner for searching the text file and editing
	private static Scanner x; 
	
	// addressBook constructor
	public AddressBook() {
		// TODO Auto-generated constructor stub
		this.filepath = "";
	}
	public AddressBook(String filepath) {
		this.filepath = filepath;
	}
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}	
	
	// adding a contact to the address book
	public void addContact(Person contact) {
		
		try {
			// create file that are editable.
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// adds the contact to the addressbook. 
			pw.println(contact.getLastName() + "|" + contact.getFirstName() + "|" + contact.getAddress() + "|"
					+ contact.getCity() + "|" + contact.getState() + "|" + 
					contact.getZip() + "|" + contact.getPhone());
			pw.flush();
			pw.close();
		}
		catch (Exception e) {
			System.out.println("There was aproblem adding the contact to the address book.");
		}
	}
	
	
	
	// removing a contact from the address book
	public void removeContact(Person contact, String searchTerm) {
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
			x.useDelimiter("[|\n]");
			
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
					pw.println(lname + "|" + fname + "|" + addy + "|"
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
	
	// Updating a contact in the address book
	public void updateContact(Person contact, String searchTerm) {
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
			x.useDelimiter("[|\n]");
			
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
					pw.println(lname + "|" + fname + "|" + contact.getAddress() + "|"
							+ contact.getCity() + "|" + contact.getState()+ "|" + 
							contact.getZip() + "|" + contact.getPhone());
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
	
	// sort the addressBook by name
	public void sortByName() {
		
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		try {
			// opens file for reading
			FileReader fr = new FileReader(oldFile);
			BufferedReader br = new BufferedReader(fr); 
			// uses treeMap to sort the lines
			Map<String, String> map = new TreeMap<String, String>(); 
			String line = "";
			
			while ((line = br.readLine()) != null) {
				map.put(getSorterName(line), line);
			}
			br.close();
			
			// creates a new file to write the sorted file to.
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for (String val : map.values()) {
				pw.println(val);
			}
			pw.flush();		// cleans the printer stream
			pw.close();
			oldFile.delete();
			
			// renames the temp file to the address book filepath
			File dump = new File(filepath); 
			newFile.renameTo(dump);
		}
		catch (Exception e) {
			System.out.println("There was an error sorting the address book. :(");
		}
		
	}
	// sorting helper function
	private static String getSorterName(String line) {
		return line.split("|")[0]; // gets the first ele which is lname
	}

	// sort the addressBook by zip
	public void sortByZip() {
		
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		try {
			// opens file for reading
			FileReader fr = new FileReader(oldFile);
			BufferedReader br = new BufferedReader(fr); 
			// uses treeMap to sort the lines
			Map<String, String> map = new TreeMap<String, String>(); 
			String line = "";
			
			while ((line = br.readLine()) != null) {
				map.put(getSorterZip(line), line);
			}
			br.close();
			
			// creates a new file to write the sorted file to.
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for (String val : map.values()) {
				pw.println(val);
			}
			pw.flush();		// cleans the printer stream
			pw.close();
			oldFile.delete();
			
			// renames the temp file to the address book filepath
			File dump = new File(filepath); 
			newFile.renameTo(dump);
		}
		catch (Exception e) {
			System.out.println("There was an error sorting the address book. :(");
		}
		
	}
	// sorting helper function
	private static String getSorterZip(String line) {
		return line.split("|")[5]; // gets the fifth element which is zip
	}
	
	// prints the addressBook to the console
	public void printAddressBook() {
		// prints out the address book
		
		String lname = ""; String fname = ""; String addy = ""; 
		String cty = ""; String state = ""; String zip = ""; 
		String phNum = "";
		
		try {
			x = new Scanner(new File(filepath));
			x.useDelimiter("[|\n]");
			System.out.println(" Address Book: " + filepath);
			
			while (x.hasNext()) {
				
				lname = x.next();
				fname = x.next();
				addy = x.next();
				cty = x.next();
				state = x.next();
				zip = x.next();
				phNum = x.next();
				
				
				System.out.println("Name: " + lname + ", " + fname + '\n' + "Address: " + addy + " " + cty + 
						" " + state + " " + zip + '\n' + "Phone Number: " + phNum + '\n');			
				
			}
		}
		catch (Exception e) {
			System.out.println("There was an error printing out the address book. :(");
		}
		
		
	}
}
