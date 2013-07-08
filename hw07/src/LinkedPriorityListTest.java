// Programmer: Vikrant Singhal

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A unit test for LinkedPriorityList with only one test to ensure an exception
 * is thrown with an attempt to remove from an empty list.
 * 
 */
public class LinkedPriorityListTest {
	// This test will pass only if removeElementAt throws an
	// IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void testFailedRemoveShouldThrowExceptionWhenIndexIsZeroAndTheListIsEmpty() {
		PriorityList<String> list = new LinkedPriorityList<String>();
		list.removeElementAt(0);
	}

	@Test
	public void testInsertToLeft() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		assertTrue(list.isEmpty());
		list.insertElementAt(0, "First");
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.getElementAt(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertIndexGreaterThanSize() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		assertEquals(2, list.size());
		list.insertElementAt(3, "Exception, Allonsy!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(-1, "Geronimo!!");
	}

	@Test
	public void getTest() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		assertEquals("First", list.getElementAt(0));
		assertEquals("Second", list.getElementAt(1));
		assertEquals("Third", list.getElementAt(2));
	}

	@Test
	public void removeTestPass() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(4);
		assertEquals("First", list.getElementAt(0));
		assertEquals("Second", list.getElementAt(1));
		assertEquals("Third", list.getElementAt(2));
		assertEquals("Fourth", list.getElementAt(3));
		list.removeElementAt(0);
		assertEquals("Second", list.getElementAt(0));
		assertEquals("Third", list.getElementAt(1));
		assertEquals("Fourth", list.getElementAt(2));

		LinkedPriorityList<String> list2 = new LinkedPriorityList<String>();
		list2.insertElementAt(0, "Allonsy!!");
		list2.removeElementAt(0);
		assertEquals(0, list2.size());

	}

	@Test(expected = IllegalArgumentException.class)
	public void removeExceptionIndexGreaterThanSize() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(-1);
	}

	@Test
	public void lowerPriorityOfTestPass() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.lowerPriorityOf(4);
		assertEquals("Fifth", list.getElementAt(4));
		list.lowerPriorityOf(2);
		assertEquals("Fourth", list.getElementAt(2));
		assertEquals("Third", list.getElementAt(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lowerPriorityExceptionIndexGreater() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.lowerPriorityOf(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lowerPriorityExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.lowerPriorityOf(-1);
	}

	@Test
	public void raisePriorityOfTest() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.raisePriorityOf(0);
		assertEquals("First", list.getElementAt(0));
		list.raisePriorityOf(2);
		assertEquals("Third", list.getElementAt(1));
		assertEquals("Second", list.getElementAt(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void raisePriorityExceptionIndexGreaterSize() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.raisePriorityOf(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void raisePriorityExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(-1);
	}

	@Test
	public void toArrayTest() {
		LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);
		list.insertElementAt(3, 4);
		list.insertElementAt(4, 5);
		list.insertElementAt(5, 6);
		Object[] result = list.toArray();
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		assertEquals(5, result[4]);
		assertEquals(6, result[5]);
		result[5] = 10;
		assertEquals(10, result[5]);
		Integer temp = list.getElementAt(5);
		assertEquals(6, temp.intValue());
		
		LinkedPriorityList<String> list1 = new LinkedPriorityList<String>();
		Object result2[] = list1.toArray();
		assertEquals(0, result2.length);
	}

	@Test
	public void moveToLastTestPass() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToLast(4);
		assertEquals("Fifth", list.getElementAt(4));
		list.moveToLast(2);
		assertEquals("Third", list.getElementAt(4));
		assertEquals("Fourth", list.getElementAt(2));
		assertEquals("Fifth", list.getElementAt(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void moveToLastExceptionIndexGreater() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToLast(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void moveToLastExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToLast(-1);
	}

	@Test
	public void MoveToTopTestPass() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToTop(0);
		assertEquals("First", list.getElementAt(0));
		list.moveToTop(2);
		assertEquals("Third", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("Second", list.getElementAt(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void MoveToTopExceptionIndexGreater() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToTop(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void MoveToTopExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToTop(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getElementAtExceptionIndexGreater() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.getElementAt(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getElementAtExceptionIndexLessThan0() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.getElementAt(-1);
	}

	@Test
	public void addLastTest() {
		LinkedPriorityList<String> list1 = new LinkedPriorityList<String>();
		list1.addLast("Allonsy!!");
		assertEquals("Allonsy!!", list1.getElementAt(0));
	}

}