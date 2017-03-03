
package edu.ncsu.csc216.checkout_simulator.items;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Test class for the RegularShoppingCart class.
 * 
 *@author Steven Mayo
 */
public class SpecialHandlingCartTest {

	private int arrivalTime;
	private int processTime;
	private Cart c;

	/**
	 * Tests for the RegularShoppingCart constructor /*
	 */
	@Test
	public void testSpeicalHandingCart() {
		arrivalTime = -1;
		processTime = 20;

		//test for invalid arrival time
		try {
			c = new SpecialHandlingCart(arrivalTime, processTime);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Arrival time or Process time cannot be less than zero.", e.getMessage());
		}

		//test for invalid process time
		arrivalTime = 20;
		processTime = -1;
		try {
			c = new SpecialHandlingCart(arrivalTime, processTime);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Arrival time or Process time cannot be less than zero.", e.getMessage());
		}		

		//test valid constructor
		arrivalTime = 20;
		processTime = 20;
		try {
			c = new SpecialHandlingCart(arrivalTime, processTime);
			c.setRegisterIndex(2);
			assertEquals(2, c.getRegisterIndex());
			assertEquals(20, c.getArrivalTime());
			assertEquals(20, c.getProcessTime());
		} catch (IllegalArgumentException e) {
			fail();
		}

		//Test that a cart is not waiting in line until wait time is set
		assertFalse(c.isWaitingInRegisterLine());

		//Set wait time and test for boolean change
		c.setWaitTime(20);
		assertTrue(c.isWaitingInRegisterLine());

		//test getter/setter for waitTime
		assertEquals(20, c.getWaitTime());

		//test boolean change on removeFromRegisterLine()
		c.removeFromWaitingLine();
		assertFalse(c.isWaitingInRegisterLine());

	}

	/**
	 * Test for the getColor() method.
	 */
	public void testGetColor() {
		//test that the color returned is the required color: GREEN 
		processTime = 20;
		arrivalTime = 20;
		java.awt.Color color = java.awt.Color.RED;
		c = new SpecialHandlingCart(arrivalTime, processTime);
		assertEquals(color, c.getColor());
	}
}