import static org.junit.Assert.*;

import org.junit.Test;


public class RecursionFunTest {

	@Test
	public void GCDTest() {
		RecursionFun rf = new RecursionFun();
		assertEquals(3, rf.GCD(24, 9));
		assertEquals(3, rf.GCD(-24, 9));
		assertEquals(3, rf.GCD(24, -9));
		assertEquals(5, rf.GCD(25, 45));
		assertEquals(25, rf.GCD(25, 0));
		assertEquals(25, rf.GCD(0, 25));
		assertEquals(25, rf.GCD(-25, -25));
	}
	
	@Test
	public void addReciprocalsTest() {
		RecursionFun rf = new RecursionFun();
		assertEquals(1.5, rf.addReciprocals(2), 0.000001);
		assertEquals(1.83333333, rf.addReciprocals(3), 0.000001);
		assertEquals(1, rf.addReciprocals(1), 0.000001);
		assertEquals(2.08333333, rf.addReciprocals(4), 0.000001);
	}
	
	@Test
	public void intWithCommasTest() {
		RecursionFun rf = new RecursionFun();
		assertEquals("9,999", rf.intWithCommas(9999));
		assertEquals("1,027", rf.intWithCommas(1027));
		assertEquals("1,007", rf.intWithCommas(1007));
		assertEquals("999", rf.intWithCommas(999));
		assertEquals("123,456,789", rf.intWithCommas(123456789));
		assertEquals("1,123,456,789", rf.intWithCommas(1123456789));
	}
	
	@Test
	public void sumArrayTest() {
		RecursionFun rf = new RecursionFun();
		
		int[] a1 = {1};
		assertEquals(1, rf.sumArray(a1, 0, 0));
		
		int[] a2 = {1, 2, 3, 4, 5};
		assertEquals(15, rf.sumArray(a2, 0, 4));
		
		int[] a3 = {1, 2, 3};
		assertEquals(5, rf.sumArray(a3, 1, 2));
		
		int[] a4 = {1, 2, 3, 4};
		assertEquals(0, rf.sumArray(a4, 3, 1));
	}
	
	@Test
	public void reverseArrayTest() {
		RecursionFun rf = new RecursionFun();
		int[] a1 = {1};
		rf.reverseArray(a1);
		assertEquals(1, a1[0]);
		
		int[] a2 = {1, 2, 3};
		rf.reverseArray(a2);
		assertEquals(3, a2[0]);
		assertEquals(2, a2[1]);
		assertEquals(1, a2[2]);
		
		int[] a3 = {1, 2};
		rf.reverseArray(a3);
		assertEquals(2, a3[0]);
		assertEquals(1, a3[1]);
		
		int[] a4 = {1, 2, 3, 4};
		rf.reverseArray(a4);
		assertEquals(4, a4[0]);
		assertEquals(3, a4[1]);
		assertEquals(2, a4[2]);
		assertEquals(1, a4[3]);
	}
	
	@Test
	public void arrayRangeTest() {
		RecursionFun rf = new RecursionFun();
		int[] a1 = {1};
		assertEquals(0, rf.arrayRange(a1));
		
		int[] a2 = {1, 2, 3};
		assertEquals(2, rf.arrayRange(a2));
		
		int[] a3 = {100, 27, 11, 110, 11};
		assertEquals(99, rf.arrayRange(a3));
		
		int[] a4 = {500, 6, 506, -100, 2};
		assertEquals(606, rf.arrayRange(a4));
		
		int[] a5 = {-1, -2, -3, -4, -5};
		assertEquals(4, rf.arrayRange(a5));
	}
	
	@Test
	public void binarySearchTest() {
		RecursionFun rf = new RecursionFun();
		String[] a1 = {"Adam", "Allonsy", "Geronimo", "Hullo", "Sex"};
		assertEquals(2, rf.binarySearch("Geronimo", a1));
		assertEquals(0, rf.binarySearch("Adam", a1));
		assertEquals(1, rf.binarySearch("Allonsy", a1));
		assertEquals(3, rf.binarySearch("Hullo", a1));
		assertEquals(4, rf.binarySearch("Sex", a1));
		assertEquals(-1, rf.binarySearch("FU", a1));
		
		String[] a2 = {};
		assertEquals(-1, rf.binarySearch("FU", a2));
		
		String[] a3 = {"Adam","Adam", "Allonsy", "Geronimo", "Hullo", "Sex"};
		assertEquals(3, rf.binarySearch("Geronimo", a3));
		assertEquals(0, rf.binarySearch("Adam", a3));
		assertEquals(2, rf.binarySearch("Allonsy", a3));
		assertEquals(4, rf.binarySearch("Hullo", a3));
		assertEquals(5, rf.binarySearch("Sex", a3));
		
		String[] a4 = {"a", "a", "a", "a", "a", "a"};
		assertEquals(0, rf.binarySearch("a", a4));
		
		String[] a5 = {"a", "a", "a", "a", "a", "a", "sex", "sex"};
		assertEquals(6, rf.binarySearch("sex", a5));
	}
	
	@Test
	public void combinationsTest() {
		RecursionFun rf = new RecursionFun();
		assertEquals(1, rf.combinations(0, 0));
		assertEquals(1, rf.combinations(6, 0));
		assertEquals(4, rf.combinations(4, 1));
		assertEquals(45, rf.combinations(10, 2));
		assertEquals(10, rf.combinations(5, 3));
	}

}
