import java.io.FileInputStream;
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

	/**
	 * Default searilVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> customerList = new ArrayList<Customer>();

	/*
	 * FUTURE ISSUE: Eventually, we'll need to change the Washer list to an
	 * ItemList. When iterating over this list for items, we'll need a way to
	 * diserce a "Washer" from a "Dryer" from a "Furnace" and ect.
	 */
	private List<GenericItem> itemList = new ArrayList<GenericItem>();
	private List<RepairPlan> repairPlanList = new ArrayList<RepairPlan>();

	private static Business business;
	private int customerID = 0001;
	private double totalSales = 0;
	private double repairPlanTotalSales = 0;

	public static final int WASHER = 1;
	public static final int DISHWASHER = 2;
	public static final int DRYER = 3;
	public static final int STOVE = 4;
	public static final int REFRIDGERATOR = 5;
	public static final int FURNACE = 6;

	GenericItemFactory factory = GenericItemFactory.instance();
	PrintFormatter printFormatter = PrintFormatter.instance();

	private Business() {

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
	public String addACustomer(String name, String phoneNumber) {
		// cut off any extra space after name and phone number
		name = name.trim();
		phoneNumber = phoneNumber.trim();
		Customer targetCustomer = new Customer(name, phoneNumber, 0000);
		for (Customer customer : customerList) {
			if (customer.equals(targetCustomer)) {
				// Fail
				return "This name: " + name + " and phone number: " + phoneNumber
						+ " is already customers in the system. " + "Their ID is: " + customer.getCustomerID();
			}
		}

		targetCustomer.setCustomerID(customerID);
		customerID++;
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
	public String addAModel(String brand, String modelName, double price, int type, double capacity, double BTU,
			double repairPlanCost) {
		// TODO: Implement add a model
		// iterate through the list of washer objects in modelList and check if it is
		// already present, if it is let the user know and print out the statement
		GenericItem newModel = factory.createGenericItem(type, brand, modelName, price, capacity, BTU, repairPlanCost);
		for (GenericItem item : itemList) {
			if (item.equals(newModel)) {
				// fail
				return "The type: " + typeToString(type) + " The Brand: " + brand + ", Model: " + modelName
						+ " is already in the list of items.";
			}
		}
		itemList.add(newModel);
		// Success
		return "The type: " + typeToString(type) + " The Brand: " + brand + ", Model: " + modelName
				+ " has been added to the list of items.";

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
	public String addToInventory(String brand, String modelName, int quantity, int type, double capacity, double BTU,
			double repairPlanCost) {
		// TODO: figure out if leaving 0 for price works
		GenericItem newModel = factory.createGenericItem(type, brand, modelName, 0, capacity, BTU, repairPlanCost);
		for (GenericItem item : itemList) {
			if (item.equals(newModel)) {
				item.setStock(quantity + item.getStock());
				if (type != FURNACE) {
					for (Hold hold : item.getHoldQueue()) {
						// TODO: Implement hold list and class fully
						if (item.getStock() > 0) {
							// While the stock of the washer is greater than zero and the hold quantity
							// requested is above zero
							while (item.getStock() > 0 && hold.getQuantityRequested() > 0) {
								// Total sales = total sales + the washer price
								totalSales = totalSales + item.getPrice();
								// set the stock of the washer -1 to indicate we have sold it
								item.setStock(item.getStock() - 1);
								// fulfill the hold by decreasing the quantity requested
								hold.setQuantityRequested(hold.getQuantityRequested() - 1);
							}
							// If the hold is satisfied remove it from the hold list
							if (hold.getQuantityRequested() == 0) {
								item.getHoldQueue().remove(hold);
							}
						}
						// if holds were processed
						return "The inventory was added and holds have been fulfilled.";
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
	public void purchase(String brand, String modelName, int quantity, int customerID, int type, double capacity,
			double BTU) {
		// TODO: Implement purchase
		// check that the customer is inside the customer list via ID
		GenericItem targetModel = factory.createGenericItem(type, brand, modelName, 0, capacity, BTU, 0);
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				// Check that the brand and model is in the modelList
				for (GenericItem item : itemList) {
					if (item.equals(targetModel)) {
						// If the washer Stock is greater than or equal to the quantity requested
						if (item.getStock() >= quantity) {
							// set the washer stock to washer stock - quantity requested,
							// then set total sales to totalSales + the washers price and quantity requested
							item.setStock(item.getStock() - quantity);
							totalSales = totalSales + (item.getPrice() * quantity);
						} else {
							// else if the stock is less than the quantity requested.
							// Quantity is equal to quantity requested minus the stock available to be
							// fulfilled
							quantity = quantity - item.getStock();
							totalSales = totalSales + (item.getPrice() * item.getStock());
							// set the washer stock to zero to indicate the quantity removed
							item.setStock(0);
							// Create a hold storing the customer that requested it and the washer requested
							// with the quantity that they want after fulfilling what you can.
							// If the item is a furnace the hold is not created
							if (type != FURNACE) {
								item.getHoldQueue().add(new Hold(customer, quantity));
							}
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
		if (customerList.size() == 0) {
			return "There are currently no customers in the customer list.";
		}
		String customers = "";
		for (Customer customer : customerList) {
			customers = customers + "Customer Name: " + customer.getName() + ", Phone Number: "
					+ customer.getGetPhoneNumber() + ", ID " + customer.getCustomerID() + "\n";
		}
		// return the string of customers
		return customers;
	}

	/**
	 * Creates a string of the washers in the washer list.
	 * 
	 * @return Washer List
	 */
	public String listAppliances(int type) {
		// for washers in the washer list, print out the brand, model, price, and stock
		String itemListString = "";
		if (itemList.size() == 0) {
			return "There are currently no items in the list.";
		}
		// if 0 is the generic no input print everything
		if (type == 0) {
			for (GenericItem item : itemList) {
				itemListString = itemListString + "Brand: " + item.getBrand() + ", Model: " + item.getModel()
						+ ", Price: $" + item.getPrice() + ", Stock: " + item.getStock() + "\n";
			}
			// else print the item if the object ID is equal to the type
		} else {
			for (GenericItem item : itemList) {
				if (item.getObjectID() == type) {
					itemListString = itemListString + "Brand: " + item.getBrand() + ", Model: " + item.getModel()
							+ ", Price: $" + item.getPrice() + ", Stock: " + item.getStock() + "\n";
				}
			}
		}
		return itemListString;
	}

	/**
	 * Returns a string containing the total sales
	 * 
	 * @return TotalSales
	 */
	public String displayTotalSales() {
		// Displays the total sales
		return "The total sales is: $" + totalSales + " The total repair plan profit is: " + repairPlanTotalSales;
	}

	public String enrollInRepairPlan(String brand, String modelName, int customerID) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				for (GenericItem item : itemList) {
					// If the item brand and model matchers a washer or dryer
					if (item.getBrand().equals(brand) && item.getModel().equals(modelName)
							&& item.getObjectID() == WASHER || item.getObjectID() == DRYER) {
						// make a new plan and put it in the list
						RepairPlan newPlan = new RepairPlan(customer, item);
						repairPlanList.add(newPlan);
						return "The repair plan has been added for customer: " + customerID + " on brand: " + brand
								+ " and model: " + modelName;
					}
				}
			}
		}
		return "No repair plan was enrolled as the Brand, ModelName, or customer ID is invalid";
	}

	/**
	 * The system goes through each repair plan and checks if the customer and item
	 * match the item they wish to withdraw from If it finds it, it removes the
	 * repair plan and says it was successful. If it does not find the item it
	 * returns that it was not successful for that user.
	 * 
	 * @param brand
	 * @param modelName
	 * @param customerID
	 * @return String
	 */
	public String withdrawFromRepairPlan(String brand, String modelName, int customerID) {
		for (RepairPlan repairPlan : repairPlanList) {

			GenericItem planItem = repairPlan.getItem();
			Customer planCustomer = repairPlan.getCustomer();

			if (planCustomer.getCustomerID() == customerID && planItem.getBrand().equals(brand)
					&& planItem.getModel().equals(modelName)) {
				repairPlanList.remove(repairPlan);
				return "The repair plan has been removed";
			}

		}
		return "This repair plan does not exist for this customer ID: " + customerID;

	}

	/**
	 * Goes through all the repair plans, makes sure the object is either a washer
	 * or drier then bills the customer accordingly then returns true. Otherwise it
	 * returns false if there are no repair plans.
	 * 
	 * @return Boolean
	 */
	public boolean billRepairPlans() {

		for (RepairPlan repairPlan : repairPlanList) {
			GenericItem planItem = repairPlan.getItem();
			Customer planCustomer = repairPlan.getCustomer();

			if (planItem.getObjectID() == WASHER) {
				Washer item = (Washer) planItem;
				double newTotal = item.getRepairPlanCost() + planCustomer.getCustomerRepairPlanBalance();
				planCustomer.setCustomerRepairPlanBalance(newTotal);
				repairPlanTotalSales = item.getRepairPlanCost() + repairPlanTotalSales;
				return true;
			} else {
				Dryer item = (Dryer) planItem;
				double newTotal = item.getRepairPlanCost() + planCustomer.getCustomerRepairPlanBalance();
				planCustomer.setCustomerRepairPlanBalance(newTotal);
				repairPlanTotalSales = item.getRepairPlanCost() + repairPlanTotalSales;
				return true;
			}

		}
		return false;
	}

	/**
	 * Lists all users in repair plans by iterating over them and gathering the
	 * information from them
	 * 
	 * @return String of users in repair plans
	 */
	public String listAllUsersInRepairPlan() {
		if (repairPlanList.isEmpty()) {
			return "There are no repair plans currently";
		}

		String listString = "";
		for (RepairPlan repairPlan : repairPlanList) {

			GenericItem planItem = repairPlan.getItem();
			Customer planCustomer = repairPlan.getCustomer();
			listString = "Name: " + planCustomer.getName() + " Phone number: " + planCustomer.getGetPhoneNumber()
					+ " ID: " + planCustomer.getCustomerID() + " Appliance balance: "
					+ planCustomer.getCustomerApplianceBalance() + " Repair plan balance: "
					+ planCustomer.getCustomerRepairPlanBalance() + " Item brand: " + planItem.getBrand()
					+ " Item model: " + planItem.getModel();
		}
		return listString;
	}

	/**
	 * List all back orders goes through the itemlist and sends the visitor to each
	 * to get its information as long as it is not a furnace as furnaces do not have
	 * back orders.
	 */
	public void listAllBackorders() {

		for (GenericItem item : itemList) {
			if (item.getObjectID() != FURNACE) {
				item.accept(printFormatter);
			}
		}
	}

	/**
	 * Utility function that checks what type it is and returns the correct string
	 * representation of the appliance.
	 * 
	 * @param type
	 * @return String
	 */
	private String typeToString(int type) {

		switch (type) {
		case 1:
			return "Washer";
		case 2:
			return "Dishwasher";
		case 3:
			return "Dryer";
		case 4:
			return "Range";
		case 5:
			return "Refrigerator";
		case 6:
			return "Furnace";
		}

		return "invalid type";
	}

	/**
	 * saves the current business object to disk at the source folder under the name
	 * BusinessData
	 */
	public boolean save() {
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

	/**
	 * Returns a serialized business file from a previous execution and loads it. If
	 * there is none it throws an exception and prints the stack trace
	 * 
	 * @return Saved Business class
	 */
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