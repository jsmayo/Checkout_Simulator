/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import java.awt.Color;

/**
 * Abstract class that establishes basic behavior for Cart objects. Each Cart will be 
 * processed at a Register and have fields storing values for the arrival, wait, and process 
 * checkout time.
 * 
 * @author Steven Mayo
 *
 */
public abstract class Cart {
	/**The default index value for all Cart objects that have not selected a checkout line. */
	public static final int INITIAL_REGISTER_IDX = -1;
	/**Time when the cart leaves the shopping area and enters a checkout register line. */
	private int arrivalTime;
	/**Number of seconds the cart waits in a checkout register line before processing. */
	private int waitTime;
	/**Number of seconds required to check out at the register. */
	private int processTime;
	/**The index of the register that the cart has selected */
	private int registerIndex;
	/**True if the cart is currently in a line for a register. */
	private boolean waitingProcessing;
	
	/**
	 * The constructor method for all Cart objects. An arrival time and process time are passed
	 * in as arguments for the creation of each Cart object.
	 * @param arrivalTime Time (seconds) when the cart completes shopping and gets into a Register line.
	 * @param processTime Time (seconds) required for the cart to finish processing once it has reached the
	 * front of the Register's line. 
	 */
	public Cart(int arrivalTime, int processTime) {
		if(arrivalTime < 0 || processTime < 0) throw new IllegalArgumentException(); 
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}
	
	/**
	 * Returns the arrival time, in seconds, that a Cart object will spend in the shopping area before 
	 * getting into a register line. 
	 * @return arrivalTime The time that a cart will spend before entering a checkout line.
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Returns the amount of time in seconds that a Cart object waits in a checkout line before being processed.
	 * @return waitTime The time, in seconds, spent waiting in a checkout line before processing.
	 */
	public int getWaitTime() {
		return waitTime;
	}
	
	/**
	 * Calculates and sets the amount of time that a Cart will spend waiting in line before processing. This
	 * method is computed when the cart first enters the checkout line. 
	 * @param waitTime The amount of time that a cart will spend waiting in line before processing.
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * Returns the number of seconds that a Cart object will wait in a checkout register line. 
	 * @return processTime The time, in seconds, that a cart waits in at a checkout line. 
	 */
	public int getProcessTime() {
		return processTime;
	}
	
	/**
	 * Returns the index of the Register that the Cart object has selected for processing.
	 * @return registerIndex The index value for the Register that the Cart will be processed by.
	 */
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	/**
	 * Returns a boolean value to track if a Cart object is currently being 
	 * processed or still waiting in line.
	 * @return True if the Cart is currently in line for a register 
	 *  and false if the Cart is still shopping or has finished all 
	 *  processing and left the Register line. 
	 */
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	/**
	 * Removes a completely processed Cart from a Register's checkout 
	 * line and completes their processing.
	 */
	public void removeFromWaitingLine() {
		this.waitingProcessing = false;
	}
	
	/**
	 * Assigns a Cart's registerIndex attribute to the index of the Register 
	 * that the Cart has chosen for processing. This is also the same as the 
	 * index value for the Register that the Cart is currently waiting
	 * in line for.
	 * @param registerIndex The index value of the Register that the Cart
	 * will be processed by. 
	 */
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}
	
	/**
	 * Abstract method to be inherited and defined by each Cart type. This method will place the Cart at the back 
	 * of it's chosen Register's checkout line. 
	 * @param checkoutRegister An array containing the available CheckoutRegister objects that a 
	 * cart can select to checkout from. 
	 */
	public abstract void getInLine(CheckoutRegister[] checkoutRegister);
	
	/**
	 * Abstract method to be inherited and defined by each Cart type. This method is used for animation
	 * purposes and will return the Cart color that is defined by the Cart's specific type. 
	 * @return Color The type-specific color assigned to the current Cart object. 
	 */
	public abstract Color getColor();
	
}
