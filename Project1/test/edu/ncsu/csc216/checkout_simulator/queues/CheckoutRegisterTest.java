package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Tests to ensure proper functionality of CheckoutRegister
 * 
 *@author Steven Mayo
 */
public class CheckoutRegisterTest {

	CheckoutRegister cr;
	Log log = new Log();
	Cart expressCart = new ExpressCart(20, 20);
	
	/**
	 * Tests for the checkout register class
	 */
	@Test
	public void testCheckoutRegister() {
		//test empty constructor	
		cr = new CheckoutRegister(log);
		//Test that there are no carts in queue waiting for processing
		assertTrue(!cr.hasNext());
		//test that there are no carts added to the queue
		assertEquals(cr.size(), 0);
		//test that the initial depart time is 0.
		assertEquals(Integer.MAX_VALUE, cr.departTimeNext());
		
		//add an express cart to the queue.
		cr.addCartToLine(expressCart);
		//test that the wait line is now 1
		assertEquals(1, cr.size());
		//test for true return on waiting processing
		assertTrue(cr.hasNext());
		//test that the departing time updated
		assertEquals(40, cr.departTimeNext()); 
		
		//try to process the cart
		try {
			cr.processNext();
			//make sure the cart is removed
			assertEquals(0, cr.size());
			assertFalse(cr.hasNext());
		} catch (NoSuchElementException e){
			fail();
		}
	
	}	
}
