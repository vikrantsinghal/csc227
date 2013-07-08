// This class has tests for ten methods to provide practice for testing
// methods that do things with primitives, Strings and selection control.  
//
// Programmer: VIKRANT SINGHAL
//
import static org.junit.Assert.*;

import org.junit.Test;

public class TenMethodsTest {

	// Test for antiMatter(String matter).
	@Test
	public void antiMatterTest() {
		TenMethods testObj = new TenMethods();

		assertEquals("anti-Matter", testObj.antiMatter("Matter"));
		assertEquals("anti-", testObj.antiMatter(""));
		assertEquals("anti-A", testObj.antiMatter("A"));
		assertEquals("anti- Matter", testObj.antiMatter(" Matter"));
		assertEquals("anti--No-Matter", testObj.antiMatter("-No-Matter"));
	}

	// Test for csLatin(String aWord).
	@Test
	public void csLatinTest() {
		TenMethods testObj = new TenMethods();

		assertEquals("alppe", testObj.csLatin("apple"));
		assertEquals("oerdr", testObj.csLatin("order"));
		assertEquals("fsirt", testObj.csLatin("first"));
		assertEquals("", testObj.csLatin("pickle"));
		assertEquals("aaaaa", testObj.csLatin("aaaaa"));
		assertEquals("apppb", testObj.csLatin("apppb"));
		assertEquals("aplpe", testObj.csLatin("alppe"));
		assertEquals("", testObj.csLatin("app"));
		assertEquals("apppa", testObj.csLatin("apppa"));
		assertEquals("apple", testObj.csLatin("aplpe"));
		assertEquals("", testObj.csLatin(""));
	}

	// Test for halfAndHalf(String str).
	@Test
	public void halfAndHalfTest() {
		TenMethods testObj = new TenMethods();

		assertEquals("abcdX2Y4", testObj.halfAndHalf("x2y4abcd"));
		assertEquals("defABC", testObj.halfAndHalf("AbcDef"));
		assertEquals("lloHE", testObj.halfAndHalf("Hello"));
		assertEquals("", testObj.halfAndHalf("d"));
		assertEquals("", testObj.halfAndHalf(""));
		assertEquals("aaaAA", testObj.halfAndHalf("AAAAA"));
		assertEquals("aaaAAA", testObj.halfAndHalf("AAAAAA"));
		assertEquals("34512", testObj.halfAndHalf("12345"));
		assertEquals("defABC", testObj.halfAndHalf("AbCdEf"));
	}

