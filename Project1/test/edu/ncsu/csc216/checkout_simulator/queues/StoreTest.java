package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Test class to ensure that Store class has correct functionality.
 * 
 *@author Steven Mayo
 */
public class StoreTest {

	Store store;
	CheckoutRegister[] registers = new CheckoutRegister[9];
	int numberOfCarts;
	Log log = new Log();
	
	/**
	 * Tests for the Store constructor.
	 */
	@Test
	public void testStore() {
		//fill the array of registers
		for(int i = 0; i < registers.length; i++) {
			registers[i] = new CheckoutRegister(log);
		}
		//Test empty queue values
		store = new Store(0, registers);
		//ensure that the size and queue hold no carts.
		assertEquals(0, store.size());
		assertFalse(store.hasNext());
		assertEquals(Integer.MAX_VALUE, store.departTimeNext());
		
		//Test for carts added to queue
		numberOfCarts = 50;
		store = new Store(numberOfCarts, registers);
		//test that carts were added to the store
		assertEquals(numberOfCarts, store.size());
		//test that the queue is loaded
		assertTrue(store.hasNext());
		//test that the depart time changed.
		int priorCartDepart = store.departTimeNext();
		assertNotEquals(Integer.MAX_VALUE, store.departTimeNext());
		
		//test that process next removes a cart from the queue
		store.processNext();
		//test that the store decreased in size
		assertEquals(numberOfCarts - 1, store.size());
		//test that the store still has a queue
		assertTrue(store.hasNext());
		//test that the departTime is different
		assertNotEquals(priorCartDepart, store.departTimeNext());
		while(store.size() > 0) {
			store.processNext();
		}
		

	}

}
