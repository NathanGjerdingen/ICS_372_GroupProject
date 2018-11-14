import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to represent a generic item. Attributes of the class are: brand,
 * model, price, capacity, and stock.
 * 
 */
public abstract class GenericItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int OBJECT_ID = 0;
	private String model;
	private String brand;
	private int capacity;
	private double price;
	private int stock;
	private Queue<Hold> holdQueue = new LinkedList<Hold>();

	/**
	 * Constructor for a generic item that has 3 parameters
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public GenericItem(String brand, String model, double price) {
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.capacity = 0;
		this.stock = 1;
	}
	
	/**
	 * Overloaded constructor for generic item that has 4 parameters,
	 * mainly used for refridgerator class
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param capacity
	 */
	public GenericItem(String brand, String model, double price, int capacity) {
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
		this.stock = 1;
	}
	
	/**
	 * Returns the Hold queue
	 * 
	 * @return holdQueue
	 */
	public Queue<Hold> getHoldQueue() {
		return holdQueue;
	}
	
	/**
	 * Return the object ID number
	 * 
	 * @return OBJECT_ID
	 */
	public int getObjectID() {
		return OBJECT_ID;
	}

	/**
	 * Return the model
	 * 
	 * @return model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Return the brand
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Return the price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Return the stock amount
	 * 
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Return the capacity
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Set the stock
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Add a hold to the hold queue
	 * 
	 * @param hold
	 */
	public void placeHold(Hold hold) {
		holdQueue.add(hold);
	}

	/**
	 * Removes a hold from the hold queue using the member ID
	 * 
	 * @param memberId
	 * @return true if successful, false if failed
	 */
	public boolean removeHold(int memberId) {
		for (Iterator<Hold> iterator = holdQueue.iterator(); iterator
				.hasNext();) {
			Hold hold = iterator.next();
			int id = hold.getCustomer().getCustomerID();
			if (id == memberId) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Return a hold in the hold queue
	 * 
	 * @return hold if successful, null if hold couldn't be found
	 */
	public Hold getNextHold() {
		for (Iterator<Hold> iterator = holdQueue.iterator(); iterator.hasNext();) {
			Hold hold = iterator.next();
			iterator.remove();
			return hold;
		}
		return null;
	}

	/**
	 * Check if there is a hold in queue
	 * 
	 * @return true if there is a hold, false otherwise
	 */
	public boolean hasHold() {
		Iterator<Hold> iterator = holdQueue.iterator();
		return (iterator.hasNext());
	}

	public Iterator<Hold> getHolds() {
		return holdQueue.iterator();
	}

	/**
	 * toString to print out the item description
	 */
	@Override
	public String toString() {
		if (getCapacity() == 0) {
			return "[brand= " + brand + ",model=" + model + ", price= " + price + "]";
		} else {
			return "[brand= " + brand + ",model=" + model + ", capacity= " + capacity + ", price= " + price + "]";
		}
	}
	
	/**
	 * Check if two item are equal
	 * 
	 * @param g
	 * @return true if equal, false otherwise
	 */
	public boolean equals(GenericItem g) {
		if (this.brand.equals(g.getBrand()) && this.model.equals(g.getModel())) {
			return true;
		}
		return false;
	}

	/**
	 * Create a visitor of a generic type
	 * 
	 * @param visitor
	 */
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}
}
