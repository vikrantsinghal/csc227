import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;


public class LinkedStackTest {

	@Test
	public void pushTest() {
		LinkedStack<String> stack = new LinkedStack<String>();
		assertEquals(true, stack.isEmpty());
		assertEquals(0, stack.size());
		
		stack.push("LOL");
		assertEquals(false, stack.isEmpty());
		assertEquals(1, stack.size());
	}
	
	@Test
	public void peekTest() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("Allonsy");
		stack.push("Geronimo");
		assertEquals("Geronimo", stack.peek());
		assertEquals(2, stack.size());
	}
	
	@Test(expected = EmptyStackException.class)
	public void peekTestExceptionTest() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.peek();
	}
	
	@Test
	public void popTest() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("Remove Me");
		assertEquals("Remove Me", stack.pop());
		assertEquals(0, stack.size());
		
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		assertEquals("Third", stack.pop());
		assertEquals(2, stack.size());
	}
	
	@Test (expected = EmptyStackException.class)
	public void popExceptionTest() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.pop();
	}

}
