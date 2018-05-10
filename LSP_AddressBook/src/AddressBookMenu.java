import java.io.*;
import java.util.*;

public class AddressBookMenu {
	// creates the addressBook
	public AddressBook createAddressBook(String filepath) {
		return new AddressBook(filepath);
	}
	
	// opens the addressBook
	public File openAddressBook(String filepath) { 
		return new File(filepath);
	}
	
	// saves the addressBook
	public void saveAddressBook(String filepath) {
		
		try {
			String tempFile = "temp.txt";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			Scanner sc = new Scanner(oldFile);
			PrintWriter pw = new PrintWriter(newFile);
			
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				pw.write(s);
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
