import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Business implements Serializable{

	private List customerList = new ArrayList();
	private List modelList = new ArrayList();
	private List holdList = new ArrayList();
	
	private double totalSales = 0;
	
	public void addACustomer(String name, int phoneNumber) {
		//TODO: Implement adding a customer
	}
	
	public void addAModel(String brand, String modelName, double price) {
		//TODO: Implement add a model
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
