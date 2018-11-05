
@SuppressWarnings("serial")
public class Furnace extends GenericItem {

	private final int OBJECT_ID = 4;
	
	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Furnace(String brand, String model, double price) {
		super(brand, model, price);
	}
	
	@Override
	public String toString() {
		return "Furnace " + super.toString();
	}


}
