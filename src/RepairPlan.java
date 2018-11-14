import java.io.Serializable;
/**
 * Class to represent the repair plan. Attributes of the class are: customer and item.
 * 
 */
public class RepairPlan implements Serializable {

	private Customer customer;
	private GenericItem item;
	
	/**
	 * Constructor for RepairPlan that takes 2 parameters
	 * 
	 * @param customer
	 * @param item
	 */
	public RepairPlan(Customer customer, GenericItem item) {
		this.setCustomer(customer);
		this.setItem(item);
	}
	
	/**
	 * Returns the customer
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Set the customer
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * Return the generic item (appliance)
	 * 
	 * @return item
	 */
	public GenericItem getItem() {
		return item;
	}
	
	/**
	 * Set the generic item (appliance)
	 * 
	 * @param item
	 */
	public void setItem(GenericItem item) {
		this.item = item;
	}
	
}
