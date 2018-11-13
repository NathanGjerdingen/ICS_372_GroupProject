import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * class to implement a command line interface for washer business
 * 
 * @author Tyler Davis
 *
 */
public class UserInterface {
	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Business business;
	private static final int EXIT = 0;
	private static final int ADD_CUSTOMER = 1;
	private static final int ADD_APPLIANCE = 2;
	private static final int ADD_TO_INVENTORY = 3;
	private static final int PURCHASE = 4;
	private static final int LIST_CUSTOMERS = 5;
	private static final int LIST_APPLIANCES = 6;
	private static final int DISPLAY_TOTAL = 7;
	private static final int ENROLL_REPAIR = 8;
	private static final int WITHDRAW_REPAIR = 9;
	private static final int BILL_REPAIR = 10;
	private static final int LIST_REPAIR = 11;
	private static final int LIST_BACKORDER = 12;
	private static final int SAVE = 13;
	private static final int HELP = 14;

	/**
	 * Made private for singleton pattern. Conditionally looks for any saved data.
	 * Otherwise, it gets a singleton Library object.
	 */

	private UserInterface() {
		if (yesOrNo("Look for saved data and  use it?")) {
			retrieve();
		} else {
			business = business.instance();
		}
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}

	/**
	 * Gets a token after prompting
	 * 
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 * 
	 */
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	/**
	 * Queries for a yes or no and returns true for yes and false for no
	 * 
	 * @param prompt The string to be prepended to the yes/no prompt
	 * @return true for yes and false for no
	 * 
	 */
	private boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	/**
	 * Converts the string to a number
	 * 
	 * @param prompt the string for prompting
	 * @return the integer corresponding to the string
	 * 
	 */
	public int getNumber(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer number = Integer.valueOf(item);
				return number.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number");
			}
		} while (true);
	}

	/**
	 * Converts the string to a number
	 * 
	 * @param prompt the string for prompting
	 * @return the double corresponding to the string
	 * 
	 */
	public double getDouble(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Double number = Double.valueOf(item);
				return number.doubleValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number");
			}
		} while (true);
	}

	/**
	 * Gets the string entered.
	 * 
	 * @param prompt the string from the user
	 * @return the string corresponding to the prompt
	 */
	public String getString(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				String number = String.valueOf(item);
				return number.toString();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	/**
	 * Prompts for a command from the keyboard
	 * 
	 * @return a valid command
	 * 
	 */
	public int getCommand() {
		do {
			try {
				int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
				if (value >= EXIT && value <= HELP) {
					return value;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Enter a number");
			}
		} while (true);
	}

	/**
	 * Displays the help screen
	 * 
	 */
	public void help() {
		System.out.println("Enter a number between 0 and 12 as explained below:");
		System.out.println(EXIT + " to Exit\n");
		System.out.println(ADD_CUSTOMER + " to add a customer");
		System.out.println(ADD_APPLIANCE + " to add an appliance");
		System.out.println(ADD_TO_INVENTORY + " to add appliacnes to the inventory");
		System.out.println(PURCHASE + " to purchase an appliance ");
		System.out.println(LIST_CUSTOMERS + " to view a list of customers ");
		System.out.println(LIST_APPLIANCES + " to view a list of all appliances");
		System.out.println(DISPLAY_TOTAL + " to view a total of all sales");
		System.out.println(ENROLL_REPAIR + " to enroll in a repair plan");
		System.out.println(WITHDRAW_REPAIR + " to withdraw from a repair plan");
		System.out.println(BILL_REPAIR + " to bill repair plans");
		System.out.println(LIST_REPAIR + "to list all users in a repair plan");
		System.out.println(LIST_BACKORDER + " to list all backorders");
		System.out.println(SAVE + " to  save data");
		System.out.println(HELP + " for help");
	}

	public void applianceType() {
		System.out.println("Enter a number to choose which appliance you would like to use");
		System.out.println(1 + " Washer");
		System.out.println(2 + " Dishwasher");
		System.out.println(3 + " Dryer");
		System.out.println(4 + " Range");
		System.out.println(5 + " Refrigerator");
		System.out.println(6 + " Furnace");
	}

	/**
	 * Method to be called for adding a customer. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for adding the
	 * customer.
	 * 
	 * @return return string value that gives user confirmation
	 */
	public void addCustomer() {
		String name = getToken("Enter customer name");
		String phone = getString("Enter phone number");
		String result;
		result = business.addACustomer(name, phone);
		System.out.println(result);
	}

	/**
	 * Method to be called for adding a washer. Prompts the user for the appropriate
	 * values and uses the appropriate Business method for adding the washer.
	 * 
	 * @return return string value that gives user confirmation
	 */
	public void addAppliance() {
		String result;
		applianceType();
		int type = getCommand();
		String brand = getToken("Enter appliance brand name");
		String modelName = getToken("Enter model of appliance");
		double price = getDouble("Enter price of appliance");
		double capacity;
		double BTU;
		double repairPlanCost;

		switch (type) {
		case 1:
		case 2:
			repairPlanCost = getDouble("Enter cost of repair plan");
			result = business.addAModel(brand, modelName, price, type, 0, 0, repairPlanCost);
			System.out.println(result + " Dishwwasher" );
			break;
		case 3:
		case 4:
			result = business.addAModel(brand, modelName, price, type, 0, 0, 0);
			System.out.println(result);
			break;
		case 5:
			capacity = getDouble("Enter capacity of refigerator");
			result = business.addAModel(brand, modelName, price, type, capacity, 0, 0);
			System.out.println(result);
			break;
		case 6:
			BTU = getDouble("Enter maximum heating output of range");
			result = business.addAModel(brand, modelName, price, type, 0, BTU, 0);
			System.out.println(result);
			break;
		}
	}

	/**
	 * Method to be called for adding to inventory. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for adding to
	 * inventory.
	 * 
	 * @return string value that gives user confirmation
	 */
	public void addToInventory() {
		String result;
		applianceType();
		int type = getCommand();
		String brand = getToken("Enter appliance brand name");
		String modelName = getToken("Enter model of appliance");
		int quantity = getNumber("Enter number of appliacnes");
		double capacity;
		double BTU;
		double repairPlanCost;

		switch (type) {
		case 1:
		case 2:
			repairPlanCost = getDouble("Enter cost of repair plan");
			result = business.addToInventory(brand, modelName, quantity, type, 0, 0, repairPlanCost);
			System.out.println(result);
			break;
		case 3:
		case 4:
			result = business.addToInventory(brand, modelName, quantity, type, 0, 0, 0);
			System.out.println(result);
			break;
		case 5:
			capacity = getDouble("Enter capacity of refigerator");
			result = business.addToInventory(brand, modelName, quantity, type, capacity, 0, 0);
			System.out.println(result);
			break;
		case 6:
			BTU = getDouble("Enter maximum heating output of range");
			result = business.addToInventory(brand, modelName, quantity, type, 0, BTU, 0);
			System.out.println(result);
			break;
		}
	}

	/**
	 * Method to be called for purchasing a washer. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for purchasing a
	 * washer.
	 * 
	 */
	public void purchase() {
		applianceType();
		int type = getCommand();
		String brand = getToken("Enter appliance brand name");
		String modelName = getToken("Enter model of appliance");
		int quantity = getNumber("Enter number of washers");
		int customerID = getNumber("Enter customer ID");
		double capacity;
		double BTU;
		double repairPlanCost;

		switch (type) {
		case 1:
		case 2:
			repairPlanCost = getDouble("Enter cost of repair plan");
			business.purchase(brand, modelName, quantity, customerID, type, 0, 0);
			break;
		case 3:
		case 4:
			business.purchase(brand, modelName, quantity, customerID, type, 0, 0);
			break;
		case 5:
			capacity = getDouble("Enter capacity of refigerator");
			business.purchase(brand, modelName, quantity, customerID, type, capacity, 0);
			break;
		case 6:
			BTU = getDouble("Enter maximum heating output of range");
			business.purchase(brand, modelName, quantity, customerID, type, 0, BTU);
			break;
		}
	}

	/**
	 * Method to be called for viewing list of customers. uses the appropriate
	 * Business method to view customers.
	 * 
	 * @return list of customers
	 */
	public void listCustomers() {
		String result;
		result = business.listCustomers();
		System.out.println(result);
	}

	/**
	 * Method to be called for viewing list of washers. uses the appropriate
	 * Business method to view washers.
	 * 
	 * @return list of washers
	 */
	public void listAppliances() {
		String result;
		result = business.listAppliances();
		System.out.println(result);
	}

	/**
	 * Method to be called for displaying the total sales. uses the appropriate
	 * Business method to display total sales.
	 * 
	 * @return total sales
	 */
	public void displayTotal() {
		String result;
		result = business.displayTotalSales();
		System.out.println(result);
	}

	/**
	 * Method to be called for enrolling in a repair plan. uses the appropriate
	 * Business method to enroll in a repair plan.
	 */

	public void enrollRepairPlan() {
		int customerID = getNumber("Enter customer ID");
		String brand = getToken("Enter appliance brand name");
		String modelName = getToken("Enter appliance model");
		String result;
		result = business.enrollInRepairPlan(brand, modelName, customerID);
		System.out.println(result);
	}

	/**
	 * Method to be called for withdrawing from a repair plan. uses the appropriate
	 * Business method to withdraw from a repair plan.
	 */

	public void withdrawRepairPlan() {
		int customerID = getNumber("Enter customer ID");
		String brand = getToken("Enter appliance brand name");
		String modelName = getToken("Enter appliance model");
		String result;
		result = business.enrollInRepairPlan(brand, modelName, customerID);
		System.out.println(result);
	}

	/**
	 * Method to be called for billing all active repair plans. uses the appropriate
	 * Business method to bill all repair plans.
	 */

	public void billRepairPlan() {
		business.billRepairPlans();
	}

	/**
	 * Method to be called to list all users enrolled in a repair plan. uses the
	 * appropriate Business method to list users in a repair plan.
	 */

	public void listRepairPlan() {
		String result;
		result = business.listAllUsersInRepairPlan();
		System.out.println(result);
	}

	/**
	 * Method to be called to list all current backorders. uses the appropriate
	 * Business method for displaying all backorders.
	 */

	public void listBackorders() {
		business.listAllBackorders();
	}

	/**
	 * Method to be called for saving the Business object. Uses the appropriate
	 * Business method for saving.
	 * 
	 */

	private void save() {
		if (business.save()) {
			System.out.println("The business has been successfully saved in the file BusinessData \n");
		} else {
			System.out.println("There has been an error in saving \n");
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Business
	 * method for retrieval.
	 * 
	 */

	private void retrieve() {
		try {
			if (business == null) {
				business = business.retrieve();
				if (business != null) {
					System.out.println(" The business has been successfully retrieved from the file BusinessData \n");
				} else {
					System.out.println("File doesnt exist; creating new business");
					business = business.instance();
				}
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * Orchestrates the whole process. Calls the appropriate method for the
	 * different functionalities.
	 * 
	 */
	public void process() {
		int command;
		help();
		while ((command = getCommand()) != EXIT) {
			switch (command) {
			case ADD_CUSTOMER:
				addCustomer();
				break;
			case ADD_APPLIANCE:
				addAppliance();
				break;
			case ADD_TO_INVENTORY:
				addToInventory();
				break;
			case PURCHASE:
				purchase();
				break;
			case LIST_CUSTOMERS:
				listCustomers();
				break;
			case LIST_APPLIANCES:
				listAppliances();
				break;
			case DISPLAY_TOTAL:
				displayTotal();
				break;
			case ENROLL_REPAIR:
				enrollRepairPlan();
				break;
			case WITHDRAW_REPAIR:
				withdrawRepairPlan();
				break;
			case BILL_REPAIR:
				billRepairPlan();
				break;
			case LIST_REPAIR:
				listRepairPlan();
				break;
			case LIST_BACKORDER:
				listBackorders();
				break;
			case SAVE:
				save();
				break;
			case HELP:
				help();
				break;
			}
		}
	}

	/**
	 * The method to start the application. Simply calls process().
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		UserInterface.instance().process();
	}

}
