/* This class has tests for the all of the methods in LoopsAndArraysTest
 * 
 * Programmer: Vikrant Singhal
 */

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Scanner;

public class LoopsAndArraysTest {

	// Test for reverseString(String str).
	@Test
	public void reverseStringTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals("gnirts", la.reverseString("string"));
		assertEquals("", la.reverseString(""));
		assertEquals("s", la.reverseString("s"));
		assertEquals("4321", la.reverseString("1234"));
		assertEquals("ss", la.reverseString("ss"));
		assertEquals("g321s", la.reverseString("s123g"));
		assertEquals("1", la.reverseString("1"));
	}

	// Test for firstNints(int n).
	@Test
	public void firstNintsTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals(0, la.firstNints(0));
		assertEquals(1, la.firstNints(1));
		assertEquals(3, la.firstNints(2));
		assertEquals(10, la.firstNints(4));
		assertEquals(5050, la.firstNints(100));
		assertEquals(21, la.firstNints(6));
	}

	// Test for factorial(int n).
	@Test
	public void factorialTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals(1, la.factorial(0));
		assertEquals(1, la.factorial(1));
		assertEquals(2, la.factorial(2));
		assertEquals(6, la.factorial(3));
		assertEquals(24, la.factorial(4));
		assertEquals(5040, la.factorial(7));
	}

	// Test for charPairs(String str).
	@Test
	public void charPairsTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals(0, la.charPairs(""));
		assertEquals(0, la.charPairs("a"));
		assertEquals(0, la.charPairs("1"));
		assertEquals(0, la.charPairs("ab"));
		assertEquals(1, la.charPairs("aa"));
		assertEquals(3, la.charPairs("aabbcc"));
		assertEquals(3, la.charPairs("mmmm"));
		assertEquals(2, la.charPairs("aaoaa"));
		assertEquals(1, la.charPairs("12344"));
		assertEquals(0, la.charPairs("moma"));
	}

	// Test for isPalindrome(String str).
	@Test
	public void isPalindromeTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertTrue(la.isPalindrome(""));
		assertTrue(la.isPalindrome("a"));
		assertTrue(la.isPalindrome("1"));
		assertFalse(la.isPalindrome("ab"));
		assertTrue(la.isPalindrome("aa"));
		assertFalse(la.isPalindrome("abc"));
		assertTrue(la.isPalindrome("toot"));
		assertTrue(la.isPalindrome("lol"));
		assertTrue(la.isPalindrome("12321"));
		assertFalse(la.isPalindrome("1234322"));
		assertTrue(la.isPalindrome("a ba ab a"));
		assertFalse(la.isPalindrome("  bhbh "));
		assertFalse(la.isPalindrome("james bond"));
		assertTrue(la.isPalindrome("string gnirts"));
	}

	// Test for sumInScanner(Scanner stream).
	@Test
	public void sumInScannerTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		Scanner stream = new Scanner("");
		assertEquals(0, la.sumInScanner(stream));

		Scanner stream1 = new Scanner("1 2 3");
		assertEquals(6, la.sumInScanner(stream1));

	}

	// Test for maximumInScanner(Scanner stream).
	@Test
	public void maximumInScannerTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		Scanner stream = new Scanner("");
		assertEquals(0.0, la.maximumInScanner(stream), 1e-12);

		Scanner stream1 = new Scanner("1.2");
		assertEquals(1.2, la.maximumInScanner(stream1), 1e-12);

		Scanner stream2 = new Scanner("2.1 1.2");
		assertEquals(2.1, la.maximumInScanner(stream2), 1e-12);

		Scanner stream3 = new Scanner("-2 -1.3");
		assertEquals(-1.3, la.maximumInScanner(stream3), 1e-12);

	}

	// Test for numberOfPairs(String[] array).
	@Test
	public void numberOfPairsTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals(0, la.numberOfPairs(new String[] {}));
		assertEquals(0, la.numberOfPairs(new String[] { "a" }));
		assertEquals(1, la.numberOfPairs(new String[] { "one", "one" }));
		assertEquals(2, la.numberOfPairs(new String[] { "a", "a", "a" }));
		assertEquals(
				2,
				la.numberOfPairs(new String[] { "a", "a", "c", "b", "c", "b",
						"b" }));
		assertEquals(
				3,
				la.numberOfPairs(new String[] { "ab", "ab", "ab", "bcd", "adb",
						"adb" }));
		assertEquals(0, la.numberOfPairs(new String[] { "abcd", "gef" }));
		assertEquals(0, la.numberOfPairs(new String[] { "1", "2", "3", "4" }));
		assertEquals(2, la.numberOfPairs(new String[] { "1", "1", "2", "2" }));
	}

	// Test for numberOfVowels(String array).
	@Test
	public void numberOfVowelsTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertEquals(0, la.numberOfVowels(new char[] {}));
		assertEquals(0, la.numberOfVowels(new char[] { 's' }));
		assertEquals(1, la.numberOfVowels(new char[] { 'a' }));
		assertEquals(1, la.numberOfVowels(new char[] { 'a', 'b' }));
		assertEquals(2,
				la.numberOfVowels(new char[] { 'b', 'c', 'd', 'a', ' ', 'u' }));
		assertEquals(5,
				la.numberOfVowels(new char[] { 'a', 'e', 'i', 'o', 'u' }));
		assertEquals(
				5,
				la.numberOfVowels(new char[] { '1', '2', 'A', 'a', 'I', 'i',
						'I' }));
		assertEquals(0, la.numberOfVowels(new char[] { ';', 'p' }));
		assertEquals(5,
				la.numberOfVowels(new char[] { 'A', 'E', 'I', 'O', 'U' }));
		assertEquals(1, la.numberOfVowels(new char[] { 'E' }));
	}

	// Test for sumGreaterThan(double[] array, double sum).
	@Test
	public void sumGreaterThanTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		assertFalse(la.sumGreaterThan(new double[] {}, -0.1));
		assertFalse(la.sumGreaterThan(new double[] { -1, -2, -3 }, -0.1));
		assertFalse(la.sumGreaterThan(new double[] { 0.0 }, 0.0));
		assertTrue(la.sumGreaterThan(new double[] { -1.0, 2, 3, -8, 10, -20 },
				-40));
		assertTrue(la.sumGreaterThan(new double[] { 1, 2, 3, 4, 5, 6, 7 }, 23));
		assertFalse(la.sumGreaterThan(new double[] { 10, 18, 0, 0, 40, -100 },
				-0.1));
	}

	// Test for stats(Scanner scanner).
	@Test
	public void statsTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		Scanner scanner = new Scanner("90.0 80.0 70.0 68.0");
		double[] result = la.stats(scanner);
		assertEquals(3, result.length);
		assertEquals(90.0, result[0], 0.1);
		assertEquals(68.0, result[1], 0.1);
		assertEquals(77.0, result[2], 0.1);

		scanner = new Scanner("100 200 300 400");
		result = la.stats(scanner);
		assertEquals(3, result.length);
		assertEquals(400, result[0], 0.1);
		assertEquals(100, result[1], 0.1);
		assertEquals(250, result[2], 0.1);
	}

	// Test for frequency(Scanner scanner).
	@Test
	public void frequencyTest() {
		LoopsAndArrays la = new LoopsAndArrays();
		Scanner scanner = new Scanner("5 0 1 2 1 5 2");

		int[] result = la.frequency(scanner);

		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(2, result[2]);
		assertEquals(0, result[3]);
		assertEquals(0, result[4]);
		assertEquals(2, result[5]);
		for (int score = 6; score <= 10; score++)
			assertEquals(0, result[score]);

		scanner = new Scanner("5 0 1 3 1 5 2 10 9 8 8 7 6 4 4 4 4 4");

		result = la.frequency(scanner);

		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(1, result[2]);
		assertEquals(1, result[3]);
		assertEquals(5, result[4]);
		assertEquals(2, result[5]);
		assertEquals(1, result[6]);
		assertEquals(1, result[7]);
		assertEquals(2, result[8]);
		assertEquals(1, result[9]);
		assertEquals(1, result[10]);
	}

	// Test for sortOfSort(int[] array).
	@Test
	public void sortOfSortTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		int[] arr1 = { 4, 3, 2, 0, 1, 2 };
		la.sortOfSort(arr1);
		assertEquals(0, arr1[0]);
		assertEquals(4, arr1[5]);
		assertEquals(3, arr1[1]);
		assertEquals(1, arr1[3]);
		assertEquals(2, arr1[4]);
		assertEquals(2, arr1[2]);

		int[] arr2 = { 4, 3, 6, 0, 1, 2 };
		la.sortOfSort(arr2);
		assertEquals(0, arr2[0]);
		assertEquals(6, arr2[5]);
		assertEquals(4, arr2[1]);
		assertEquals(1, arr2[3]);
		assertEquals(2, arr2[4]);
		assertEquals(3, arr2[2]);

		int[] arr3 = { 1, 1, 3, 0, 6, 2 };
		la.sortOfSort(arr3);
		assertEquals(0, arr3[0]);
		assertEquals(6, arr3[5]);
		assertEquals(1, arr3[1]);
		assertEquals(3, arr3[3]);
		assertEquals(2, arr3[4]);
		assertEquals(1, arr3[2]);
	}

	// Test for evensLeft(int[] array).
	@Test
	public void evensLeftTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		int arr1[] = { 1, 2, 3, 4, 5, 6, 7 };
		la.evensLeft(arr1);
		assertEquals(2, arr1[0]);
		assertEquals(4, arr1[1]);
		assertEquals(6, arr1[2]);
		assertEquals(7, arr1[3]);
		assertEquals(1, arr1[4]);
		assertEquals(3, arr1[5]);
		assertEquals(5, arr1[6]);

		int arr2[] = { 1, 3, 4, 5, 6, 8, 9, 11, 10 };
		la.evensLeft(arr2);
		assertEquals(4, arr2[0]);
		assertEquals(6, arr2[1]);
		assertEquals(8, arr2[2]);
		assertEquals(10, arr2[3]);
		assertEquals(1, arr2[4]);
		assertEquals(3, arr2[5]);
		assertEquals(5, arr2[6]);
		assertEquals(9, arr2[7]);
		assertEquals(11, arr2[8]);
		
		int arr3[] = {1};
		la.evensLeft(arr3);
		assertEquals(1, arr3[0]);
		
		int arr4[] = {2};
		la.evensLeft(arr4);
		assertEquals(2, arr4[0]);
		
		int arr5[] = { 1, 2, 10, 4, 12, 6, 14 };
		la.evensLeft(arr5);
		assertEquals(2, arr5[0]);
		assertEquals(10, arr5[1]);
		assertEquals(4, arr5[2]);
		assertEquals(12, arr5[3]);
		assertEquals(6, arr5[4]);
		assertEquals(14, arr5[5]);
		assertEquals(1, arr5[6]);
	}

	// Test for shiftNTimes(int[] array, int numShifts).
	@Test
	public void shiftNTimesTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		la.shiftNTimes(arr1, 2);
		assertEquals(3, arr1[0]);
		assertEquals(4, arr1[1]);
		assertEquals(5, arr1[2]);
		assertEquals(6, arr1[3]);
		assertEquals(1, arr1[4]);
		assertEquals(2, arr1[5]);

		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		la.shiftNTimes(arr2, 0);
		assertEquals(1, arr2[0]);
		assertEquals(2, arr2[1]);
		assertEquals(3, arr2[2]);
		assertEquals(4, arr2[3]);
		assertEquals(5, arr2[4]);
		assertEquals(6, arr2[5]);

		int[] arr3 = { 1, 2, 3, 4, 5, 6 };
		la.shiftNTimes(arr3, 6);
		assertEquals(1, arr3[0]);
		assertEquals(2, arr3[1]);
		assertEquals(3, arr3[2]);
		assertEquals(4, arr3[3]);
		assertEquals(5, arr3[4]);
		assertEquals(6, arr3[5]);

		int[] arr4 = { 1 };
		la.shiftNTimes(arr4, 4);
		assertEquals(1, arr4[0]);
	}

	// Test for replaced(char[] array, char oldChar, char newChar).
	@Test
	public void replacedTest() {
		LoopsAndArrays la = new LoopsAndArrays();

		char[] result = la.replaced(new char[] { 'a', 'b', 'c', 'd', 'a', 'b',
				'e' }, 'a', 'l');
		assertEquals('l', result[0]);
		assertEquals('b', result[1]);
		assertEquals('c', result[2]);
		assertEquals('d', result[3]);
		assertEquals('l', result[4]);
		assertEquals('b', result[5]);
		assertEquals('e', result[6]);

		char[] result1 = la.replaced(new char[] {}, 'a', 'b');
		assertEquals(0, result1.length);
	}
}
