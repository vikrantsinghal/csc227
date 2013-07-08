import java.util.EmptyStackException;

public class LinkedStack<E> implements OurStack<E> {

	// This private inner class saves lots of typing and is hidden from
	// outsiders
	private class Node {

		// These instance variables can be accessed from the enclosing class
		private E data;
		private Node next;

		// Constructor that directly links the created node to the specified
		// link.
		public Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	// These instance variables belong to the enclosing class
	private Node top;
	private int size;

	// Create an empty list with zero elements
	public LinkedStack() {
		top = null;
		size = 0;
	}

	/**
	 * Check if the stack is empty to help avoid popping an empty stack.
	 * 
	 * @returns true if there are zero elements in this stack.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Put an element on "top" of this Stack object.
	 * 
	 * @param element
	 */
	public void push(E element) {
		top = new Node(element, top);
		size++;
	}

	/**
	 * Return reference to the element at the top of this stack.
	 * 
	 * @returns A reference to the top element.
	 * @throws EmptyStackException
	 *             if this stack is empty.
	 */
	public E peek() throws EmptyStackException {
		if (top == null)
			throw new EmptyStackException();

		return top.data;
	}

	/**
	 * Remove element at the top of stack and return a reference to it.
	 * 
	 * @returns A reference to the most recently pushed element.
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E pop() throws EmptyStackException {
		if (top == null)
			throw new EmptyStackException();

		E result = top.data;
		top = top.next;
		size--;
		return result;
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @returns Size of the stack.
	 */
	public int size() {
		return size;
	}

}
