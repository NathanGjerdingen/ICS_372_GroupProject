/**
 * Class to represent a refrigerator. Attributes of the class are: brand,
 * model, price, and BTU.
 * 
 */
@SuppressWarnings("serial")
public class Furnace extends GenericItem {

	private final int OBJECT_ID = 6;
	private double britishThermalUnits;
	
	/**
	 * Constructor for Furnace that takes 3 parameters
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Furnace(String brand, String model, double price, double BTU) {
		super(brand, model, price);
		this.britishThermalUnits = BTU;
	}

	/**
	 * toString to print Furnace details
	 */
	@Override
	public String toString() {
		return "Furnace " + super.toString();
	}
	
	/**
	 * Return Furnace object ID number
	 */
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}
	
	/**
	 * Create a visitor of type Furnace
	 */
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}


}
