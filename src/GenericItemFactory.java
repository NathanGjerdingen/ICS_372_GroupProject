
public class GenericItemFactory {
	
	private static GenericItemFactory factory;

	private GenericItemFactory() {
	}

	public static GenericItemFactory instance() {
		if (factory == null) {
			factory = new GenericItemFactory();
		}
		return factory;
	}

	public GenericItem createGenericItem(int type, String brand, String model, double price, double capacity, double BTU) {
		switch (type) {
		case Business.WASHER:
			return new Washer(brand, model, price);
		case Business.DRYER:
			return new Dryer(brand, model, price);
		case Business.REFRIDGERATOR:
			return new Refridgerator(brand, model, price, capacity);
		case Business.FURNACE:
			return new Furnace(brand, model, price, BTU);
		case Business.STOVE:
			return new Stove(brand, model, price);
		default:
			return null;
		}
	}

}
