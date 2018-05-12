import static org.junit.Assert.*;
import java.io.*;

import org.junit.*;

public class AddressBookMenuTest {

	@Test
	public void testCreateAddressBook() {
		// test if the AddressBook class was created and if the file
		// is on the system.
		
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "\\mikeStuff.txt";
		String filepath2 = "\\johnStuff.txt";
		
		String localpath = System.getProperty("user.home");
		
		
		AddressBook Monday = controller.createAddressBook(localpath + filepath);
		AddressBook Tuesday = controller.createAddressBook(localpath + filepath2);
		assertTrue(Monday instanceof AddressBook);
		assertTrue(Tuesday instanceof AddressBook);
		assertTrue(controller.createAddressBook(localpath + filepath) instanceof AddressBook);
		
		
	}

	@Test
	public void testOpenAddressBook() {
		
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "\\chrisStuff.txt";
		String filepath2 = "\\joeyStuff.txt";
		
		File Monday = controller.openAddressBook(filepath);
		File Tuesday = controller.openAddressBook(filepath2);
		assertTrue(Monday instanceof File);
		assertTrue(Tuesday instanceof File);
		assertTrue(controller.openAddressBook(filepath) instanceof File);
		
	}

	@Test
	public void testSaveAddressBook() {
		AddressBookMenu controller = new AddressBookMenu();
		String filepath = "\\floStuff.txt";
		String localpath = System.getProperty("user.home");
		
		AddressBook mndy = controller.createAddressBook(localpath + filepath);
		File Monday = controller.openAddressBook(localpath + filepath);
		
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington", "DC", "20059", "(953) 023 - 3465");
		Person contact2 = new Person("Harry", "Parker", "345 St. Marks Road", "Washington", "DC", "20001", "(953) 834 - 2837");
		Person contact3 = new Person("Chris", "Johnson", "456 St. Andrews Lane", "Bethesada", "Maryland", "20090", "(953) 098 - 3265");
		
		mndy.addContact(contact);
		mndy.addContact(contact2);
		mndy.addContact(contact3);
		
		
		
		long fileTime = Monday.lastModified();
		
		controller.saveAddressBook(localpath + filepath);
		
		long fileTime2 = Monday.lastModified();
		
		assertNotEquals(fileTime, fileTime2); // compares the time stamp on the file before and after saving
		
		
	}

}
