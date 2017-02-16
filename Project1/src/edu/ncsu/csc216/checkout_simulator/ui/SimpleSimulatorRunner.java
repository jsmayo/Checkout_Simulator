package edu.ncsu.csc216.checkout_simulator.ui;

import java.util.Scanner;
import edu.ncsu.csc216.checkout_simulator.simulation.Simulator;

/**
 * Simple class to run shopping cart checkout simulations. 
 *   Input is from standard input. Output is to standard output.
 *   No error checking is performed. 
 * @author Jo Perry
 */
public class SimpleSimulatorRunner {
	
	/**
	 * Starts the command line simple simulation.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of shopping carts: ");
		int numberOfCarts = sc.nextInt();
		System.out.print("Number of checkout registers: ");
		int numberOfRegisters = sc.nextInt();
		Simulator s = new Simulator(numberOfRegisters, numberOfCarts);
		while (s.moreSteps()) {
			s.step();
		}
		System.out.printf("Average Wait Time: %1$.3f seconds%n", s.averageWaitTime());
		System.out.printf("Average Process Time: %1$.3f seconds%n", s.averageProcessTime());
		sc.close();
	}


}