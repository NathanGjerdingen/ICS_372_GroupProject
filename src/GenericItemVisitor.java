/**
 * Interface for the visitor pattern
 * 
 * @author Nathan Bishop
 *
 */
public interface GenericItemVisitor {

	/**
	 * Generic item visitor
	 * 
	 * @param item
	 */
	public void visit(GenericItem item);

	/**
	 * Dishwasher visitor
	 * 
	 * @param item
	 */
	public void visit(Dishwasher item);

	/**
	 * Dryer visitor
	 * 
	 * @param item
	 */
	public void visit(Dryer item);

	/**
	 * Furnace visitor
	 * 
	 * @param item
	 */
	public void visit(Furnace item);

	/**
	 * Refrigerator visitor
	 * 
	 * @param item
	 */
	public void visit(Refridgerator item);

	/**
	 * Stove visitor
	 * 
	 * @param item
	 */
	public void visit(Stove item);

	/**
	 * Washer visitor
	 * 
	 * @param item
	 */
	public void visit(Washer item);

}
