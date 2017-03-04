
package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.Store;
import edu.ncsu.csc216.checkout_simulator.items.Cart;

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
	private int stepsTaken = 0;
	/** The store object, housing carts still shopping. */
	private Store theStore;
	private CheckoutRegister[] register;
	private Cart currentCart;
	private EventCalendar theCalendar;
	private Log myLog;
	
	/**
	 * Constructor for the Simulator class that is used to create a Store object, 
	 * and an array of CheckoutRegisters. This constructor also creates the Log
	 * to keep track of the statistics and creates an EventCalendar to control
	 * the order of events.
	 * @param numCarts The number of carts to simulate shopping within the Store.
	 * @param numRegisters The number of CheckoutRegisters to instantiate for 
	 * simulation.
	 */
	public Simulator(int numRegisters, int numCarts) {
		if(numRegisters < MIN_NUM_REGISTERS || numRegisters > MAX_NUM_REGISTERS) throw new IllegalArgumentException("Number of registers must be between 3 and 12 inclusive.");
		if(numCarts < 1) throw new IllegalArgumentException("There must be at least one shopping cart in the simulation.");
		this.numCarts = numCarts;
		this.numRegisters = numRegisters;
		myLog = new Log();
		//this.numRegisters was used to remove the checkstyle warning. Should have been fine, but assuming I need to 
		//create a CheckoutRegister[] using a simulator object ONLY, then class variables are preferred.
		register = new CheckoutRegister[this.numRegisters];
		for(int i = 0; i < numRegisters; i++) register[i] = new CheckoutRegister(this.myLog);
			
		theStore = new Store(numCarts, this.register);
		theCalendar = new EventCalendar(this.register, theStore);

	}
	
	/**
	 * Returns the array of colors assigned to the different Cart types. There are three
	 * elements within the array: The color for the ExpressCart, the color for the 
	 * RegularShoppingCart, and the color for the SpecialHandlingCart.
	 * @return The array of simulation colors for each Cart variation. 
	 */
	public static Color[] simulationColors() {
		Color[] colors = {Color.GREEN, Color.BLUE, Color.RED};
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
		currentCart = null;
		currentCart = theCalendar.nextToBeProcessed().processNext();
		stepsTaken++;

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
		//step when a cart joins a checkoutline and when a cart checkouts, so
		//2 steps per cart, assuming all carts checkout.
		return 2 * numCarts;
	}
	
	/**
	 * Checks to see if the simulation has finished or if more steps need to be
	 * handled.
	 * @return True if the simulation is not finished, false otherwise.
	 */
	public boolean moreSteps() {
		//if(currentCart == null) return 
		return (this.getStepsTaken() < this.totalNumberOfSteps());
	}
	
	/**
	 * Returns the current index of the CheckoutRegister that is selected by the 
	 * current Cart. If the currentCart is null, then -1 is returned.
	 * @return -1 or the current index of the CheckoutRegister for the currentCart.
	 */
	public int getCurrentIndex() {
		if(currentCart != null) return currentCart.getRegisterIndex();
		else return -1;
	}
	
	/**
	 * Returns the color of the currentCart object or null if the currentCart is 
	 * set to null.
	 * @return The color of the currentCart object or null if the current cart is 
	 * set to null.  
	 */
	public Color getCurrentCartColor() {
		if(currentCart == null) return null;
		return currentCart.getColor();
	}
	
	/**
	 * Returns true if the most recently handled cart completed checking out 
	 * and left a register line. Returns false if the most recently handled 
	 * cart left the shopping area to enter a register line or if there is no current cart.
	 * @return true if the most recently handled cart exited the simulation, false otherwise.
	 */
	public boolean itemLeftSimulation() {
		if(currentCart == null) return false;
		if(currentCart.isWaitingInRegisterLine()) return false;
		return true;
	}
	
	/**
	 * Calculates the average number of seconds that carts had to wait in checkout register
	 * lines prior to actually checking out.
	 * @return The average number of seconds each cart waited in line before processing.
	 */
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	
	/**
	 * Calculates the average number of seconds that each cart took to process once reaching
	 * the front of the checkout line.
	 * @return The average number of seconds each cart took to process.
	 */
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}
	
}
