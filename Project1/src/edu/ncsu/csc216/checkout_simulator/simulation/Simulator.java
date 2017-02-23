
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

/**
 * The Simulator class both runs the simulation and provideds step-by-step 
 * information by responding to events that are managed from the EventCalendar 
 * class.
 * 
 *@author Steven Mayo
 */
public class Simulator {
	/** The minimum number of Registers that the simulation can have. */
	private static final int MIN_NUM_REGISTERS = 3;
	/** The maximum number of Registers that the simulation can have. */
	private static final int MAX_NUM_REGISTERS = 12;
	/** The number of registers to be created. */
	private int numRegisters;
	/** The number of Carts to be created. */
	private int numCarts;
	/** Total number of steps/events simulated. */
	private int stepsTaken;
	
	/**
	 * Constructor for the Simulator class that is used to create a Store object, 
	 * and an array of CheckoutRegisters. This constructor also creates the Log
	 * to keep track of the statistics and creates an EventCalendar to control
	 * the order of events.
	 * @param numCarts The number of carts to simulate shopping within the Store.
	 * @param numRegisters The number of CheckoutRegisters to instantiate for 
	 * simulation.
	 */
	public Simulator(int numCarts, int numRegisters) {
		if(numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS) throw new IllegalArgumentException();
		CheckoutRegister[] checkoutRegister = new CheckoutRegister[numRegisters];
		Store store = new Store(numCarts, checkoutRegister);
		//will fill in later.
	}
	
	/**
	 * Returns the array of colors assigned to the different Cart types. There are three
	 * elements within the array: The color for the ExpressCart, the color for the 
	 * RegularShoppingCart, and the color for the SpecialHandlingCart.
	 * @return The array of simulation colors for each Cart variation. 
	 */
	public static Color[] simulationColors() {
		Color[] colors = {Color.BLUE, Color.GREEN, Color.RED};
		return colors;
	}
	
	/**
	 * Returns the array of strings describing the different Cart types.There are three
	 * string elements in the array: The ExpressCart label, the RegularShoppingCart label,
	 * and the SpecialHandlingCart label.
	 * @return String array containing the three Cart labels. 
	 */
	public static String[] simulationLabels() {
		String[] labels = {"Express", "Regular", "Special"};
	return labels;
	}
	
	/**
	 * Handles the next available event from the EventCalendar.
	 */
	public void step() {
		//will fill in later.
		//if isEmpty() = false -> processNext()?
	}
	
	/**
	 * Returns the total number of steps taken so far.
	 * @return stepsTaken The total number of steps taken so far.
	 */
	public int getStepsTaken() {
		return this.stepsTaken;
	}
	
	/**
	 * Returns the total number of steps that will be taken during the
	 * simulation.
	 * @return The total number of steps to be taken during the simulation.
	 */
	public int totalNumberOfSteps() {
		return 1;
	}
	
	/**
	 * Checks to see if the simulation has finished or if more steps need to be
	 * handled.
	 * @return True if the simulation is not finished, false otherwise.
	 */
	public boolean moreSteps() {
		return false;
	}
	
	/**
	 * Returns the current index of the CheckoutRegister that is selected by the 
	 * current Cart. If the currentCart is null, then -1 is returned.
	 * @return -1 or the current index of the CheckoutRegister for the currentCart.
	 */
	public int getCurrentIndex() {
		return -1;
	}
	
	/**
	 * Returns the color of the currentCart object or null if the currentCart is 
	 * set to null.
	 * @return The color of the currentCart object or null if the current cart is 
	 * set to null.  
	 */
	public Color getCurrentCartColor() {
		return null;
	}
	
	/**
	 * Returns true if the most recently handled car completed checking out 
	 * and left a register line. Returns false if the most recently handled 
	 * cart left the shopping area to enter a register line or if there is no current cart.
	 * @return true if the most recently handled cart exited the simulation, false otherwise.
	 */
	public boolean itemLeftSimulation() {
		return false;
	}
	
	/**
	 * Calculates the average number of seconds that carts had to wait in checkout register
	 * lines prior to actually checking out.
	 * @return The average number of seconds each cart waited in line before processing.
	 */
	public double averageWaitTime() {
		return 1.0;
	}
	
	/**
	 * Calculates the average number of seconds that each cart took to process once reaching
	 * the front of the checkout line.
	 * @return The average number of seconds each cart took to process.
	 */
	public double averageProcessTime() {
		return 1.0;
	}
	
}
