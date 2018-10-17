
public class Hold {

	private Customer customer;
	private Washer washer;
	private int quantityRequested;

	public Hold(Customer customer, Washer washer, int quantityRequested) {
		this.customer = customer;
		this.washer = washer;
		this.setQuantityRequested(quantityRequested);
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

	public int getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

}
