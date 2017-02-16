package edu.ncsu.csc216.checkout_simulator.queues;

import java.util.LinkedList;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * Implements a simple queue (first-in, first-out list) of shopping carts.
 * @author Jo Perry
 * @see Cart
 */
public class ShoppingCartQueue {
	
	/** The underlying queue data structure. */
	private LinkedList<Cart> queue;  
	
	/**
	 * Creates an empty queue.
	 */
	public ShoppingCartQueue() { 
		queue = new LinkedList<Cart>(); 
	}
	
	/**
	 * Returns the number of elements in the queue.
	 * @return the number of elements
	 */
	public int size() {
		return queue.size();
	}
	
	/**
	 * Adds a new item to the back of the queue.
	 * @param c the item to add
	 */
	public void add(Cart c){
		queue.addLast(c);
	}
	
	/**
	 * Removes and returns the front cart from the queue. 
	 * @return the cart at the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public Cart remove() {
		//The call to queue.removeFirst() will throw the NoSuchElementException if
		//the queue is empty.  The exception is allowed to pass through this method.
		return queue.removeFirst();
	}
	
	/**
	 * Gets the front cart of the queue without removing it, or null
	 * if the queue is empty.
	 * @return the front element or null if the queue is empty
	 */
	public Cart front() {
		return queue.peek();
	}
	
	/**
	 * Returns true if the queue is empty, false otherwise.
	 * @return true if the queue has no elements
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}