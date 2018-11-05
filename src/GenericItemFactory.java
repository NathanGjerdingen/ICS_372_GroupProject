/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * 
 *            Redistribution and use with or without modification, are permitted
 *            provided that the following conditions are met:
 *
 *            - the use is for academic purpose only - Redistributions of source
 *            code must retain the above copyright notice, this list of
 *            conditions and the following disclaimer. - Neither the name of
 *            Brahma Dathan or Sarnath Ramnath may be used to endorse or promote
 *            products derived from this software without specific prior written
 *            permission.
 *
 *            The authors do not make any claims regarding the correctness of
 *            the code in this module and are not responsible for any loss or
 *            damage resulting from its use.
 */
/**
 * Creates different types of LoanableItem objects. When a new LoanableItem is
 * introduced, the constructor for that class must be invoked from here. This is
 * a singleton.
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 *
 */
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

	public GenericItem createGenericItem(int type, String brand, String model, double price) {
		switch (type) {
		case Business.WASHER:
			return new Washer(brand, model, price);
		case Business.DRYER:
			return new Dryer(brand, model, price);
		case Business.STOVE:
			return new Stove(brand, model, price);
		case Business.REFRIDGERATOR:
			return new Refridgerator(brand, model, price);
		case Business.FURNACE:
			return new Furnace(brand, model, price);
			
		default:
			return null;
		}
	}

}
