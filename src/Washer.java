
/**
 * Class to represent a Washing Machine. Attributes of the class 
 * are: brand, modelName, and price, and stock.
 * 
 * @author Nathan Gjerdingen
 */
public class Washer {

	private String brand;
	private String modelName;
	private double price;
	private int stock;
	
	/**
	 * Washer takes in a brand, modelName, price when instantiated. 
	 * Stock is set to 1 immediately, because when introducing a new
	 * washer to the system you will likely be stocking it to at 
	 * least 1.
	 * 
	 * @param brand
	 * @param modelName
	 * @param price
	 */
	public Washer(String brand, String modelName, double price) {
		this.brand = brand;
		this.modelName = modelName;
		this.price = price;
		this.stock = 1;
	}
	
	/**
	 * Overloaded constructor for washer. Mainly used for checking 
	 * if to washers are equal to each other in Business class.
	 * 
	 * @param brand
	 * @param modelName
	 */
	public Washer(String brand, String modelName) {
		this.brand = brand;
		this.modelName = modelName;
		this.price = 0;
		this.stock = 1;
	}
	
	/**
	 * Get brand name from Washer.
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Set new brand name for Washer.
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Get Model Name from Washer.
	 * 
	 * @return modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Set new Model Name for Washer.
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * Get price from Washer.
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set new price to Washer.
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get stock of Washer.
	 * 
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * set new Stock of Washer.
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = this.stock + stock;
	}
	
	/**
	 * Method to determine if Washers are the "same". This method looks 
	 * at brand and modleName to determine "sameness". 
	 * 
	 * @param Washer o
	 * @return true if Washers are the same.
	 */
	public boolean equals(Washer w){
		if (this.brand == w.getBrand() && this.modelName == w.getModelName()){
			return true;
		} 
		return false;
	}
	
}
