import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UserInterface {
	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Business Business;
	private static final int EXIT = 0;
	private static final int ADD_CUSTOMER = 1;
	private static final int ADD_WASHER = 2;
	private static final int ADD_TO_INVENTORY = 3;
	private static final int PURCHASE = 4;
	private static final int LIST_CUSTOMERS = 5;
	private static final int LIST_WASHERS = 6;
	private static final int DISPLAY_TOTAL = 7;
	private static final int SAVE = 8;
	private static final int HELP = 9;

	/**
	 * Made private for singleton pattern. Conditionally looks for any saved data.
	 * Otherwise, it gets a singleton Library object.
	 */

	private UserInterface() {
		if (yesOrNo("Look for saved data and  use it?")) {
			retrieve();
		} else {
			Business = Business.instance();
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
	 * @param prompt
	 *            - whatever the user wants as prompt
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
	 * @param prompt
	 *            The string to be prepended to the yes/no prompt
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
	 * @param prompt
	 *            the string for prompting
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
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	/**
	 * Converts the string to a number
	 * 
	 * @param prompt
	 *            the string for prompting
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
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	/**
	 * Gets the string entered.
	 * 
	 * @param prompt
	 *            the string from the user
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
		System.out.println(ADD_WASHER + " to add washer");
		System.out.println(ADD_TO_INVENTORY + " to add washers to the inventory");
		System.out.println(PURCHASE + " to purchase a washer ");
		System.out.println(LIST_CUSTOMERS + " to view a list of customers ");
		System.out.println(LIST_WASHERS + " to view a list of washers");
		System.out.println(DISPLAY_TOTAL + " to view a total of all sales");
		System.out.println(SAVE + " to  save data");
		System.out.println(HELP + " for help");
	}

	/**
	 * Method to be called for adding a customer. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for adding the
	 * customer.
	 * 
	 */
	public void addCustomer() {
		String name = getToken("Enter customer name");
		String phone = getString("Enter phone number");
		String result;
		result = Business.addACustomer(name, phone);
		System.out.println(result);
	}

	/**
	 * Method to be called for adding a washer. Prompts the user for the appropriate
	 * values and uses the appropriate Business method for adding the washer.
	 * 
	 */
	public void addWasher() {
		String brand = getToken("Enter washer brand name");
		String modelName = getToken("Enter model of washer");
		double price = getDouble("Enter price of washer");
		String result;
		result = Business.addAModel(brand, modelName, price);
		System.out.println(result);
	}

	/**
	 * Method to be called for adding to inventory. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for adding to
	 * inventory.
	 * 
	 */
	public void addToInventory() {
		String brand = getToken("Enter washer brand name");
		String modelName = getToken("Enter model of washer");
		int quantity = getNumber("Enter nubmer of washers");
		String result;
		result = Business.addToInventory(brand, modelName, quantity);
		System.out.println(result);
	}

	/**
	 * Method to be called for purchasing a washer. Prompts the user for the
	 * appropriate values and uses the appropriate Business method for purchasing a
	 * washer.
	 * 
	 */
	public void purchase() {
		String brand = getToken("Enter washer brand name");
		String modelName = getToken("Enter model of washer");
		int quantity = getNumber("Enter nubmer of washers");
		int customerID = getNumber("Enter customer ID");
		Business.purchase(brand, modelName, quantity, customerID);
	}

	/**
	 * Method to be called for viewing list of customers. uses the appropriate
	 * Business method to view customers
	 */
	public void listCustomers() {
		String result;
		result = Business.listCustomers();
		System.out.println(result);
	}

	/**
	 * Method to be called for viewing list of washers. uses the appropriate
	 * Business method to view washers
	 */
	public void listWashers() {
		String result;
		result = Business.listWashers();
		System.out.println(result);
	}

	/**
	 * Method to be called for displaying the total sales. uses the appropriate
	 * Business method to display total sales
	 */
	public void displayTotal() {
		String result;
		result = Business.displayTotalSales();
		System.out.println(result);
	}

	/**
	 * Method to be called for saving the Business object. Uses the appropriate
	 * Business method for saving.
	 * 
	 */

	private void save() {
		if (Business.save()) {
			System.out.println(" The library has been successfully saved in the file BusinessData \n");
		} else {
			System.out.println(" There has been an error in saving \n");
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Business
	 * method for retrieval.
	 * 
	 */

	private void retrieve() {
		try {
			if (Business == null) {
				Business = Business.retrieve();
				if (Business != null) {
					System.out.println(" The business has been successfully retrieved from the file LibraryData \n");
				} else {
					System.out.println("File doesnt exist; creating new business");
					Business = Business.instance();
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
			case ADD_WASHER:
				addWasher();
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
			case LIST_WASHERS:
				listWashers();
				break;
			case DISPLAY_TOTAL:
				displayTotal();
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
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		UserInterface.instance().process();
	}

}
