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
	}
	
	/**
	 * Returns the type-specific color assigned to the regular variation of the Cart class.
	 * @return The color assigned to regular shopping carts.
	 */
	public Color getColor() {
		return RegularShoppingCart.color;
	}
}
