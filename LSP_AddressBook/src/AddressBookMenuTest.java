import static org.junit.Assert.*;
import java.io.*;

import org.junit.*;

public class AddressBookMenuTest {

	@Test
	public void testCreateAddressBook() {
		// test if the AddressBook class was created and if the file
		// is on the system.
		
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "mikeStuff.txt";
		String filepath2 = "johnStuff.txt";
		
		String localpath = "C:\\Users\\Surface User\\Desktop\\";
		
		
		AddressBook Monday = controller.createAddressBook(localpath + filepath);
		AddressBook Tuesday = controller.createAddressBook(localpath + filepath2);
		assertTrue(Monday instanceof AddressBook);
		assertTrue(Tuesday instanceof AddressBook);
		assertTrue(controller.createAddressBook(localpath + filepath) instanceof AddressBook);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testOpenAddressBook() {
		
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "chrisStuff.txt";
		String filepath2 = "joeyStuff.txt";
		
		File Monday = controller.openAddressBook(filepath);
		File Tuesday = controller.openAddressBook(filepath2);
		assertTrue(Monday instanceof File);
		assertTrue(Tuesday instanceof File);
		assertTrue(controller.openAddressBook(filepath) instanceof File);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSaveAddressBook() {
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "floStuff.txt";
		String localpath = "C:\\Users\\Surface User\\Desktop\\";
		File Monday = controller.openAddressBook(localpath + filepath);
		
		long fileTime = Monday.lastModified();
		
		controller.saveAddressBook(localpath + filepath);
		
		long fileTime2 = Monday.lastModified();
		
		assertNotEquals(fileTime, fileTime2); // compares the time stamp on the file before and after saving
		
		
		//fail("Not yet implemented");
	}

}
