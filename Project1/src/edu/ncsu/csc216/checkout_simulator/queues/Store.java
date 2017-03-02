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
		new CartFactory(); //TODO not sure if needed
		shopping = new ShoppingCartQueue(); // Make the carts using CartFactory.create (loop? need times for creation), add the carts to the queue, add the carts to the queue using shipping.add().
		for(int i = 1; i <= numberOfCarts; i++) shopping.add(CartFactory.createCart());
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
	 * 
	 * @return True if the shopping cart queue is not empty. 
	 */
	public boolean hasNext(){
		if(shopping.size() > 0) return true; // use the ShoppingCartQueue.front() method 
		return false;
	}
	
	/**
	 * Removes a Cart object from the shopping queue and sends it a getInLine message.
	 * @return Cart The most recent cart removed from the shopping queue. 
	 */
	public Cart processNext() {
		shopping.front().getInLine(register);
		return shopping.remove();
		
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
		if(this.hasNext()) return shopping.front().getArrivalTime();
		else return Integer.MAX_VALUE;
	}
	
}
