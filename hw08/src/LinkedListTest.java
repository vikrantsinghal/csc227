import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void duplpicateAllTest() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("Hello");
		list.addLast("Ping");
		list.addLast("Gong");
		list.addLast("Shrimp");
		list.duplicateAll("Ping");
		assertEquals("Hello Ping Ping Gong Shrimp", list.toString());
		assertEquals(5, list.size());
		
		list.duplicateAll("Fuck Off");
		assertEquals("Hello Ping Ping Gong Shrimp", list.toString());
		assertEquals(5, list.size());
		
		LinkedList<String> list1 = new LinkedList<String>();
		list.duplicateAll("Ping");
		assertEquals("", list1.toString());
		assertEquals(0, list1.size());
	}
	
	@Test
	public void reverseTestWhenEmpty() {
		LinkedList<String> list = new LinkedList<String>();
		list.reverse();
		assertEquals(0, list.size());
	}

}
