
@SuppressWarnings("serial")
public class Dishwasher extends GenericItem{

	private final int OBJECT_ID = 2;
	
	/**
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Dishwasher(String brand, String model, double price) {
		super(brand, model, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Dishwasher " + super.toString();
	}

}
