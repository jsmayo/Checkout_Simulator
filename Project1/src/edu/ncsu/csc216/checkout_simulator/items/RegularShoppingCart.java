package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Class that handles the behavior and attributes for Express type variations
 * cart class.
 *
 *@author Steven Mayo
 */
public class RegularShoppingCart extends Cart {
	/**Type-specific color for the regular variation of the Cart class. */
	private static Color color = Color.BLUE;
	/**Array object that holds the index values of Register objects.*/
	CheckoutRegister[] checkoutRegister;


	/**
	 * Constructor for the express variation of the Cart class. The arrival and .
	 * process times are passed in as parameters to be handled by the parent Cart 
	 * class.
	 * @param arrivalTime Time, in seconds, that the cart enters the selected checkout Register's line.
	 * @param processTime Time, in seconds, that the cart takes to be completely processed during checkout.
	 */
	public RegularShoppingCart(int arrivalTime, int processTime){
		super(arrivalTime, processTime);
	}
	
	/**
	 * Inherited method from the Cart class that is used to place the Cart object at the back
	 * of its selected Register line.
	 * @param checkoutRegister An array holding the index values of all available checkout
	 * registers.
	 */
	public void getInLine(CheckoutRegister[] checkoutRegister){
		//loop through the registers available, get in the shortest line (totalWaitTime?), excluding
		//index 0.
		int numberWaiting = Integer.MAX_VALUE; //checkoutRegister[1].size(); //size of the number waiting. Arbitrarily set to first choice.
		int shortestLineIndex = 1; //index number of the register with the shortest line
		for(int i = 1; i < checkoutRegister.length; i++) { 
			if(checkoutRegister[i].size() < numberWaiting) {
				numberWaiting = checkoutRegister[i].size();
				shortestLineIndex = i; //assign the shortest register line
			}
			
		}
		this.setRegisterIndex(shortestLineIndex);
		checkoutRegister[this.getRegisterIndex()].addCartToLine(this); //add the cart to the shortest line
	}
	
	
	/**
	 * Returns the type-specific color assigned to the regular variation of the Cart class.
	 * @return The color assigned to regular shopping carts.
	 */
	public Color getColor() {
		return RegularShoppingCart.color;
	}
}
