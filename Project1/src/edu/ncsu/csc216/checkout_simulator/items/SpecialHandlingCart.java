/**
 * 
 */
package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Class that handles the behavior and attributes for Express type variations
 * cart class.
 *
 *@author Steven Mayo
 */
public class SpecialHandlingCart extends Cart {
	/**Type-specific color for the regular variation of the Cart class. */
	private static Color color = Color.RED;
	/**Array object that holds the index values of Register objects.*/
	CheckoutRegister[] checkoutRegister;
	
	/**
	 * Constructor for the express variation of the Cart class. The arrival and .
	 * process times are passed in as parameters to be handled by the parent Cart 
	 * class.
	 * @param arrivalTime Time, in seconds, that the cart enters the selected checkout Register's line.
	 * @param processTime Time, in seconds, that the cart takes to be completely processed during checkout.
	 */
	public SpecialHandlingCart(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}
	
	/**
	 * Inherited method from the Cart class that is used to determine which register a 
	 * Cart will choose to checkout from. SpecialHanding Carts can only checkout from registers
	 * that are dedicated to handle those kinds of Carts. These registers are 25% of the total
	 * amount of registers and have the highest index within the array, since they are
	 * always positioned at the end/right.
	 * @param checkoutRegister An array holding the index values of all available checkout
	 * registers.
	 */
	public void getInLine(CheckoutRegister[] checkoutRegister) {
		//total number of special registers is 25% and on the right.
		int specialRegisters = (checkoutRegister.length / 4) + 1;
		//loop through the registers available, get in the shortest line (totalWaitTime?), excluding
		//index 0.
		//numberWaiting = the number of people in special register lines. (length - specialRegisters)
		//since they are always on the right (i.e. furtherest index).
		int numberWaiting = checkoutRegister[checkoutRegister.length - specialRegisters].size(); 
		//starting at 1 more than the current line index for loop initiation.
		int shortestLineIndex = checkoutRegister.length - specialRegisters; //index number of the register with the shortest line
		for(int i = checkoutRegister.length - specialRegisters + 1; i < checkoutRegister.length; i++) { 
			if(checkoutRegister[i].size() < numberWaiting) shortestLineIndex = i; //assign the shortest register line 
		}
		checkoutRegister[shortestLineIndex].addCartToLine(this); //add the cart to the shortest line
	}
	
	
	/**
	 * Returns the type-specific color assigned to the regular variation of the Cart class.
	 * @return The color assigned to the special handing carts.
	 */
	public Color getColor() {
		return SpecialHandlingCart.color;
	}
}
