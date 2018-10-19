import java.io.Serializable;

/**
 * Class to represent the Customers. Attributes: custPHoneNumber, name,
 * customerID
 * 
 * @author Sang Ngo
 *
 */
public class Customer implements Serializable {

	private String custPhoneNumber;
	private String name;
	private int customerID;

	/**
	 * Creates a customer object with the customer information.
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param customerID
	 */
	public Customer(String name, String phoneNumber, int customerID) {
		this.name = name;
		custPhoneNumber = phoneNumber;
		this.customerID = customerID;
	}

	/**
	 * Overloaded constructor with only name and phone number. The customers ID gets
	 * default to 0
	 * 
	 * @param name
	 * @param phoneNumber
	 */
	public Customer(String name, String phoneNumber) {
		this.name = name;
		custPhoneNumber = phoneNumber;
		this.customerID = 0;
	}

	/**
	 * Return customer phone number
	 * 
	 * @return customer's phone number
	 */
	public String getGetPhoneNumber() {
		return custPhoneNumber;
	}

	/**
	 * Set phone number
	 * 
	 * @param getPhoneNumber
	 */
	public void setGetPhoneNumber(String getPhoneNumber) {
		this.custPhoneNumber = getPhoneNumber;
	}

	/**
	 * Return customer name
	 * 
	 * @return customer name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set customer name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return customer's ID
	 * 
	 * @return customer's ID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Set customer's ID
	 * 
	 * @param customerID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * Method to determine if Customers are the "same". this method looks at name
	 * and phoneNumber to determine "sameness".
	 * 
	 * @param c
	 * @return
	 */
	public boolean equals(Customer c) {
		if (this.getName().equals(c.getName()) && this.getGetPhoneNumber() == c.getGetPhoneNumber()) {
			return true;
		}
		return false;
	}

}
