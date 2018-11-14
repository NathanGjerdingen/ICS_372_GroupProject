import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Class to print out the item description and any hold that it might have.
 * 
 * @author Nathan B
 */
public class PrintFormatter implements GenericItemVisitor, Serializable {
	private Queue<Hold> holdQueue;
	private static PrintFormatter formatter;

	/**
	 * Private constructor of the PrintFormatter
	 */
	private PrintFormatter() {
	}

	/**
	 * Instance method of the print formatter that checks if there is not a
	 * formatter already made. If so it creates the formatter and returns it.
	 * 
	 * @return
	 */
	public static PrintFormatter instance() {
		if (formatter == null) {
			formatter = new PrintFormatter();
		}
		return formatter;
	}

	/**
	 * Implements the visit pattern by iterating through the hold queue of a generic
	 * item and prints to be implemented as nothing is a generic item
	 */
	@Override
	public void visit(GenericItem item) {
		holdQueue = item.getHoldQueue();

		for (Hold hold : holdQueue) {
			System.out.println("Item to be implemented");
		}

	}

	/**
	 * Iterates over a dishwasher items hold queue and prints out its information
	 */
	@Override
	public void visit(Dishwasher item) {
		holdQueue = item.getHoldQueue();
		System.out.println("Dish Washer : " + item.getBrand() + " " + item.getModel());

		for (Hold hold : holdQueue) {
			System.out
					.println("UserID: " + hold.getCustomer().getCustomerID() + " Item: " + hold.getQuantityRequested());
		}

	}

	/**
	 * Iterates over a dryer item and prints out its queue
	 */
	@Override
	public void visit(Dryer item) {
		holdQueue = item.getHoldQueue();

		System.out.println("Dryer : " + item.getBrand() + " " + item.getModel());

		for (Hold hold : holdQueue) {
			System.out
					.println("UserID: " + hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}

	}

	/**
	 * Iterates over a furnace item and prints out its queue
	 */
	@Override
	public void visit(Furnace item) {

		System.out.println("Furnaces do not have holds");
	}

	/**
	 * Iterates over a refrigerator item and prints out its queue
	 */
	@Override
	public void visit(Refridgerator item) {
		holdQueue = item.getHoldQueue();

		System.out.println("Refrigerator : " + item.getBrand() + " " + item.getModel());

		for (Hold hold : holdQueue) {
			System.out
					.println("UserID: " + hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}

	}

	/**
	 * Iterates over a stove item and prints out its queue
	 */
	@Override
	public void visit(Stove item) {
		holdQueue = item.getHoldQueue();

		System.out.println("Stove : " + item.getBrand() + " " + item.getModel());

		for (Hold hold : holdQueue) {
			System.out
					.println("UserID: " + hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}

	}

	/**
	 * Iterates over a washer item and prints out its queue
	 */
	@Override
	public void visit(Washer item) {
		holdQueue = item.getHoldQueue();

		System.out.println("Washer : " + item.getBrand() + " " + item.getModel());

		for (Hold hold : holdQueue) {
			System.out
					.println("UserID: " + hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}

	}
}
