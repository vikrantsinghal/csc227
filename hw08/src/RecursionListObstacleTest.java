import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecursionListObstacleTest {

  RecursionFun rf = new RecursionFun();

  @Test
  public void testFailedCombinationsBaseCases() {
    assertEquals(1, rf.combinations(7, 7));
    assertEquals(12, rf.combinations(12, 1));
  }

  @Test
  public void testFailedCombinationsWithExamplesFromSlides() {
    assertEquals(3, rf.combinations(3, 2));
    assertEquals(6, rf.combinations(4, 2));
    assertEquals(10, rf.combinations(5, 2));
  }

  @Test
  public void testFailedFailedCombinationsThatAreTooLargeToComputeByHand() {
    assertEquals(84, rf.combinations(9, 6));
    assertEquals(120, rf.combinations(10, 7));
    assertEquals(2598960, rf.combinations(52, 5));
  }

  @Test
  public void testFailedAddReciprocals() {
    assertEquals(1.0, rf.addReciprocals(1), 1e-12);
    assertEquals(1.5, rf.addReciprocals(2), 1e-12);
    assertEquals(1.83333333333333, rf.addReciprocals(3), 1e-12);
    assertEquals(2.083333333333333, rf.addReciprocals(4), 1e-12);
  }

  @Test
  public void testFailedGCD() {
    assertEquals(2, rf.GCD(2, 4));
    assertEquals(2, rf.GCD(4, 2));
    assertEquals(27, rf.GCD(81, 27));
    assertEquals(27, rf.GCD(27, 81));
    assertEquals(27, rf.GCD(81, 27));
    assertEquals(27, rf.GCD(27, 81));
    assertEquals(3, rf.GCD(27, 12));
    assertEquals(3, rf.GCD(12, 27));
  }

  @Test
  public void testFailedGCDWithNegativeNumbers() {
    assertEquals("Failed with GCD(-24, 9)", 3, rf.GCD(-24, 9));
    assertEquals("Failed with GCD(24, -9)", 3, rf.GCD(24, -9));
    assertEquals("Failed with GCD(-24, -9)", 3, rf.GCD(-24, -9));
    assertEquals("Failed with GCD(99, 0)", 99, rf.GCD(99, 0));
    assertEquals("Failed with GCD(0, 99)", 99, rf.GCD(0, 99));
  }

  @Test
  public void testFailedArrayRange() {
    assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
    assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
    assertEquals(0, rf.arrayRange(new int[] { 3 }));
    assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
  }

  @Test
  public void testFailedIntWithCommas() {
    assertEquals("9", rf.intWithCommas(9));
    assertEquals("123", rf.intWithCommas(123));
    assertEquals("1,234", rf.intWithCommas(1234));
    assertEquals("2,147,483,647",
        rf.intWithCommas(Integer.MAX_VALUE));
  }

  @Test
  public void testFailedIntWithCommasWhenLeadingZerosWereNeeded() {
    assertEquals("1,007", rf.intWithCommas(1007));
    assertEquals("1,027", rf.intWithCommas(1027));
    assertEquals("1,000", rf.intWithCommas(1000));
    assertEquals("1,023,004,567", rf.intWithCommas(1023004567));
  }

  // Add a test method to RecursionTest.java
  @Test
  public void testFailedSumArray() {
    int[] x = { 1, 5, 7, 2, 3, 4 };
    assertEquals(0, rf.sumArray(x, 5, 0));
    assertEquals(22, rf.sumArray(x, 0, 5));
    assertEquals(13, rf.sumArray(x, 0, 2));
    assertEquals(9, rf.sumArray(x, 2, 3));
    assertEquals(1, rf.sumArray(x, 0, 0));
  }

  @Test
  public void testFailedBinarySearchWhenElementsShouldBeFound() {
    String[] a = { "Aaa", "Ccc", "Ddd", "Fff", "Hhh", "Qqq" };
    assertEquals(0, rf.binarySearch("Aaa", a));
    assertEquals(5, rf.binarySearch("Qqq", a));
    assertEquals(4, rf.binarySearch("Hhh", a));
  }

  @Test
  public void testFailedBinarySearchWhenElementsShouldNotBeFound() {
    String[] a = { "1", "2", "3", "4", "5", "6" };
    assertEquals(-1, rf.binarySearch("0", a));
    assertEquals(-1, rf.binarySearch("7", a));
    assertEquals(-1, rf.binarySearch("234", a));
  }

  @Test
  public void testFailedReverseWithLengthThree() {
    int[] a = { 2, 4, 6 };
    rf.reverseArray(a);
    assertEquals(6, a[0]);
    assertEquals(4, a[1]);
    assertEquals(2, a[2]);
    rf.reverseArray(a);
    assertEquals(6, a[2]);
    assertEquals(4, a[1]);
    assertEquals(2, a[0]);
  }

  @Test
  public void testFailedReverseWithLengthOne() {
    int[] a = { 2 };
    rf.reverseArray(a);
    assertEquals(2, a[0]);
    rf.reverseArray(a);
    assertEquals(2, a[0]);
  }

  @Test
  public void testFailedReverseWithLengthFour() {
    int[] a = { 2, 4, 6, 8 };
    rf.reverseArray(a);
    assertEquals(8, a[0]);
    assertEquals(6, a[1]);
    assertEquals(4, a[2]);
    assertEquals(2, a[3]);
    rf.reverseArray(a);
    assertEquals(2, a[0]);
    assertEquals(4, a[1]);
    assertEquals(6, a[2]);
    assertEquals(8, a[3]);
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


  // //////////////////////////////////////////
  // Tests for LinkedList methods from section: For Code coverage
  // //////////////////////////////////////////

  @Test
  public void testFailedGivenMethodsThatShouldPassImmediately() {
    LinkedList<Integer> intList = new LinkedList<Integer>();
    intList.addLast(1);
    intList.addLast(2);
    intList.addLast(3);

    assertEquals("1 2 3", intList.toString());
    intList.reverse();
    assertEquals("3 2 1", intList.toString());
    assertEquals(3, intList.size());

    LinkedList<String> list = new LinkedList<String>();
    list = new LinkedList<String>();
    list.addLast("Lizzie");
    list.addLast("Kelsey");
    list.addLast("Tyler");
    assertEquals("Tyler", list.max());

  }

  // //////////////////////////
  // / LinkedList duplicateAll
  // //////////////////////////

  @Test
  public void testFailedDuplicateAllWhenEmpty() {
    LinkedList<String> list = new LinkedList<String>();
    assertEquals("", list.toString());
    assertEquals(0, list.size());
    list.duplicateAll("B");
    assertEquals("", list.toString());
    assertEquals(0, list.size());
    list.addLast("B");
    list.duplicateAll("B");
    assertEquals("B B", list.toString());
    assertEquals(2, list.size());
       
  }

  @Test
  public void testFailedDuplicateAllWhenNotFound() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("A");
    list.addLast("X");
    assertEquals("A X", list.toString());
    assertEquals(2, list.size());
    list.duplicateAll("B");
    assertEquals("A X", list.toString());
    assertEquals(2, list.size());
    list.addLast("B");
    list.duplicateAll("B");
    assertEquals("A X B B", list.toString());
    assertEquals(4, list.size());
 
  }

  @Test
  public void testFailedDuplicateAllWhenOneIsInTheMiddle() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("A");
    list.addLast("B");
    list.addLast("X");
    assertEquals("A B X", list.toString());
    assertEquals(3, list.size());
    list.duplicateAll("B");
    assertEquals("A B B X", list.toString());
    assertEquals(4, list.size());
  }

  @Test
  public void testFailedDuplicateAllWhenOneAtTheEnd() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("A");
    list.addLast("B");
    list.addLast("X");
    list.addLast("B");
    assertEquals("A B X B", list.toString());
    assertEquals(4, list.size());
    list.duplicateAll("B");
    assertEquals("A B B X B B", list.toString());
    assertEquals(6, list.size());
  }

  @Test
  public void testFailedDuplicateAllWhenSeveralInARow() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("A");
    list.addLast("B");
    list.addLast("B");
    list.addLast("B");
    list.addLast("A");
    assertEquals("A B B B A", list.toString());
    assertEquals(5, list.size());
    list.duplicateAll("B");
    assertEquals("A B B B B B B A", list.toString());
    assertEquals(8, list.size());
  }

  @Test
  public void testFailedDuplicateAllWhenThreeAtBegining() {
    LinkedList<String> list = new LinkedList<String>();
    list.addLast("B");
    list.addLast("B");
    list.addLast("B");
    list.addLast("X");
    list.addLast("A");
    assertEquals("B B B X A", list.toString());
    assertEquals(5, list.size());
    list.duplicateAll("B");
    assertEquals("B B B B B B X A", list.toString());
    assertEquals(8, list.size());
  }
  
  @Test
	public void reverseTestWhenEmpty() {
		LinkedList<String> list = new LinkedList<String>();
		list.reverse();
		assertEquals(0, list.size());
	}

  // //////////////////////////
  // / ObstacleCourse findExit
  // //////////////////////////

  @Test
  public void testFailedFindTheExitWithSmallGrid() {
    char[][] grid = {

        { '+', '+', '+', '+', '+' }, 
        { '+', ' ', ' ', ' ', '+' },
        { '+', ' ', '+', ' ', '+' }, 
        { '+', '+', '+', ' ', ' ' },
        { '+', '+', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(1, 1, grid);

    assertEquals(1, top.getStartRow());
    assertEquals(1, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertTrue(foundExit);
    assertEquals(3, top.getExitRow());
    assertEquals(4, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitWithLargerGrid() {
    char[][] grid = {

        { '+', ' ', '+', '+', '+', '+', ' ', '+', '+', '+' },
        { '+', ' ', ' ', '+', '+', ' ', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', '+', ' ', ' ', ' ', '+', ' ', '+' },
        { '+', ' ', ' ', '+', ' ', ' ', ' ', '+', '+', '+' },
        { '+', '+', '+', '+', '+', '+', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', '+', ' ', '+', ' ', '+', '+', '+' },
        { '+', ' ', ' ', '+', ' ', ' ', ' ', ' ', ' ', '+' },
        { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(5, 6, grid);

    assertEquals(5, top.getStartRow());
    assertEquals(6, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertTrue(foundExit);
    assertEquals(0, top.getExitRow());
    assertEquals(6, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitWhenExitToTheLeft() {
    char[][] grid = {

        { '+', ' ', '+', '+', '+', '+', '+', '+', '+', '+' },
        { '+', '+', '+', '+', '+', ' ', ' ', ' ', ' ', '+' },
        { '+', ' ', '+', '+', ' ', ' ', ' ', '+', ' ', '+' },
        { ' ', ' ', ' ', '+', ' ', ' ', ' ', '+', '+', '+' },
        { '+', '+', ' ', '+', '+', '+', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', '+', ' ', '+', ' ', '+', '+', '+' },
        { '+', '+', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '+' },
        { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(5, 6, grid);

    assertEquals(5, top.getStartRow());
    assertEquals(6, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertTrue(foundExit);
    assertEquals(3, top.getExitRow());
    assertEquals(0, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitReturnedTrueWhenThereIsNoExit() {
    char[][] grid = {
        { ' ', ' ', '+', '+', '+', ' ' },
        { '+', '+', '+', '+', '+', '+' },
        { '+', ' ', '+', '+', ' ', '+' },
        { '+', ' ', ' ', ' ', '+', ' ' },
        { ' ', '+', ' ', ' ', ' ', '+' },
        { '+', '+', ' ', ' ', '+', '+' },
        { ' ', '+', '+', '+', '+', ' ' } };

    ObstacleCourse top = new ObstacleCourse(4, 3, grid);

    assertEquals(4, top.getStartRow());
    assertEquals(3, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertFalse("foundExit returned true when there is no exit",
        foundExit);

  }

  @Test
  public void testFailedFindTheExitReturnedTrueWhenThereIsNoExit2() {
    char[][] grid = {

        { '+', '+', '+', '+', '+', '+' },
        { '+', '+', '+', '+', '+', '+' },
        { '+', ' ', '+', '+', ' ', '+' },
        { '+', ' ', ' ', ' ', '+', ' ' },
        { ' ', '+', ' ', ' ', ' ', '+' },
        { '+', '+', ' ', ' ', '+', '+' },
        { '+', ' ', '+', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 2, grid);

    assertEquals(4, top.getStartRow());
    assertEquals(2, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertFalse("foundExit returned true when there is no exit",
        foundExit);
  }

  @Test
  public void testFailedFindTheExitReturnedTrueWhenThereIsNoExit3() {
    char[][] grid = {

        { '+', '+', ' ', '+', '+', '+' },
        { '+', '+', '+', '+', '+', '+' },
        { '+', ' ', '+', '+', ' ', '+' },
        { '+', ' ', ' ', ' ', '+', '+' },
        { '+', '+', ' ', ' ', ' ', '+' },
        { '+', '+', ' ', ' ', '+', '+' },
        { '+', '+', '+', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 2, grid);

    assertEquals(4, top.getStartRow());
    assertEquals(2, top.getStartColumn());

    boolean foundExit = top.findTheExit();
    assertFalse("foundExit returned true when there is no exit",
        foundExit);
    assertEquals(-1, top.getExitRow());
    assertEquals(-1, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitOnTop() {
    char[][] grid = {

        { '+', '+', ' ', '+', ' ', '+' },
        { '+', ' ', '+', '+', ' ', '+' },
        { '+', ' ', ' ', ' ', ' ', '+' },
        { ' ', '+', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', ' ', ' ', '+' },
        { '+', '+', '+', ' ', ' ', '+' },
        { '+', ' ', ' ', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 3, grid);

    boolean foundExit = top.findTheExit();
    assertTrue(foundExit);
    assertEquals(0, top.getExitRow());
    assertEquals(4, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitOnLeft() {
    char[][] grid = {

        { '+', '+', ' ', '+', ' ', '+' },
        { '+', ' ', '+', '+', '+', '+' },
        { '+', ' ', ' ', ' ', ' ', '+' },
        { ' ', ' ', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', ' ', '+', ' ' },
        { '+', '+', '+', ' ', ' ', '+' },
        { '+', ' ', ' ', '+', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 3, grid);

    boolean foundExit = top.findTheExit();
   
    assertTrue(foundExit);
    assertEquals(3, top.getExitRow());
    assertEquals(0, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitOnBottom() {
    char[][] grid = {

        { '+', '+', ' ', '+', ' ', '+' },
        { '+', ' ', '+', '+', '+', '+' },
        { '+', ' ', ' ', ' ', ' ', '+' },
        { ' ', '+', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', ' ', '+', ' ' },
        { '+', '+', '+', ' ', ' ', '+' },
        { '+', ' ', '+', ' ', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 3, grid);

    boolean foundExit = top.findTheExit();

    assertTrue(foundExit);
    assertEquals(6, top.getExitRow());
    assertEquals(3, top.getExitColumn());
  }

  @Test
  public void testFailedFindTheExitOnRight() {
    char[][] grid = {

        { '+', '+', ' ', '+', ' ', '+' },
        { '+', ' ', '+', '+', '+', ' ' },
        { '+', ' ', ' ', ' ', ' ', '+' },
        { ' ', '+', ' ', ' ', ' ', '+' },
        { '+', ' ', ' ', ' ', ' ', ' ' },
        { '+', '+', '+', '+', ' ', '+' },
        { '+', ' ', '+', ' ', '+', '+' } };

    ObstacleCourse top = new ObstacleCourse(4, 3, grid);

    boolean foundExit = top.findTheExit();

    assertTrue(foundExit);
    assertEquals(4, top.getExitRow());
    assertEquals(5, top.getExitColumn());
  }
  
  @Test
  public void testWhenNoExitIsFound() {
	  char[][] grid = {
			  {'+', '+', '+', '+', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', '+', '+', '+', '+'}
	  };
	  ObstacleCourse top = new ObstacleCourse(1, 1, grid);
	  boolean foundExit = top.findTheExit();
	  assertFalse(foundExit);
  }
  
  @Test
  public void testWhenExitOnLeft() {
	  char[][] grid = {
			  {'+', '+', '+', '+', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {' ', ' ', ' ', ' ', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', '+', '+', '+', '+'}
	  };
	  ObstacleCourse top = new ObstacleCourse(1, 1, grid);
	  boolean foundExit = top.findTheExit();
	  assertTrue(foundExit);
	  assertEquals(2, top.getExitRow());
	  assertEquals(0, top.getExitColumn());
  }
  
  @Test
  public void testWhenExitOnBottom() {
	  char[][] grid = {
			  {'+', '+', '+', '+', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', ' ', ' ', ' ', '+'},
			  {'+', '+', ' ', '+', '+'}
	  };
	  ObstacleCourse top = new ObstacleCourse(1, 1, grid);
	  boolean foundExit = top.findTheExit();
	  assertTrue(foundExit);
	  assertEquals(4, top.getExitRow());
	  assertEquals(2, top.getExitColumn());
	  System.out.println(top.toString());
  }
}
