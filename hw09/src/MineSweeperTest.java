/**
 * The beginning of a unit test for MineSweeper.  
 */
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("unused")
public class MineSweeperTest {

	@Test
	public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

		boolean[][] b1 =

		{ { false, false, false, false, false },
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);

		// Check adjacent mines around every possible GameSquare
		assertEquals(0, ms.getAdjacentMines(0, 0));
		assertEquals(1, ms.getAdjacentMines(0, 1));
		assertEquals(2, ms.getAdjacentMines(0, 2));
		assertEquals(2, ms.getAdjacentMines(0, 3));
		assertEquals(1, ms.getAdjacentMines(0, 4));

		assertEquals(0, ms.getAdjacentMines(1, 0));
		assertEquals(1, ms.getAdjacentMines(1, 1));
		assertEquals(2, ms.getAdjacentMines(1, 2)); // works even if it is a
													// mine
		assertEquals(2, ms.getAdjacentMines(1, 3));
		assertEquals(2, ms.getAdjacentMines(1, 4));

		assertEquals(0, ms.getAdjacentMines(2, 0));
		assertEquals(1, ms.getAdjacentMines(2, 1));
		assertEquals(3, ms.getAdjacentMines(2, 2));
		assertEquals(2, ms.getAdjacentMines(2, 3));
		assertEquals(2, ms.getAdjacentMines(2, 4));

		assertEquals(3, ms.getTotalMineCount());
	}

	@Test
	public void setElementsTest() {
		boolean[][] b = { { true, true, false, true },
				{ true, false, false, true }, { false, false, true, false },
				{ true, false, true, true } };
		MineSweeper ms = new MineSweeper(b);
		assertEquals(2, ms.getAdjacentMines(0, 0));
		assertEquals(2, ms.getAdjacentMines(0, 1));
		assertEquals(3, ms.getAdjacentMines(0, 2));
		assertEquals(1, ms.getAdjacentMines(0, 3));
		assertEquals(2, ms.getAdjacentMines(1, 0));
		assertEquals(4, ms.getAdjacentMines(1, 1));
		assertEquals(4, ms.getAdjacentMines(1, 2));
		assertEquals(2, ms.getAdjacentMines(1, 3));
		assertEquals(2, ms.getAdjacentMines(2, 0));
		assertEquals(4, ms.getAdjacentMines(2, 1));
		assertEquals(3, ms.getAdjacentMines(2, 2));
		assertEquals(4, ms.getAdjacentMines(2, 3));
		assertEquals(0, ms.getAdjacentMines(3, 0));
		assertEquals(3, ms.getAdjacentMines(3, 1));
		assertEquals(2, ms.getAdjacentMines(3, 2));
		assertEquals(2, ms.getAdjacentMines(3, 3));

		System.out.println(ms.toString());

		assertFalse(ms.lost());
		assertFalse(ms.won());
	}

	@Test
	public void randomConstructorTest() {
		MineSweeper ms = new MineSweeper(5, 5, 10);
		assertEquals(10, ms.getTotalMineCount());
		System.out.print(ms.toString());
	}

	@Test
	public void clickTest() {
		boolean[][] b = { { false, true, false, false },
				{ false, false, false, false }, { true, false, false, true },
				{ false, true, true, false } };
		MineSweeper ms = new MineSweeper(b);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				assertFalse(ms.isVisible(i, j));
			}
		}
		ms.click(1, 1);
		assertTrue(ms.isVisible(1, 1));
		assertFalse(ms.isVisible(0, 0));
		ms.click(1, 3);
		ms.toggleFlagged(1, 2);
		ms.click(0, 3);
		assertTrue(ms.isVisible(0, 3));
		assertTrue(ms.isVisible(1, 3));
		assertTrue(ms.isVisible(0, 2));
		assertFalse(ms.isVisible(1, 2));

		ms.toggleFlagged(3, 0);
		ms.click(3, 0);
		assertFalse(ms.isVisible(3, 0));

		ms.click(3, 3);
		assertTrue(ms.isVisible(3, 3));
		ms.click(3, 3);
		assertTrue(ms.isVisible(3, 3));

		ms.click(0, 1);
		assertTrue(ms.isVisible(0, 1));

		System.out.println(ms.toString());
	}

	@Test
	public void wonTest() {
		boolean[][] b = { { true, true, false }, { false, false, false },
				{ true, true, true } };
		MineSweeper ms = new MineSweeper(b);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!ms.isMine(i, j))
					ms.click(i, j);
			}
		}
		assertTrue(ms.won());
	}

	@Test
	public void toggleFlaggedTest() {
		boolean[][] b = { { false, true, false, false },
				{ false, false, false, false }, { true, false, false, true },
				{ false, true, true, false } };
		MineSweeper ms = new MineSweeper(b);

		ms.click(0, 0);
		ms.toggleFlagged(0, 0);
		assertFalse(ms.isFlagged(0, 0));

		ms.toggleFlagged(0, 1);
		assertTrue(ms.isFlagged(0, 1));
		assertFalse(ms.isVisible(0, 1));

		ms.toggleFlagged(0, 1);
		assertFalse(ms.isFlagged(0, 1));
	}

	@Test
	public void Test() {
		boolean[][] b = { { false, false, false, false },
				{ false, false, false, false }, { false, false, false, false },
				{ false, false, true, false } };
		MineSweeper ms = new MineSweeper(b);
		System.out.println(ms.toString());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				ms.click(i, j);
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(ms.isVisible(i, j));
			}
		}
		assertFalse(ms.won());
	}
	
	@Test
	public void anotherTest() {
		MineSweeper ms = new MineSweeper(5, 5, 15);
		System.out.print(ms.toString());
	}
	
	@Test
	public void Tes1() {
		boolean b[][] = {{false, false, false}, {false, false, false}, {false, false, false}};
		MineSweeper ms = new MineSweeper(b);
		ms.click(2, 2);
		assertTrue(ms.isVisible(2, 2));
		assertTrue(ms.isVisible(0, 0));
		assertTrue(ms.isVisible(0, 1));
		assertTrue(ms.isVisible(0, 2));
		assertTrue(ms.isVisible(1, 0));
		assertTrue(ms.isVisible(1, 2));
		assertTrue(ms.isVisible(2, 0));
		assertTrue(ms.isVisible(2, 1));
		assertTrue(ms.isVisible(1, 1));
	}
}