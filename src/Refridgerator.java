/**
 * Class to represent a refrigerator. Attributes of the class are: brand, model,
 * price, and capacity.
 * 
 * @author Nathan B, Sang, Nathan G
 */
@SuppressWarnings("serial")
public class Refridgerator extends GenericItem {

	private final int OBJECT_ID = 5;
	private double capacity;

	/**
	 * Constructor for Refridgerator that takes 3 parameters
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Refridgerator(String brand, String model, double price, double capacity) {
		super(brand, model, price);
		this.capacity = capacity;
	}

	/**
	 * toString to print Refridgerator's details
	 */
	@Override
	public String toString() {
		return "Refridgerator " + super.toString();
	}

	/**
	 * Return Refridgerator object ID number
	 */
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}

	/**
	 * Create a visitor of type Refridgerator
	 */
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}

}
