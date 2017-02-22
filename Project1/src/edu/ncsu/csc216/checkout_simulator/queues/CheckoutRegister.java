/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.queues;

/**
 * Description 
 * 
 *@author StevenMayo
 */
public class CheckoutRegister implements LineOfItems {
	
	private int timeWhenAvailable;
	private ShoppingCartQueue line;
	private Log log;
		
	public CheckoutRegister(Log log) {
		this.log = log;
		this.line = new ShoppingCartQueue();
	}
	
	public int size() {
	}
	
	public Cart processNext() {
	}
	
	public boolean hasNext() {
		return false;
	}
	
	public int departTimeNext() {
	}
	
	public void addCartToLine() {
	}

}
