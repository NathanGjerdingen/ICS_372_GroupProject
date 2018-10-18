import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Nathan C. Bishop
 * @author Nathan Gjeridngen
 * @author Sang Ngo
 */
public class Business implements Serializable {

	private List<Customer> customerList = new ArrayList<Customer>();
	private List<Washer> modelList = new ArrayList<Washer>();
	private static Business business;
	private int customerID = 0001;
	private double totalSales = 0;
	
	private Business(){
	}
	/**
     * Supports the singleton pattern
     * 
     * @return the singleton object
     */
    public static Business instance() {
        if (business == null) {
            return (business = new Business());
        } else {
            return business;
        }
    }
	
	/**
	 * Takes a name and phone number, then checks if this customer is already in the
	 * list. If the customer is already in the list it notifies the user and does
	 * not enter them. If the user isn't already added in the list it creates the
	 * customer and stores them in the customer list.
	 * 
	 * @param name
	 * @param phoneNumber
	 * @return String replying if it was successful or not
	 */
	public String addACustomer(String name, int phoneNumber) {
		Customer targetCustomer = new Customer(name, phoneNumber, 0000);
		for (Customer customer : customerList) {
			if (customer.equals(targetCustomer)) {
				// Fail
				return "This name: " + name + " and phone number: " + phoneNumber
						+ " is already customers in the system. " + "Their ID is: " 
						+ customer.getCustomerID();
			}
		}
		customerID++;
		targetCustomer.setCustomerID(customerID);
		customerList.add(targetCustomer);
		// Success
		return "The customer has been added, their ID is: " + targetCustomer.getCustomerID();

	}

	/**
	 * Takes a brand, model name, and price for a specific model of washer. It then
	 * checks if it is already in the list of washers and notifies the user if it
	 * is. If the washer is not in the list it is added to the modelList
	 * 
	 * @param brand
	 * @param modelName
	 * @param price
	 * @return String if it was successful or not
	 */
	public String addAModel(String brand, String modelName, double price) {
		// TODO: Implement add a model
		// iterate through the list of washer objects in modelList and check if it is
		// already present, if it is let the user know and print out the statement
		Washer targetWasher = new Washer(brand, modelName, price);
		for (Washer washer : modelList) {
			if (washer.equals(targetWasher)) {
				// fail
				return "The Brand: " + brand + ", Model: " + modelName + " is already in the catalogue of washers.";
			}
		}
		modelList.add(targetWasher);
		// Success
		return "The Brand: " + brand + ", Model: " + modelName + " has been added to the list of washers.";

	}

	/**
	 * Checks to see if the target brand and model is in the washer list. If it is,
	 * it sets adds a quantity to the available washer's stock. Then checks the hold
	 * list for holds on that washer and fulfills them.
	 * 
	 * @param brand
	 * @param modelName
	 * @param quantity
	 * @return String if it was successful or not
	 */
	public String addToInventory(String brand, String modelName, int quantity) {
		Washer targetWasher = new Washer(brand, modelName);
		for (Washer washer : modelList) {
			if (washer.equals(targetWasher)) {
				washer.setStock(quantity + washer.getStock());
				for (Hold hold : washer.holdQueueForWasher) {
					// TODO: Implement hold list and class fully
					if (washer.getStock() > 0) {
						// While the stock of the washer is greater than zero and the hold quantity
						// requested is above zero
						while (washer.getStock() > 0 && hold.getQuantityRequested() > 0) {
							// Total sales = total sales + the washer price
							totalSales = totalSales + washer.getPrice();
							// set the stock of the washer -1 to indicate we have sold it
							washer.setStock(washer.getStock() - 1);
							// fulfill the hold by decreasing the quantity requested
							hold.setQuantityRequested(hold.getQuantityRequested() - 1);
						}
						// If the hold is satisfied remove it from the hold list
						if (hold.getQuantityRequested() == 0) {
							washer.holdQueueForWasher.remove(hold);
						}
					}
				}
				// Success
				return "The inventory has been added.\n";
			}
		}
		// Fail
		return "The brand: " + brand + " or model: " + modelName + " is not valid. No inventory has been added.\n";
	}

