
public class Person {
	private String firstName; 
	private String lastName;
	private String address; 
	private String city; 
	private String state;
	private String zip; 
	private String phone;
	
	public Person() {
		// TODO Auto-generated constructor stub
		firstName = "";
		lastName = "";
		address = "";
		city = "";
		state = "";
		zip = "";
		phone = "";
	}
	
	public Person(String firstName, String lastName, String address,
			String city, String state, String zip, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	// First name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// Last name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// Address of Residence
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	// City of Residence
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	// State of Residence
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	// Zip code of Residence
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	// Phone of Residence
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
