
@SuppressWarnings("serial")
public class Refridgerator extends GenericItem{

	private final int OBJECT_ID = 5;
	private double capacity;
	
	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Refridgerator(String brand, String model, double price, double capacity) {
		super(brand, model, price);
		this.capacity = capacity;
	}	
	
	@Override
	public String toString() {
		return "Refridgerator " + super.toString();
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
