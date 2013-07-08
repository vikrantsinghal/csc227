import static org.junit.Assert.*;

import org.junit.Test;


public class BoggleTrayTest {
	
	private char[][] tray = { { 'A', 'B', 'C', 'D' }, { 'E', 'F', 'G', 'H' },
			{ 'I', 'J', 'K', 'L' }, { 'M', 'N', 'O', 'P' } };
	
	private char[][] tray2 = { { 'a', 'B', 'c', 'D' }, { 'E', 'f', 'G', 'h' },
			{ 'i', 'J', 'k', 'L' }, { 'M', 'n', 'O', 'p' } };
	
	private char[][] tray3 = { { 'r', 'e', 'd', 'm' }, { 'b', 'a', 'n', 'o' },
			{ 't', 'q', 'd', 'f' }, { 'l', 'o', 'e', 'v' } };
	
	private char[][] tray4 = { { 'q', 'i', 'e', 't' }, { 'a', 's', 'q', 'k' },
			{ 'a', 'c', 'd', 'a' }, { 'm', 'p', 'l', 'n' } };



	@Test
	public void testStringFindWhenThereStartingInUpperLeftCorner() {
		BoggleTray bt = new BoggleTray(tray);
		assertTrue(bt.foundInBoggleTray("ABC"));
		assertTrue(bt.foundInBoggleTray("abC"));
		assertTrue(bt.foundInBoggleTray("aBf"));
		assertTrue(bt.foundInBoggleTray("abc"));
		assertTrue(bt.foundInBoggleTray("ABCD"));
		assertTrue(bt.foundInBoggleTray("ABFEJINM"));
		assertTrue(bt.foundInBoggleTray("AbCdHgFeIjKLpONm"));
		assertTrue(bt.foundInBoggleTray("ABCDHLPOKJNMIEFG"));
		System.out.println(bt.toString());
	}

	@Test
	public void testStringFindWhenNotThere() {
		BoggleTray bt = new BoggleTray(tray);
		assertTrue(bt.foundInBoggleTray("ab"));
		assertFalse(bt.foundInBoggleTray("acb"));
		assertFalse(bt.foundInBoggleTray("AiE"));
	}

	@Test
	public void testStringFindWhenAttemptIsMadeToUseALetterTwice() {
		BoggleTray bt = new BoggleTray(tray);
		assertFalse(bt.foundInBoggleTray("ABA"));
		assertFalse(bt.foundInBoggleTray("ABB"));
		assertFalse(bt.foundInBoggleTray("aEa"));
	}
	
	@Test
	public void BoggleTrayTestWhenLettersOnEdgeFound() {
		BoggleTray bt = new BoggleTray(tray2);
		assertTrue(bt.foundInBoggleTray("aEiM"));
		assertTrue(bt.foundInBoggleTray("ei"));
		assertTrue(bt.foundInBoggleTray("no"));
		assertTrue(bt.foundInBoggleTray("bc"));
		assertTrue(bt.foundInBoggleTray("hl"));
		assertFalse(bt.foundInBoggleTray(""));
		assertTrue(bt.foundInBoggleTray("lgkje"));
	}
	
	@Test
	public void BoggleTrayTestWhenLettersOnEdgeNotFound() {
		BoggleTray bt = new BoggleTray(tray2);
		assertFalse(bt.foundInBoggleTray("aEik"));
		assertFalse(bt.foundInBoggleTray("nkb"));
		assertFalse(bt.foundInBoggleTray("lgkjb"));
		assertFalse(bt.foundInBoggleTray("aEik"));
		assertFalse(bt.foundInBoggleTray("aEik"));
	}
	
	@Test
	public void BoggleTrayTestWhenLettersOnCornersFound() {
		BoggleTray bt = new BoggleTray(tray2);
		assertTrue(bt.foundInBoggleTray("dGJMn"));
		assertTrue(bt.foundInBoggleTray("pklgfjno"));
		assertTrue(bt.foundInBoggleTray("aeinjfghcd"));
		assertTrue(bt.foundInBoggleTray("mnkp"));
		assertTrue(bt.foundInBoggleTray("m"));
	}
	
	@Test
	public void BoggleTrayTestWhenLettersOnCornersNotFound() {
		BoggleTray bt = new BoggleTray(tray2);
		assertFalse(bt.foundInBoggleTray("dMPa"));
		assertFalse(bt.foundInBoggleTray("dkbose"));
		assertFalse(bt.foundInBoggleTray("dbug"));
		assertFalse(bt.foundInBoggleTray("dump"));
		assertFalse(bt.foundInBoggleTray("mop"));
	}
	
	@Test
	public void BoggleTrayTest() {
		BoggleTray bt = new BoggleTray(tray3);
		assertTrue(bt.foundInBoggleTray("dander"));
		assertFalse(bt.foundInBoggleTray("dkbose"));
		assertFalse(bt.foundInBoggleTray("dbug"));
		assertFalse(bt.foundInBoggleTray("dump"));
		assertFalse(bt.foundInBoggleTray("mop"));
	}
	
	@Test
	public void turnQUToQTest() {
		BoggleTray bt = new BoggleTray(tray4);
		assertEquals("Qiet", bt.turnQUToQ("QUiet"));
	}
	
	@Test
	public void BoggleTrayTestForQ() {
		BoggleTray bt = new BoggleTray(tray4);
		assertTrue(bt.foundInBoggleTray("quiet"));
		assertFalse(bt.foundInBoggleTray("dkbose"));
		assertFalse(bt.foundInBoggleTray("dbug"));
		assertFalse(bt.foundInBoggleTray("dump"));
		assertFalse(bt.foundInBoggleTray("mop"));
		System.out.println(bt.toString());
	}
	
	@Test
	public void randomConstructorTest() {
		BoggleTray bt = new BoggleTray();
		System.out.println(bt.toString());
	}

}
