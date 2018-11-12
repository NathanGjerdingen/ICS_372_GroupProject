
@SuppressWarnings("serial")
public class Dryer extends GenericItem {

	private final int OBJECT_ID = 3;
	private double repairPlanCost;
	
	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Dryer(String brand, String model, double price, double repairPlanCost) {
		super(brand, model, price);
		this.setRepairPlanCost(repairPlanCost);
	}

	@Override
	public String toString() {
		return "Dryer " + super.toString();
	}

	public double getRepairPlanCost() {
		return repairPlanCost;
	}

	public void setRepairPlanCost(double repairPlanCost) {
		this.repairPlanCost = repairPlanCost;
	}

}
