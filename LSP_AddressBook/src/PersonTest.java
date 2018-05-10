import static org.junit.Assert.*;

import org.junit.*;

public class PersonTest {

	@Test
	public void testPerson() {
		Person contact = new Person();
		
		assertEquals("", contact.getLastName());
		assertEquals("", contact.getFirstName());
		assertEquals("", contact.getAddress());
		assertEquals("", contact.getCity());
		assertEquals("", contact.getState());
		assertEquals("", contact.getZip());
		assertEquals("", contact.getPhone());
		
		//fail("Not yet implemented");
	}

	@Test
	public void testPersonStringStringStringStringStringStringString() {
				
		Person contact = new Person("Bob", "Gordon", "2225 4th Street NW",
				"Washington", "DC", "20059", "(718) 567 - 8231");
		
		assertEquals("Gordon", contact.getLastName());
		assertEquals("Bob", contact.getFirstName());
		assertEquals("2225 4th Street NW", contact.getAddress());
		assertEquals("Washington", contact.getCity());
		assertEquals("DC", contact.getState());
		assertEquals("20059", contact.getZip());
		assertEquals("(718) 567 - 8231", contact.getPhone());
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFirstName() {
		Person contact = new Person();
		
		contact.setAddress("2300 Georgia Avenue");
		contact.setCity("Washington");
		contact.setPhone("(929) 234 - 6745");
		
		assertEquals("2300 Georgia Avenue", contact.getAddress());
		assertEquals("Washington", contact.getCity());
		assertEquals("(929) 234 - 6745", contact.getPhone()); 
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSetFirstName() {
		Person contact = new Person();
		
		contact.setAddress("2300 Georgia Avenue");
		contact.setCity("Washington");
		contact.setPhone("(929) 234 - 6745");
		
		assertEquals("2300 Georgia Avenue", contact.getAddress());
		assertEquals("Washington", contact.getCity());
		assertEquals("(929) 234 - 6745", contact.getPhone());
		
		//fail("Not yet implemented");
	}

}
