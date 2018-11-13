import java.io.Serializable;

public class RepairPlan implements Serializable {

	private Customer customer;
	private GenericItem item;
	public RepairPlan(Customer customer, GenericItem item) {
		this.setCustomer(customer);
		this.setItem(item);
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public GenericItem getItem() {
		return item;
	}
	public void setItem(GenericItem item) {
		this.item = item;
	}
	
}
