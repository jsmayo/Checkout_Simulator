/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;
import edu.ncsu.csc216.checkout_simulator.items.*;

/**
 * The Store class serves as a first-in-first-out type of queue that handles
 * Cart objects that are currently still shopping in the store and have not
 * been placed in a Register's checkout line. 
 * 
 *@author Steven Mayo
 */
public class Store implements LineOfItems {

	/** The queue of carts that are still shopping. */ 
	private ShoppingCartQueue shopping;
	/** An array containing CheckoutRegister objects. */
	private CheckoutRegister[] register;
	
	/**
	 * Constructor for the Store object, which creates a first-in-first-out
	 * queue for Cart objects. The number of Cart objects still shopping
	 * is determined/created by the CartFactory class and new Carts are added
	 * to the queue based on their arrivalTime.
	 * @param numberOfCarts The number of carts still currently shopping.
	 * @param register An array containing the CheckoutRegister objects. 
	 */
	public Store(int numberOfCarts, CheckoutRegister[] register){
		this.register = register;
	}
	
	/**
	 * Returns the number of Carts still in the shopping queue.
	 * @return The number of carts remaining in the shopping cart queue. 
	 */
	public int size(){
		return shopping.size();
	}
	
	/**
	 * Returns true if the shopping cart queue is not empty, false otherwise.
	 * @return True if the shopping cart queue is not empty. 
	 */
	public boolean hasNext(){
		if(shopping.size() > 0) return true;
		return false;
	}
	
	/**
	 * Removes a Cart object from the shopping queue and sends it a getInLine message.
	 * @return Cart The most recent cart removed from the shopping queue. 
	 */
	public Cart processNext() {
		return null;
	}
	
	/**
	 * Returns the time, in seconds, that a Cart at the front of the shopping 
	 * queue will leave and enter the CheckoutRegister queue. If the shopping
	 * queue is empty, the maximum queue time specified for that particular Cart's 
	 * type will be returned instead.
	 * @return The time that a Cart will exit the shopping queue and enter 
	 * the checkout queue.
	 */
	public int departTimeNext(){
		return Integer.MAX_VALUE;
	}
	
}
