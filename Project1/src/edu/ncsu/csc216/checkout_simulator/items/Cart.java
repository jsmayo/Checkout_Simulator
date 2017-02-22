/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

/**
 * Abstract class that establishes ...
 * 
 * @author Steven Mayo
 *
 */
public abstract class Cart {
	public static final int INITIAL_REGISTER_IDX;
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
	
	public Cart(int arrivalTime, int processTime) {
	//TODO finish
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public int getProcessTime() {
		return processTime;
	}
	
	public int getRegisterIndex() {
		return registerIndex;
	}
	
	public boolean isWaitingInRegisterLine() {
		return waitingProcessing;
	}
	
	public void removeFromWaitingLine() {
		//TODO finish
	}
	
	protected void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}
	
	public abstract void getInLine();
	
	public abstract Color getColor();
	
	

}
