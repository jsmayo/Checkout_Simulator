package edu.ncsu.csc216.checkout_simulator.items;

import java.util.*;

/**
 * A simple factory class whose only task is to generate shopping carts for a store.<br />
 *   Carts requiring special handling are generated 10% of the time, with process time 2.5 - 10 minutes. <br />
 *   Express carts are generated 20% of the time, with process time .5 - 2 minutes.<br />
 *   Regular carts are generated 70% of the time, with process time 1.25 - 3.5 minutes.
 * @author Jo Perry
 * @see SpecialHandlingCart
 * @see RegularShoppingCart
 * @see ExpressCart
 */
public class CartFactory {
	/** Absolute time for carts created for the simulation.  The 
	 * time starts at zero and increases by up to MAX_CART_GENERATION_DELAY
	 * for each cart created. */
	private static int time = 0; 
	/** Fixed seed for random number generator used in generating carts and data */
	private static final int SEED = 10;
	/** Random object with seed that used to generate carts and data */
	private static Random randomNumber = new Random(SEED); 
	/** Maximum delay in seconds between creation of carts */
    private static final double MAX_CART_GENERATION_DELAY = 30; 
    /** Percentage of time a cart requiring special handling should be created */
    private static final double SPECIAL_PERCENT = .1;
    /** Percentage of time an express should be created */
    private static final double EXPRESS_PERCENT = .20; 
    /** Minimum amount of time required to process a special cart */
    private static final int SPECIAL_MIN_CHECKOUT_TIME = 150;
    /** Process time range for a special cart */
    private static final int SPECIAL_CHECKOUT_TIME_RANGE = 600;
    /** Minimum amount of time required to process an express cart */
    private static final int EXPRESS_MIN_CHECKOUT_TIME = 30;
    /** Process time range for an express cart */
    private static final int EXPRESS_CHECKOUT_TIME_RANGE = 120;
    /** Minimum amount of time required to process a regular cart */
    private static final int REGULAR_MIN_CHECKOUT_TIME = 75; 
    /** Process time range for a regular cart */
    private static final int REGULAR_CHECKOUT_TIME_RANGE = 210;
	
	/**
	 * Generate a new shopping cart as described in the class comments.  
	 * @return the cat created
	 */
	public static Cart createCart() {
		// Update the overall time with at most the floor of MAX_CART_GENERATION_DELAY seconds.
		// The value is cast to an int, which is the floor of the original double.
		int delayFromPrevious =   // Time between previously generated cart and the current one.
				(int)(randomNumber.nextDouble() * MAX_CART_GENERATION_DELAY);
		if (delayFromPrevious == 0)
			delayFromPrevious = 1;
		time += delayFromPrevious;

		// Random number that determines which type of cart will be created.  The generated number
		// is between 0 and 1.0.  By splitting across the range of numbers generated, you
		// can simulate creation of different carts of the appropriate types.
		double x = randomNumber.nextDouble();
		if (x < SPECIAL_PERCENT) {
			// If the generated number is less than MAX_CART_GENERATION_DELAY, create a cart requiring special
			// handling with a process time range between SPECIAL_MIN_TIME and SPECIAL_TIME_RANGE.
			return new SpecialHandlingCart(time, 
					SPECIAL_MIN_CHECKOUT_TIME + (int) (randomNumber.nextDouble() * SPECIAL_CHECKOUT_TIME_RANGE)); 
		}
		else if (x < SPECIAL_PERCENT + EXPRESS_PERCENT) {
			// If the generated number is less than SPECIAL_PERCENT + EXPRESS_PERCENT, create an express
			// cart with a process time range between EXPRESS_MIN_TIME and EXPRESS_TIME_RANGE.
			return new ExpressCart(time, 
					EXPRESS_MIN_CHECKOUT_TIME + (int) (randomNumber.nextDouble() * EXPRESS_CHECKOUT_TIME_RANGE));
		}
		else {
			// Otherwise, create a regular cart with a process time range between REGULAR_MIN_TIME 
			// and REGULAR_TIME_RANGE.
			return new RegularShoppingCart(time, 
					REGULAR_MIN_CHECKOUT_TIME + (int) (randomNumber.nextDouble() * REGULAR_CHECKOUT_TIME_RANGE));
		}
	}

	/**
	 * Resets the factory.  Use this for testing ONLY!
	 */
	public static void resetFactory() {
		time = 0;
		randomNumber = new Random(SEED);
	}

}