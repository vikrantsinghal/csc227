// Unit test for ArrayPriorityList<E> implements PriorityList<E>

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayPriorityListTest {

	@Test
	public void testInsertToLeft() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertIndexGreaterThanSize() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		assertEquals(2, list.size());
		list.insertElementAt(3, "Exception, Allonsy!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void insertIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(-1, "Geronimo!!");
	}

	@Test
	public void getTest() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		assertEquals("First", list.getElementAt(0));
		assertEquals("Second", list.getElementAt(1));
		assertEquals("Third", list.getElementAt(2));
	}

	@Test
	public void removeTestPass() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		
		ArrayPriorityList<String> list2 = new ArrayPriorityList<String>();
		list2.insertElementAt(0, "Allonsy!!");
		list2.removeElementAt(0);
		assertEquals(0, list2.size());
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeExceptionIndexGreaterThanSize() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(-1);
	}

	@Test
	public void lowerPriorityOfTestPass() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.lowerPriorityOf(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lowerPriorityExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.lowerPriorityOf(-1);
	}

	@Test
	public void raisePriorityOfTest() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.raisePriorityOf(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void raisePriorityExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.removeElementAt(-1);
	}

	@Test
	public void toArrayTest() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>();
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
	}

	@Test
	public void moveToLastTestPass() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToLast(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void moveToLastExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToLast(-1);
	}

	@Test
	public void MoveToTopTestPass() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
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
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToTop(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void MoveToTopExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.moveToTop(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getElementAtExceptionIndexGreater() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.getElementAt(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getElementAtExceptionIndexLessThan0() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "Second");
		list.insertElementAt(2, "Third");
		list.insertElementAt(3, "Fourth");
		list.insertElementAt(4, "Fifth");
		list.getElementAt(-1);
	}
	
	@Test
	public void growArrayTest() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "1");
		list.insertElementAt(1, "2");
		list.insertElementAt(2, "3");
		list.insertElementAt(3, "4");
		list.insertElementAt(4, "5");
		list.insertElementAt(5, "6");
		list.insertElementAt(6, "7");
		list.insertElementAt(7, "8");
		list.insertElementAt(8, "9");
		list.insertElementAt(9, "10");
		list.insertElementAt(10, "11");
		list.insertElementAt(11, "12");
		list.insertElementAt(12, "13");
		list.insertElementAt(13, "14");
		list.insertElementAt(14, "15");
		list.insertElementAt(15, "16");
		list.insertElementAt(16, "17");
		list.insertElementAt(17, "18");
		list.insertElementAt(18, "19");
		list.insertElementAt(19, "20");
		list.insertElementAt(20, "21");
		assertEquals(21, list.size());
	}

}