	// Test for lastNameLast(String fullName).
	@Test
	public void lastNameLastTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals("Rick H. Mercer", testObj.lastNameLast("Mercer, Rick H"));
		assertEquals("Warren G. Zevon", testObj.lastNameLast("Zevon, Warren G"));
		assertEquals("123 1. James", testObj.lastNameLast("James, 123 1"));
		assertEquals("Vikrant K. Singhal", testObj.lastNameLast("Singhal, Vikrant K"));
		assertEquals("H. B. K.", testObj.lastNameLast("K., H. B"));
		assertEquals("", testObj.lastNameLast("K., H"));
		assertEquals("", testObj.lastNameLast("Vk Erdos"));
		assertEquals("", testObj.lastNameLast("K. H. "));
		assertEquals("", testObj.lastNameLast(""));
		assertEquals("", testObj.lastNameLast(", abhh"));
	}
	
	// Test for timeDifference(int earlyTime, int laterTime).
	@Test
	public void timeDifferenceTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals("0:1", testObj.timeDifference(0, 1));
		assertEquals("1:0", testObj.timeDifference(100, 200));
		assertEquals("23:58", testObj.timeDifference(1, 2359));
		assertEquals("0:50", testObj.timeDifference(1115, 1205));
		assertEquals("9:59", testObj.timeDifference(956, 1955));
		assertEquals("23:59", testObj.timeDifference(0, 2359));
		assertEquals("0:0", testObj.timeDifference(2222, 2222));
		assertEquals("", testObj.timeDifference(0, 2459));
		assertEquals("", testObj.timeDifference(-1, 2000));
		assertEquals("", testObj.timeDifference(-1250, 2000));
	}
	
	// test for fToC(double fahrenheit).
	@Test
	public void fToCTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals(100.0, testObj.fToC(212.0), 0.01);
		assertEquals(-40.0, testObj.fToC(-40.0), 0.01);
		assertEquals(25.0, testObj.fToC(77.0), 0.01);
		assertEquals(93.33, testObj.fToC(200.0), 0.01);
		assertEquals(-184.44, testObj.fToC(-300.0), 0.01);
	}
	
	// Test for isLeapYear(int year).
	@Test
	public void isLeapYearTest() {
		TenMethods testObj = new TenMethods();
		
		assertTrue(testObj.isLeapYear(2400));
		assertTrue(testObj.isLeapYear(2000));
		assertTrue(testObj.isLeapYear(0));
		assertTrue(testObj.isLeapYear(2012));
		assertFalse(testObj.isLeapYear(2100));
		assertFalse(testObj.isLeapYear(2200));
		assertFalse(testObj.isLeapYear(2401));
		assertFalse(testObj.isLeapYear(313));
		assertTrue(testObj.isLeapYear(-4));
		assertFalse(testObj.isLeapYear(-7));
	}
	
	// Test for max(String a, String b).
	@Test
	public void maxTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals("James", testObj.max("James", "Bond"));
		assertEquals("james", testObj.max("James", "james"));
		assertEquals("james", testObj.max("james", "jamas"));
		assertEquals("Bond", testObj.max("", "Bond"));
		assertEquals("Bond", testObj.max("123", "Bond"));
		assertEquals("mark", testObj.max("mark", "mark"));
		assertEquals("", testObj.max("", ""));
		assertEquals("1234", testObj.max("", "1234"));
		assertEquals("King", testObj.max("James", "King"));
	}
	
	// Test for firstOf3Strings(String a, String b, String c).
	@Test
	public void firstOf3StringsTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals("a", testObj.firstOf3Strings("c", "b", "a"));
		assertEquals("A", testObj.firstOf3Strings("B", "B", "A"));
		assertEquals("Ma", testObj.firstOf3Strings("ma", "Ma", "ma"));
		assertEquals("a", testObj.firstOf3Strings("a", "a", "a"));
		assertEquals("", testObj.firstOf3Strings("c", "b", ""));
		assertEquals("1", testObj.firstOf3Strings("1", "b", "a"));
		assertEquals("", testObj.firstOf3Strings("c", "1", ""));
		assertEquals("a", testObj.firstOf3Strings("c", "a", "b"));
		assertEquals("a", testObj.firstOf3Strings("a", "b", "c"));
		assertEquals("a", testObj.firstOf3Strings("a", "b", "a"));
	}
	
	// Test for season(int month, boolean inNorthernHemisphere).
	@Test
	public void seasonTest() {
		TenMethods testObj = new TenMethods();
		
		assertEquals("Winter", testObj.season(1, true));
		assertEquals("Winter", testObj.season(2, true));
		assertEquals("Spring", testObj.season(3, true));
		assertEquals("Spring", testObj.season(4, true));
		assertEquals("Spring", testObj.season(5, true));
		assertEquals("Summer", testObj.season(6, true));
		assertEquals("Summer", testObj.season(7, true));
		assertEquals("Summer", testObj.season(8, true));
		assertEquals("Fall", testObj.season(9, true));
		assertEquals("Fall", testObj.season(10, true));
		assertEquals("Fall", testObj.season(11, true));
		assertEquals("Winter", testObj.season(12, true));
		assertEquals("Summer", testObj.season(1, false));
		assertEquals("Summer", testObj.season(2, false));
		assertEquals("Fall", testObj.season(3, false));
		assertEquals("Fall", testObj.season(4, false));
		assertEquals("Fall", testObj.season(5, false));
		assertEquals("Winter", testObj.season(6, false));
		assertEquals("Winter", testObj.season(7, false));
		assertEquals("Winter", testObj.season(8, false));
		assertEquals("Spring", testObj.season(9, false));
		assertEquals("Spring", testObj.season(10, false));
		assertEquals("Spring", testObj.season(11, false));
		assertEquals("Summer", testObj.season(12, false));
		assertEquals("", testObj.season(13, false));
		assertEquals("", testObj.season(0, true));
	}
	
}
