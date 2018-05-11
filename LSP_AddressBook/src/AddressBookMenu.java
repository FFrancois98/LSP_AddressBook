import java.io.*;
import java.util.*;

public class AddressBookMenu {
	// creates the addressBook and creates the text file
	public AddressBook createAddressBook(String filepath) {
		// creates the new address book text file
		try {
			File newFile = new File(filepath);
			PrintWriter pw = new PrintWriter(newFile);
			
			pw.println();
			pw.flush();
			pw.close();
			
		}
		catch (Exception e) {
			System.out.println("There was an error creating the address book text file. :(");
		}
		
		//saveAddressBook("C:\\Users\\Surface User\\Desktop\\" + filepath);
		return new AddressBook(filepath);
	}
	
	// opens the addressBook and makes it ready for writing and reading to
	public File openAddressBook(String filepath) { 
		return new File(filepath);
	}
	
	// saves the addressBook to a text file
	public void saveAddressBook(String filepath) {
		
		try {
			String tempFile = "temp.txt";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			Scanner sc = new Scanner(oldFile);
			PrintWriter pw = new PrintWriter(newFile);
			
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				pw.println(s);
			}
			sc.close();
			pw.flush();
			pw.close();			
			oldFile.delete();	// deletes the current the address book
			
			// renames the temp file to the address book filepath
			File dump = new File(filepath); 
			newFile.renameTo(dump);
			
		}
		catch (Exception e) {
			System.out.println("There was an error saving the file. :(");
		}
			
		
	}
}
