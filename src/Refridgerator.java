
@SuppressWarnings("serial")
public class Refridgerator extends GenericItem{

	private final int OBJECT_ID = 3;
	
	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Refridgerator(String brand, String model, double price, int capacity) {
		super(brand, model, price, capacity);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public String toString() {
		return "Refridgerator " + super.toString();
	}
	
}
