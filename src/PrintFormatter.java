import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFormatter implements GenericItemVisitor, Serializable {
	private Queue<Hold> holdQueue;

	@Override
	public void visit(GenericItem item) {
		holdQueue = item.getHoldQueue();
		
		for(Hold hold: holdQueue) {
			System.out.println("Item to be implemented");
		}
		
	}

	@Override
	public void visit(Dishwasher item) {
		holdQueue = item.getHoldQueue();
		System.out.println( "Dish Washer : " + item.getBrand() + " "  + item.getModel());
		
		for(Hold hold: holdQueue) {
			System.out.println("UserID: "+  hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}
		
	}

	@Override
	public void visit(Dryer item) {
		holdQueue = item.getHoldQueue();
		
		System.out.println( "Dryer : " + item.getBrand() + " "  + item.getModel());
		
		for(Hold hold: holdQueue) {
			System.out.println("UserID: "+  hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}
		
	}

	@Override
	public void visit(Furnace item) {
	
			System.out.println("Furnaces do not have holds");
	}

	@Override
	public void visit(Refridgerator item) {
		holdQueue = item.getHoldQueue();

		System.out.println( "Refrigerator : " + item.getBrand() + " "  + item.getModel());
		
		for(Hold hold: holdQueue) {
			System.out.println("UserID: "+  hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}
		
	}

	@Override
	public void visit(Stove item) {
		holdQueue = item.getHoldQueue();

		System.out.println( "Stove : " + item.getBrand() + " "  + item.getModel());
		
		for(Hold hold: holdQueue) {
			System.out.println("UserID: "+  hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}
		
	}

	@Override
	public void visit(Washer item) {
		holdQueue = item.getHoldQueue();
		
		System.out.println( "Washer : " + item.getBrand() + " "  + item.getModel());
		
		for(Hold hold: holdQueue) {
			System.out.println("UserID: "+  hold.getCustomer().getCustomerID() + "Item: " + hold.getQuantityRequested());
		}
		
	}
}
