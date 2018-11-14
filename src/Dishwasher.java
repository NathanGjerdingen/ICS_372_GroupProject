/**
 * Class to represent a refrigerator. Attributes of the class are: brand,
 * model, and price.
 * 
 */
@SuppressWarnings("serial")
public class Dishwasher extends GenericItem{

	private final int OBJECT_ID = 2;
	
	/**
	 * Constructor for Dishwaser that takes in 3 parameters
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param repairPlanCost 
	 */
	public Dishwasher(String brand, String model, double price) {
		super(brand, model, price);
	}
	
	/**
	 * toString to print Dishwasher's details
	 */
	@Override
	public String toString() {
		return "Dishwasher " + super.toString();
	}
	
	/**
	 * Returns Dishwasher's object ID number
	 */
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}
	
	/**
	 * Creates a visitor of type Dishwasher
	 */
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}

}
