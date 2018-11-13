import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class GenericItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int OBJECT_ID = 0;
	private String model;
	private String brand;
	private int capacity;
	private double price;
	private int stock;
	private Queue<Hold> holdQueue = new LinkedList<Hold>();

	public GenericItem(String brand, String model, double price) {
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.capacity = 0;
		this.stock = 1;
	}
	
	public GenericItem(String brand, String model, double price, int capacity) {
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.capacity = capacity;
		this.stock = 1;
	}
	
	public Queue<Hold> getHoldQueue() {
		return holdQueue;
	}
	
	public int getObjectID() {
		return OBJECT_ID;
	}

	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	public void placeHold(Hold hold) {
		holdQueue.add(hold);
	}

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

	public Hold getNextHold() {
		for (Iterator<Hold> iterator = holdQueue.iterator(); iterator.hasNext();) {
			Hold hold = iterator.next();
			iterator.remove();
			return hold;
		}
		return null;
	}

	public boolean hasHold() {
		Iterator<Hold> iterator = holdQueue.iterator();
		return (iterator.hasNext());
	}

	public Iterator<Hold> getHolds() {
		return holdQueue.iterator();
	}

	@Override
	public String toString() {
		if (getCapacity() == 0) {
			return "[brand= " + brand + ",model=" + model + ", price= " + price + "]";
		} else {
			return "[brand= " + brand + ",model=" + model + ", capacity= " + capacity + ", price= " + price + "]";
		}
	}
	
	public boolean equals(GenericItem g) {
		if (this.brand.equals(g.getBrand()) && this.model.equals(g.getModel())) {
			return true;
		}
		return false;
	}

	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}
}
