import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to represent a Washing Machine. Attributes of the class are: brand,
 * modelName, and price, and stock.
 * 
 * @author Nathan C. Bishop
 * @author Nathan Gjerdingen
 * @author Sang Ngo
 */
@SuppressWarnings("serial")
public class Washer extends GenericItem implements Serializable {

	private final int OBJECT_ID = 1;
	private double repairPlanCost;
	
	/**
	 * Washer takes in a brand, modelName, price when instantiated. Stock is set to
	 * 1 immediately, because when introducing a new washer to the system you will
	 * likely be stocking it to at least 1.
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Washer(String brand, String model, double price, double repairPlanCost) {
		super(brand, model, price);
		this.setRepairPlanCost(repairPlanCost);
	}

	/**
	 * Overloaded constructor for washer. Mainly used for checking if to washers are
	 * equal to each other in Business class.
	 * 
	 * @param brand
	 * @param modelName
	 */
	public Washer(String brand, String model) {
		super(brand, model, 0);
	}

	
	@Override
	public String toString() {
		return "Washer " + super.toString();
	}
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}

	public double getRepairPlanCost() {
		return repairPlanCost;
	}

	public void setRepairPlanCost(double repairPlanCost) {
		this.repairPlanCost = repairPlanCost;
	}
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}
	
}
