
public class Customer {

	private int custPhoneNumber;
	private String name;
	private int customerID;

	/**
	 * Creates a customer object with the customer information.
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param customerID
	 */
	public Customer(String name, int phoneNumber, int customerID) {
		this.name = name;
		custPhoneNumber = phoneNumber;
		this.customerID = customerID;
	}

	/**
	 * Return customer phone number
	 * 
	 * @return customer's phone number
	 */
	public int getGetPhoneNumber() {
		return custPhoneNumber;
	}

	/**
	 * Set phone number
	 * 
	 * @param getPhoneNumber
	 */
	public void setGetPhoneNumber(int getPhoneNumber) {
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

}
