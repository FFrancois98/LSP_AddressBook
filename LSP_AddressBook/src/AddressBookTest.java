import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import org.junit.*;

public class AddressBookTest {
	
	private static Scanner x;

	@Test
	public void testAddressBookString() {
		
		String localpath = "C:\\Users\\Surface User\\Desktop\\";
		String filepath = "mikeThings.txt";
		AddressBook monday = new AddressBook(localpath + filepath);
		assertTrue(monday instanceof AddressBook);
		assertEquals(monday.getFilepath(), localpath + filepath);	
		
	}

	@Test
	public void testAddContact() {
		
		String localpath = "C:\\Users\\Surface User\\Desktop\\";
		String filepath = "joeThings.txt";
		AddressBookMenu controller = new AddressBookMenu();
		AddressBook tuesday = controller.createAddressBook(localpath + filepath);
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington"
				,"DC", "20059", "(953) 023 - 3465");
		String lastline = " "; String lastline2  = " ";
		
		try {
			x = new Scanner(new File(localpath + filepath));
			x.useDelimiter("[\n]");
			
			while (x.hasNextLine()) {	
				lastline = x.nextLine();
			}
			System.out.println(lastline);
			x.close();
			
			tuesday.addContact(contact);
			
			x = new Scanner(new File(localpath + filepath));
			x.useDelimiter("[\n]");
			
			while (x.hasNextLine()) {	
				lastline2 = x.nextLine();
			}
			System.out.println(lastline2);
			x.close();
			
			assertNotEquals(lastline, lastline2);
			
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Add Contact function.");
		}
		
	}

	@Test
	public void testRemoveContact() {
		
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateContact() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSortByName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSortByZip() {
		//fail("Not yet implemented");
	}

}
