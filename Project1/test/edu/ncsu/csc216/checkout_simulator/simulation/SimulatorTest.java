package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests to ensure proper functionality of Simulator class.
 * 
 * 
 *@author Steven Mayo
 */
public class SimulatorTest {
	/** Number of registers for simulation. */
	int numRegisters;
	/** Number of carts for simulation. */
	int numCarts;
	/**Simulator object to test. */
	Simulator sim;
	
	
	/**
	 * Tests for the Simulator constructor.
	 */
	@Test
	public void testSimulator() {
		//test invalid constructor
		try {
			sim = new Simulator(0, 6);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertEquals("Number of registers must be between 3 and 12 inclusive.", e.getMessage());
		}
		
		try {
			sim = new Simulator(6, 0);
		} catch (IllegalArgumentException e) {
			assertEquals("There must be at least one shopping cart in the simulation.", e.getMessage());
			
		}
		
		
		//test valid constructor
		numRegisters = 4;
		numCarts = 20;
		sim = new Simulator(numRegisters, numCarts);
		//test that Simulation has not processed a cart yet
		assertTrue(sim.averageProcessTime() == 0.0);
		assertTrue(sim.averageWaitTime() == 0.0);
		assertEquals(sim.getStepsTaken(), 0);
		assertEquals(-1, sim.getCurrentIndex());
		assertNull(sim.getCurrentCartColor());
		assertTrue(sim.moreSteps());
		assertEquals(2 * numCarts, sim.totalNumberOfSteps());
		Color[] colors = {Color.GREEN, Color.BLUE, Color.RED};
		Color[] colorsFromSim = Simulator.simulationColors();
		assertTrue(colorsFromSim[1] == colors[1]);
		String[] labels = {"Express", "Regular", "Special"};
		String[] labelsFromSim = Simulator.simulationLabels();
		assertTrue(labelsFromSim[1].equals(labels[1]));
		assertTrue(labelsFromSim[2].equals(labels[2]));
		
		//Test simulator step
		sim.step();
		assertEquals(1, sim.getStepsTaken());
		assertTrue(sim.moreSteps());
		assertNotEquals(-1, sim.getCurrentIndex());
		assertNotNull(sim.getCurrentCartColor());
		//zero process and wait times due to first cart and non-empty queues.
		assertTrue(sim.averageProcessTime() == 0);
		assertFalse(sim.averageWaitTime() != 0);
		//test that the cart was fully processed.
		//first cart should be from the shopping cart queue and not checking out
		assertFalse(sim.itemLeftSimulation()); 
		while(sim.moreSteps()) sim.step();
		
	}

}
