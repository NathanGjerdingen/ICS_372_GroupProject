import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class GenericItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String model;
	private String brand;
	private double price;
	private int stock;
	private Queue<Hold> holdQueue = new LinkedList<Hold>();
	private Queue<Customer> repairPlanQueue = new LinkedList<Customer>();

	public GenericItem(String brand, String model, double price) {
		this.price = price;
		this.brand = brand;
		this.model = model;
		this.stock = 1;
	}
	
	public Queue<Hold> getHoldQueue() {
		return holdQueue;
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
		return "GenericItem [model=" + model + ", price=" + price + "]";
	}
	
	public boolean equals(GenericItem g) {
		if (this.brand.equals(g.getBrand()) && this.model.equals(g.getModel())) {
			return true;
		}
		return false;
	}

//	public void accept(LoanableItemVisitor visitor) {
//		visitor.visit(this);
//	}
}
