package edu.ncsu.csc216.checkout_simulator.simulation;


import static org.junit.Assert.*;
import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * Test class to ensure proper functionality for Log objects.
 * 
 * 
 *@author Steven Mayo
 */
public class LogTest {
	/** Log Object used to track the Cart data. */
	Log log;
	/** CheckoutRegister object that's used for holding cart objects */
	CheckoutRegister register;
	/** Cart object to test Log class. */
	Cart cart = new ExpressCart(20, 20);
	
	
	/**
	 * Test for the Log constructor class.
	 */
	@Test
	public void testLog() {
		//test that Log is initialized as empty
		log = new Log();
		register = new CheckoutRegister(log);
		assertTrue(0.0 ==  log.averageProcessTime());
		assertTrue(0.0 == log.averageWaitTime());
		assertEquals(0, log.getNumCompleted());
		
		//test that a processed cart is logged correctly.
		register.addCartToLine(cart);
		register.processNext(); //removes the cart from the checkout queue and logs the information
		//test that the cart was processed and that the log updated accordingly
		assertEquals(1, log.getNumCompleted());
		assertTrue(cart.getWaitTime() == log.averageWaitTime());
		assertTrue(cart.getProcessTime() == log.averageProcessTime());
		
	}
	
	/**
	 * Test that the logCart method functions correctly.
	 */
	@Test
	public void testLogCart() {
		//assert an empty log is created
		//test that Log is initialized as empty
		log = new Log();
		assertTrue(0.0 ==  log.averageProcessTime());
		assertTrue(0.0 == log.averageWaitTime());
		assertEquals(0, log.getNumCompleted());

		//test that a processed cart is logged correctly.
		log.logCart(new ExpressCart(30, 30));
		assertEquals(1, log.getNumCompleted());
//		System.out.println(log.averageWaitTime());
		assertTrue(0.0 == log.averageWaitTime());
		assertTrue(30.0 == log.averageProcessTime());
		
		//test that another processed cart averages the times and logs correctly
		//set the wait time for a cart, otherwise it will be 0.0
		cart.setWaitTime(100);
		log.logCart(cart);
		//test that the cart process number updated
		assertEquals(2, log.getNumCompleted());
//		System.out.println(log.averageWaitTime());
		//test that the average process time updates
		assertTrue((50 / 2.0) == log.averageProcessTime());
		//test that the average wait time updates
		assertTrue((100 / 2.0) == log.averageWaitTime());
	}

}
