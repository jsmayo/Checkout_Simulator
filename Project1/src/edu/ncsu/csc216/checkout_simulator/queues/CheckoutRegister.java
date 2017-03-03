/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;
import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * A first-in-first-out queue for Cart items waiting to be
 * processed by a Register. 
 * 
 *@author Steven Mayo
 */
public class CheckoutRegister implements LineOfItems {
	
	/** The time when the Register line will be empty of Carts. */
	private int timeWhenAvailable = 0;
	/**the queue of Carts needing processing. */
	private ShoppingCartQueue line;
	/** Log object used to log information of a processed Cart. */
	private Log log;
		
	/**
	 * Constructor method for the CheckoutRegister class. The constructor
	 * takes a Log parameter and initializes the field variable 'log', as well
	 * as creates the ShoppingCartQueue line. 
	 * @param log Log item used for initialization of this objects 'log' variable.
	 */
	public CheckoutRegister(Log log) {
		this.log = log;
		line = new ShoppingCartQueue();
	}
	
	/**
	 * Returns the number of carts still waiting to be processed in the CheckoutRegister's
	 * queue.
	 * @return size The number of Carts in need of processing before the line is empty.
	 */
	public int size() {
		return line.size();
	}
	
	/**
	 * Removes the front cart from the ShoppingCartQueue line, logs the Cart's data, 
	 * and returns the Cart to the calling method.
	 * @return Cart The Cart most recently processed.
	 */
	public Cart processNext() {
		log.logCart(line.front()); //supposed to return exception if empty, so front is right.
		return line.remove();
	}
	
	/**
	 * Returns true if there is an available Cart waiting in line to be processed.
	 * @return True if the ShoppingCartQueue is not empty. 
	 */
	public boolean hasNext() {
		if(line.isEmpty()) return false;
		//set wait time to zero if false?
		return true;
	}
	
	/**
	 * Returns the time, in seconds, when the Cart currently being processed
	 * will complete and exit the simulation. 
	 * @return Time in seconds that the cart will finish processing and exit
	 * the simulation.
	 */
	public int departTimeNext() {
		if(this.hasNext()) return (line.front().getArrivalTime() +
				line.front().getWaitTime() + line.front().getProcessTime());
		else return Integer.MAX_VALUE;
	}
	
	/**
	 * Adds a cart to the end of the ShoppingCartQueue line and updates both the Cart's
	 * waitTime and timeWhenAvailable field variables.
	 * @param cart The Cart to be added to the ShoppingCartQueue.
	 */
	public void addCartToLine(Cart cart) {
		cart.setWaitTime(this.timeWhenAvailable); //set the carts current wait time to the total wait time of the line.
		timeWhenAvailable += cart.getProcessTime(); // update the checkoutregister time to be able to asssign next cart
		line.add(cart); //add the cart to the shopping cart queue.
		}

}
