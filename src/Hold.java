
public class Hold {

	private Customer customer;
	private Washer washer;
	
	public Hold(Customer customer, Washer washer) {
		this.customer = customer;
		this.washer = washer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Washer getWasher() {
		return washer;
	}

	public void setWasher(Washer washer) {
		this.washer = washer;
	}

}
