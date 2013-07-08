import java.util.EmptyStackException;

/**
 * This is the interface for a Stack ADT.
 * 
 * @author Vikrant
 * 
 * @param <E>
 */
public interface OurStack<E> {

	/**
	 * Check if the stack is empty to help avoid popping an empty stack.
	 * 
	 * @returns true if there are zero elements in this stack.
	 */
	public boolean isEmpty();

	/**
	 * Put an element on "top" of this Stack object.
	 * 
	 * @param element
	 */
	public void push(E element);

	/**
	 * Return reference to the element at the top of this stack.
	 * 
	 * @returns A reference to the top element.
	 * @throws EmptyStackException
	 *             if this stack is empty.
	 */
	public E peek() throws EmptyStackException;

	/**
	 * Remove element at the top of stack and return a reference to it.
	 * 
	 * @returns A reference to the most recently pushed element.
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E pop() throws EmptyStackException;
}
