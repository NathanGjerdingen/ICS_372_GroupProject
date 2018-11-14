/**
 * Class to represent a refrigerator. Attributes of the class are: brand, model,
 * price, and repairPlanCost.
 * 
 * @author Nathan B, Sang, Nathan G
 */
@SuppressWarnings("serial")
public class Dryer extends GenericItem {

	private final int OBJECT_ID = 3;
	private double repairPlanCost;

	/**
	 * Constructor for Dryer that takes 3 parameters
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Dryer(String brand, String model, double price, double repairPlanCost) {
		super(brand, model, price);
		this.setRepairPlanCost(repairPlanCost);
	}

	/**
	 * toString to print Dryer's details
	 */
	@Override
	public String toString() {
		return "Dryer " + super.toString();
	}

	/**
	 * Returns repairPlanCost of Dryer
	 * 
	 * @return repairPlanCost
	 */
	public double getRepairPlanCost() {
		return repairPlanCost;
	}

	/**
	 * Sets the price for repair plan
	 * 
	 * @param repairPlanCost
	 */
	public void setRepairPlanCost(double repairPlanCost) {
		this.repairPlanCost = repairPlanCost;
	}

	/**
	 * Return Dryer's object ID number
	 */
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}

	/**
	 * Creates a visitor of type Dryer
	 */
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}

}
