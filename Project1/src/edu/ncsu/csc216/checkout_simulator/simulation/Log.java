/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.simulation;
import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * A class used to keep track of the statistics for how long it 
 * takes carts to check out and how long they wait in line prior
 * to checking out. 
 * 
 *@author Steven Mayo
 */
public class Log {
	/** The number of Carts that have checked out and left the simulation. */
	private int numCompleted;
	/** The summation of all wait times logged by Carts that have already been processed. */
	private int totalWaitTime;
	/** Summation of each Cart's processing time, excluding wait time. */
	private int totalProcessTime;
	
	/**
	 * Constructor for the Log class that's needed for statistic tracking and data
	 * logging.
	 */
	public Log() {
		
	}
	
	/**
	 * Returns the number of Carts that have been processed.
	 * @return numCompleted The number of Carts that have been processed.
	 */
	public int getNumCompleted() {
		return numCompleted;
	}
	
	/**
	 * Updates the Log item's three data members from the provided Cart parameter.
	 * @param cart The Cart to be logged
	 */
	public void logCart(Cart cart) {
	}
	
	/**
	 * Returns the average waiting time, in seconds, that each cart spent
	 * waiting in line for processing. 
	 * @return averageWaitTime The averaged time of each Cart's wait time
	 * during the simulation run.
	 */
	public double averageWaitTime() {
		double averageWaitTime = (totalWaitTime)/getNumCompleted();
		return averageWaitTime;
	}
	
	/**
	 * Returns the average time, in seconds, that it took to process each Cart
	 * during the simulation run.
	 * @return averageProcessTime The average processing time of each Cart during
	 * the simulation run.
	 */
	public double averageProcessTime() {
		double averageProcessTime = 1.0;
		averageProcessTime = (this.totalProcessTime/getNumCompleted());
		return averageProcessTime;
		
	}
	
}
