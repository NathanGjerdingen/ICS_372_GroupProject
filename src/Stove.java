/**
 * Class to represent a Stove. Attributes of the class are: brand, model, and
 * price.
 * 
 * @author Nathan B, Sang, Nathan G
 */
@SuppressWarnings("serial")
public class Stove extends GenericItem {

	private final int OBJECT_ID = 4;

	/**
	 * Constructor for Stove that takes 3 parameter
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Stove(String brand, String model, double price) {
		super(brand, model, price);
	}

	/**
	 * toString to print Stove's details
	 */
	@Override
	public String toString() {
		return "Stove " + super.toString();
	}

	/**
	 * Return Stove object ID number
	 */
	@Override
	public int getObjectID() {
		return OBJECT_ID;
	}

	/**
	 * Creates a visitor of type Stove
	 */
	@Override
	public void accept(GenericItemVisitor visitor) {
		visitor.visit(this);
	}

}
