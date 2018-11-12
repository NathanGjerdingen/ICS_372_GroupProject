
@SuppressWarnings("serial")
public class Furnace extends GenericItem {

	private final int OBJECT_ID = 6;
	private double britishThermalUnits;
	private boolean repairPlan = false;
	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Furnace(String brand, String model, double price, double BTU) {
		super(brand, model, price);
		this.britishThermalUnits = BTU;
	}
	
	public boolean isRepairPlan() {
		return repairPlan;
	}

	public void setRepairPlan(boolean repairPlan) {
		this.repairPlan = repairPlan;
	}

	@Override
	public String toString() {
		return "Furnace " + super.toString();
	}


}
