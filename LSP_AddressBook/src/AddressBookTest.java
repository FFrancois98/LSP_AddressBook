import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import org.junit.*;

public class AddressBookTest {
	
	private static Scanner x;

	@Test
	public void testAddressBookString() {
		String localpath = System.getProperty("user.home");
		String filepath = "\\mikeThings.txt";
		AddressBook monday = new AddressBook(localpath + filepath);
		assertTrue(monday instanceof AddressBook);
		assertEquals(monday.getFilepath(), localpath + filepath);	
		
	}

	@Test
	public void testAddContact() {
		
		String localpath = System.getProperty("user.home");
		String filepath = "\\joeThings.txt";
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
			x.close();
			
			tuesday.addContact(contact);
			
			x = new Scanner(new File(localpath + filepath));
			x.useDelimiter("[\n]");
			
			while (x.hasNextLine()) {	
				lastline2 = x.nextLine();
			}
			x.close();
			
			assertNotEquals(lastline, lastline2);
			
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Add Contact function.");
		}
		
	}

	@Test
	public void testRemoveContact() {
		
		String localpath = System.getProperty("user.home");
		String filepath = "\\chrisThings.txt";
		AddressBookMenu controller = new AddressBookMenu();
		AddressBook wendesday = controller.createAddressBook(localpath + filepath);
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington", "DC", "20059", "(953) 023 - 3465");
		Person contact2 = new Person("Harry", "Parker", "345 St. Marks Road", "Washington", "DC", "20001", "(953) 834 - 2837");
		
		String searchTerm = "Howard";		
		
		try {
			
			wendesday.addContact(contact);
			wendesday.addContact(contact2);
			wendesday.removeContact(searchTerm);
			
			Scanner scan = new Scanner(new File(localpath + filepath));
			while (scan.hasNext()) {
				String line = scan.nextLine();
				assertFalse(line.contains(searchTerm));
			}
			scan.close();		
						
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Remove Contact function.");
		}
		
		
	}

	@Test
	public void testUpdateContact() {
		
		
		String localpath = System.getProperty("user.home");
		String filepath = "\\bobThings.txt";
		AddressBookMenu controller = new AddressBookMenu();
		AddressBook thursday = controller.createAddressBook(localpath + filepath);
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington", "DC", "20059", "(953) 023 - 3465");
		Person contact2 = new Person("Harry", "Parker", "345 St. Marks Road", "Washington", "DC", "20001", "(953) 834 - 2837");
		Person contact3 = new Person("Harry", "Parker", "456 St. Andrews Lane", "Bethesada", "Maryland", "20090", "(953) 098 - 3265");
		String searchTerm = "Parker";		
		
		try {
			
			thursday.addContact(contact);
			thursday.addContact(contact2);
			thursday.updateContact(contact3, searchTerm);
			
			Scanner scan = new Scanner(new File(localpath + filepath));
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if(line.contains(searchTerm)) {
					assertTrue(line.contains(contact2.getFirstName()));
					assertFalse(line.contains(contact2.getAddress()));
					assertFalse(line.contains(contact2.getCity()));
					assertFalse(line.contains(contact2.getState()));
					assertFalse(line.contains(contact2.getZip()));
					assertFalse(line.contains(contact2.getPhone()));
				}
			}
			scan.close();		
						
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Remove Contact function.");
		}
	}

	@Test
	public void testSortByName() {
		
		String localpath = System.getProperty("user.home");
		String filepath = "\\jackThings.txt";
		AddressBookMenu controller = new AddressBookMenu();
		AddressBook friday = controller.createAddressBook(localpath + filepath);
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington", "DC", "20059", "(953) 023 - 3465");
		Person contact2 = new Person("Harry", "Parker", "345 St. Marks Road", "Washington", "DC", "20001", "(953) 834 - 2837");
		Person contact3 = new Person("Chris", "Johnson", "456 St. Andrews Lane", "Bethesada", "Maryland", "20090", "(953) 098 - 3265");
		
		
		ArrayList<String> unSorted = new ArrayList<String>();
		ArrayList<String> Sorted = new ArrayList<String>();
		
		
		try {
			
			friday.addContact(contact);
			friday.addContact(contact2);
			friday.addContact(contact3);
			
			Scanner scan = new Scanner(new File(localpath + filepath));
			
			while (scan.hasNext()) {
				String line = scan.nextLine();
				unSorted.add(line);
			}
			scan.close();		
						
			friday.sortByName();
			
			Scanner scan2 = new Scanner(new File(localpath + filepath));
			
			while (scan2.hasNext()) {
				String line = scan2.nextLine();
				Sorted.add(line);
			}
			scan2.close();
			
			assertNotEquals(Sorted, unSorted);
			
			
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Update Contact function.");
		}
		
	}

	@Test
	public void testSortByZip() {
		
		String localpath = System.getProperty("user.home");
		String filepath = "\\anitaThings.txt";
		AddressBookMenu controller = new AddressBookMenu();
		AddressBook friday = controller.createAddressBook(localpath + filepath);
		Person contact = new Person("Beau", "Howard", "250 Lancer Avenue", "Washington", "DC", "20059", "(953) 023 - 3465");
		Person contact2 = new Person("Harry", "Parker", "345 St. Marks Road", "Washington", "DC", "20001", "(953) 834 - 2837");
		Person contact3 = new Person("Chris", "Johnson", "456 St. Andrews Lane", "Bethesada", "Maryland", "20090", "(953) 098 - 3265");
		
		
		ArrayList<String> unSorted = new ArrayList<String>();
		ArrayList<String> Sorted = new ArrayList<String>();
		
		try {
			
			friday.addContact(contact);
			friday.addContact(contact2);
			friday.addContact(contact3);
			
			Scanner scan = new Scanner(new File(localpath + filepath));
			
			while (scan.hasNext()) {
				String line = scan.nextLine();
				unSorted.add(line);
			}
			scan.close();		
						
			friday.sortByZip();
			
			Scanner scan2 = new Scanner(new File(localpath + filepath));
			
			while (scan2.hasNext()) {
				String line = scan2.nextLine();
				Sorted.add(line);
			}
			scan2.close();
			
			assertNotEquals(Sorted, unSorted);
			
			
		}
		catch (Exception e) {
			System.out.println("There was a problem testing the Update Contact function.");
		}
		
		
	}

}