	/**
	 * Checks to see if the customerID give is a valid customer. If it is, it checks
	 * that the brand and model of the washer is valid. If it is it checks the stock
	 * of the washer compared to the quantity requested. If the stock is greater
	 * than or equal to the quantity requested it reduces the stock by quantity and
	 * adds the price * quantity of the washers to total sales. If the quantity is
	 * not sufficient, it sells what it can and creates a hold for the given washer
	 * model to be fulfilled at a later date.
	 * 
	 * @param brand
	 * @param modelName
	 * @param quantity
	 * @param customerID
	 */
	public void purchase(String brand, String modelName, int quantity, int customerID) {
		// TODO: Implement purchase
		// check that the customer is inside the customer list via ID
		Washer targetWasher = new Washer(brand, modelName);
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				// Check that the brand and model is in the modelList
				for (Washer washer : modelList) {
					if (washer.equals(targetWasher)) {
						// If the washer Stock is greater than or equal to the quantity requested
						if (washer.getStock() >= quantity) {
							// set the washer stock to washer stock - quantity requested,
							// then set total sales to totalSales + the washers price and quantity requested
							washer.setStock(washer.getStock() - quantity);
							totalSales = totalSales + (washer.getPrice() * quantity);
						} else {
							// else if the stock is less than the quantity requested.
							// Quantity is equal to quantity requested minus the stock available to be
							// fulfilled
							quantity = quantity - washer.getStock();
							totalSales = totalSales + (washer.getPrice() * washer.getStock());
							// set the washer stock to zero to indicate the quantity removed
							washer.setStock(0);
							// Create a hold storing the customer that requested it and the washer requested
							// with the quantity that they want after fulfilling what you can
							washer.holdQueueForWasher.add(new Hold(customer, washer, quantity));
						}
					}
				}
			}
		}
	}

	/**
	 * Creates a string of the customers in the customer list.
	 * 
	 * @return Customer List
	 */
	public String listCustomers() {
		// for customers in the customer list, print out name, phone number, and ID
		String customers = "";
		for (Customer customer : customerList) {
			customers = customers + "Customer Name: " + customer.getName() + ", Phone Number: "
					+ customer.getGetPhoneNumber() + ", ID " + customer.getCustomerID();
		}
		// return the string of customers
		return customers;
	}

	/**
	 * Creates a string of the washers in the washer list.
	 * 
	 * @return Washer List
	 */
	public String listWashers() {
		// for washers in the washer list, print out the brand, model, price, and stock
		String washerList = "";
		for (Washer washer : modelList) {
			washerList = washerList + "Brand: " + washer.getBrand() + ", Model: " + washer.getModelName()
					+ ", Price: $" + washer.getPrice() + ", Stock: " + washer.getStock() + "\n";
		}
		// Return the list of washers
		return washerList;
	}

	/**
	 * Returns a string containing the total sales
	 * 
	 * @return TotalSales
	 */
	public String displayTotalSales() {
		// Displays the total sales
		return "The total sales is: $" + totalSales;
	}

	/**
	 * saves the current business object to disk
	 */
	public boolean save() {
		// TODO: Implement save
		try {
			FileOutputStream file = new FileOutputStream("BusinessData");
			ObjectOutputStream output = new ObjectOutputStream(file);
			// Write the current class object to file
			output.writeObject(business);
			file.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}

	public static Business retrieve() {
		 try {
	            FileInputStream file = new FileInputStream("BusinessData");
	            ObjectInputStream input = new ObjectInputStream(file);
	            business = (Business) input.readObject();
	            
	            return business;
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	            return null;
	        } catch (ClassNotFoundException cnfe) {
	            cnfe.printStackTrace();
	            return null;
	        }
	}
}