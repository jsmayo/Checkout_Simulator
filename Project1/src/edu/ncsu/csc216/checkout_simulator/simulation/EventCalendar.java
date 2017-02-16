package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.queues.LineOfItems;


/**
 * A calendar that determines the order in which carts leave their queues.
 * The checkout area entry is a queue, as well as wait lines at checkout registers.
 * Carts leaving constitute the events.
 * 
 * @author Jo Perry
 * @version 3.0
 * @see Store
 * @see CheckoutRegister
 */
public class EventCalendar {

	/** Collection of checkout registers for the simulation */
	private LineOfItems[] register;
	/** Queue of carts for the simulation */
	private LineOfItems stillShopping;

	/**
	 * Initializes the queues in the EventCalendar.
	 * @param register
	 *            all checkout registers
	 * @param checkoutEntry
	 *            holds carts coming from the shopping area into the checkout area
	 */
	public EventCalendar(LineOfItems[] register, LineOfItems checkoutEntry) {
		this.register = register;
		this.stillShopping = checkoutEntry;
	}

	/**
	 * Determines which checkout register or checkout entry area contains the next
	 * cart to be processed. If all lines are empty, an IllegalStateException is
	 * thrown.
	 * 
	 * @return The line whose front item has the earliest time.
	 */
	public LineOfItems nextToBeProcessed() {
		// Time next item leaves queue
		int nextFromShoppingArea = stillShopping.departTimeNext();
		int soonest = 0;
		for (int k = 1; k < register.length; k++)
			if (register[k].departTimeNext() < register[soonest]
					.departTimeNext())
				soonest = k;
		int departureFromCheckoutRegister = register[soonest].departTimeNext();

		// Are all queues empty?
		if (nextFromShoppingArea == Integer.MAX_VALUE
				&& departureFromCheckoutRegister == Integer.MAX_VALUE) {
			throw new IllegalStateException();
		}

		// Is the next event a cart leaving the shopping area?
		if (nextFromShoppingArea <= departureFromCheckoutRegister) {
			return stillShopping;
		}
		
		// The next event is a cart finishing checkout at a register.
		return register[soonest];
	}
}