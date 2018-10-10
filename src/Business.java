import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Business implements Serializable{

	private List<Customer> customerList = new ArrayList<Customer>();
	private List<Washer> modelList = new ArrayList();
	private List holdList = new ArrayList();
	private int customerID = 0001;
	
	private double totalSales = 0;
	
	public boolean addACustomer(String name, int phoneNumber) {
		//TODO: Implement adding a customer
		for(Customer customer : customerList) {
			if(customer.getName().equals(name) && customer.getGetPhoneNumber() == phoneNumber) {
				System.out.println("This name: " + name +" and phone number: " + phoneNumber + " are already customers in the system.");
				return false;
			}
		}
		Customer newCustomer = new Customer(name,phoneNumber, customerID);
		customerID++;
		customerList.add(newCustomer);
		return true;
		
	}
	
	public boolean addAModel(String brand, String modelName, double price) {
		//TODO: Implement add a model
		//iterate through the list of washer objects in modelList and check if it is 
		//already present, if it is let the user know and print out the statement
		for(Washer washer : modelList) {
			if(washer.getBrand().equals(brand) && washer.getModelName().equals(modelName)) {
				System.out.println("This brand:" + brand +" and model:" + modelName + " are already in the catalogue of washers.");
				return false;
			}
		}
		
		Washer newWasher = new Washer(brand, modelName, price);
		modelList.add(newWasher);
		return true;
		
	}
	
	public void addToInventory(String brand, String modelName, int quantity) {
		//TODO: Implement add to inventory
	}
	
	public void purchase(String brand, String modelName, int quantity, String customerID) {
		//TODO: Implement purchase
	}
	
	public void listCustomers() {
		//TODO: Implement listCustomers
	}
	
	public void listWashers() {
		//TODO: Implement listWashers
	}
	
	public void displayTotalSales() {
		//TODO: Implement displayTotalSales
	}
	
	public void save() {
		//TODO: Implement save
		try {
			FileOutputStream file = new FileOutputStream("ICS372BuisnessExample");
			ObjectOutputStream output = new ObjectOutputStream(file);
			//Write the current class object to file
			output.writeObject(this.getClass());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
