
@SuppressWarnings("serial")
public class Refridgerator extends GenericItem{

	private final int OBJECT_ID = 3;
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
	
}
