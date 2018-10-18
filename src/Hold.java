/**
 * Class to create the Hold object when there is no stock available after an
 * order. Attributes are: customer, washer, quantityRequested
 *
 */
public class Hold {

	private Customer customer;
	private Washer washer;
	private int quantityRequested;

	/**
	 * Hold constructor to create the hold object
	 * 
	 * @param customer
	 * @param washer
	 * @param quantityRequested
	 */
	public Hold(Customer customer, Washer washer, int quantityRequested) {
		this.customer = customer;
		this.washer = washer;
		this.setQuantityRequested(quantityRequested);
	}

	/**
	 * Gets the customer
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the washer
	 * 
	 * @return
	 */
	public Washer getWasher() {
		return washer;
	}

	/**
	 * Sets the washer
	 * 
	 * @param washer
	 */
	public void setWasher(Washer washer) {
		this.washer = washer;
	}

	/**
	 * Get quantity requested
	 * 
	 * @return
	 */
	public int getQuantityRequested() {
		return quantityRequested;
	}

	/**
	 * Sets the quantity requested
	 * 
	 * @param quantityRequested
	 */
	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

}
