package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Class that handles the behavior and attributes for Express type variations
 * cart class.
 *
 *@author Steven Mayo
 */
public class ExpressCart extends Cart {
	/**Type-specific color for the express variation of the Cart class. */
	private static Color color = Color.GREEN;
	/**Array object that holds the index values of Register objects.*/
	CheckoutRegister[] checkoutRegister;

	/**
	 * Constructor for the express variation of the Cart class. The arrival and .
	 * process times are passed in as parameters to be handled by the parent Cart 
	 * class.
	 * @param arrivalTime Time, in seconds, that the cart enters the selected checkout Register's line.
	 * @param processTime Time, in seconds, that the cart takes to be completely processed during checkout.
	 */
	public ExpressCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}

	/**
	 * Inherited method from the Cart class that is used to place the Cart object at the back
	 * of its selected Register line.
	 * @param checkoutRegister An array holding the index values of all available checkout
	 * Registers.
	 */
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		//loop through the registers available, get in the shortest line (totalWaitTime?), including
		//index 0.
		int numberWaiting = Integer.MAX_VALUE;//checkoutRegister[0].size(); //size of the number waiting 
		int shortestLineIndex = 0; //index number of the register with the shortest line
		for(int i = 0; i < checkoutRegister.length; i++) { 
			if(checkoutRegister[i].size() < numberWaiting) {
				numberWaiting = checkoutRegister[i].size();
				shortestLineIndex = i; //assign the shortest register line/ Arbitrarily set to first choice.
			}
			continue;
		}
		this.setRegisterIndex(shortestLineIndex);
		checkoutRegister[this.getRegisterIndex()].addCartToLine(this); //add the cart to the shortest line
			
	}

	/**
	 * Returns the type-specific color assigned to the express variation of the Cart class.
	 * @return The color assigned to express carts.
	 */
	public Color getColor(){
		return ExpressCart.color; //switch with Color.GREEN?
	}
}
