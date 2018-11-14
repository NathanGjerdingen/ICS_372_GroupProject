import java.io.Serializable;

/**
 * Singleton factory class to create objects in business
 * 
 * @author Nathan B, Nathan G, Sang
 *
 */
public class GenericItemFactory implements Serializable {

	private static GenericItemFactory factory;

	/**
	 * Private constructor of the factory
	 */
	private GenericItemFactory() {
	}

	/**
	 * Instance method of the factory that checks if there is not a factory already
	 * made. If so it creates the factory and returns it.
	 * 
	 * @return
	 */
	public static GenericItemFactory instance() {
		if (factory == null) {
			factory = new GenericItemFactory();
		}
		return factory;
	}

	/**
	 * Factory class item to create objects used in the main class
	 * 
	 * @param type
	 * @param brand
	 * @param model
	 * @param price
	 * @param capacity
	 * @param BTU
	 * @param repairPlanCost
	 * @return A generic object that represents the input
	 */
	public GenericItem createGenericItem(int type, String brand, String model, double price, double capacity,
			double BTU, double repairPlanCost) {
		switch (type) {
		case Business.WASHER:
			return new Washer(brand, model, price, repairPlanCost);
		case Business.DISHWASHER:
			return new Dishwasher(brand, model, price);
		case Business.DRYER:
			return new Dryer(brand, model, price, repairPlanCost);
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
