import java.io.Serializable;

/**
 * Class to create the Hold object when there is no stock available after an
 * order. Attributes are: customer, washer, quantityRequested
 * 
 * @author Nathan B, Sang, Nathan G
 */
public class Hold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private int quantityRequested;

	/**
	 * Hold constructor to create the hold object
	 * 
	 * @param customer
	 * @param washer
	 * @param quantityRequested
	 */
	public Hold(Customer customer, int quantityRequested) {
		this.customer = customer;
		this.setQuantityRequested(quantityRequested);
	}

	/**
	 * Gets the customer
	 * 
	 * @return customer
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
	 * Get quantity requested
	 * 
	 * @return quantityRequested
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
