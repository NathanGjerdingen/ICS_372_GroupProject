
@SuppressWarnings("serial")
public class Dishwasher extends GenericItem{

	private final int OBJECT_ID = 2;
	
	/**
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param repairPlanCost 
	 */
	public Dishwasher(String brand, String model, double price) {
		super(brand, model, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Dishwasher " + super.toString();
	}
	
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}
	
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}

}
