
@SuppressWarnings("serial")
public class Stove extends GenericItem {
	
	private final int OBJECT_ID = 4;

	/**
	 * @param brand
	 * @param model
	 * @param price
	 */
	public Stove(String brand, String model, double price) {
		super(brand, model, price);
	}

	@Override
	public String toString() {
		return "Stove " + super.toString();
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
