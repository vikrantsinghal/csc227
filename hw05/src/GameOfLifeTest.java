// Tests all methods in GameOfLife class.

import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
		System.out.println(society.toString());
	}

	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);

		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
		assertFalse(society.cellAt(0, 0));
		assertFalse(society.cellAt(1, 0));
		assertFalse(society.cellAt(4, 4));

		System.out.println(society.toString());
	}

	@Test
	public void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 16);

		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);

		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));

		society = new GameOfLife(6, 8);

		society.growCellAt(0, 0);
		society.growCellAt(5, 7);
		society.growCellAt(0, 7);
		society.growCellAt(3, 4);
		society.growCellAt(2, 1);
		society.growCellAt(4, 7);
		society.growCellAt(5, 3);
		society.growCellAt(3, 5);
		society.growCellAt(1, 4);

		assertEquals(1, society.neighborCount(0, 1));
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(2, society.neighborCount(0, 7));
		assertEquals(2, society.neighborCount(4, 3));
		assertEquals(3, society.neighborCount(2, 4));
		assertEquals(3, society.neighborCount(4, 6));
		assertEquals(1, society.neighborCount(3, 7));
		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(4, society.neighborCount(5, 0));
		assertEquals(0, society.neighborCount(4, 1));

		society = new GameOfLife(1, 1);

		assertEquals(0, society.neighborCount(0, 0));

		society = new GameOfLife(5, 1);

		society.growCellAt(0, 0);
		society.growCellAt(2, 0);
		society.growCellAt(3, 0);

		assertEquals(0, society.neighborCount(0, 0));
		assertEquals(2, society.neighborCount(1, 0));
		assertEquals(1, society.neighborCount(2, 0));
		assertEquals(2, society.neighborCount(4, 0));

		society = new GameOfLife(1, 5);

		society.growCellAt(0, 0);
		society.growCellAt(0, 2);
		society.growCellAt(0, 3);

		assertEquals(0, society.neighborCount(0, 0));
		assertEquals(2, society.neighborCount(0, 1));
		assertEquals(1, society.neighborCount(0, 2));
		assertEquals(2, society.neighborCount(0, 4));

		society = new GameOfLife(1, 2);

		society.growCellAt(0, 1);

		assertEquals(0, society.neighborCount(0, 1));
		assertEquals(1, society.neighborCount(0, 0));

		society = new GameOfLife(2, 1);

		society.growCellAt(1, 0);

		assertEquals(0, society.neighborCount(1, 0));
		assertEquals(1, society.neighborCount(0, 0));

		society = new GameOfLife(2, 5);

		society.growCellAt(0, 0);
		society.growCellAt(1, 0);
		society.growCellAt(1, 2);
		society.growCellAt(1, 4);

		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(1, society.neighborCount(0, 2));
		assertEquals(3, society.neighborCount(0, 4));
		assertEquals(2, society.neighborCount(1, 0));
		assertEquals(0, society.neighborCount(1, 2));

		society = new GameOfLife(1, 2);

		society.growCellAt(0, 1);

		assertEquals(0, society.neighborCount(0, 1));
		assertEquals(1, society.neighborCount(0, 0));

		society = new GameOfLife(5, 2);

		society.growCellAt(0, 0);
		society.growCellAt(0, 1);
		society.growCellAt(2, 1);
		society.growCellAt(4, 1);

		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(1, society.neighborCount(2, 0));
		assertEquals(3, society.neighborCount(4, 0));
		assertEquals(2, society.neighborCount(0, 1));
		assertEquals(0, society.neighborCount(2, 1));

		society = new GameOfLife(2, 2);

		society.growCellAt(0, 0);

		assertEquals(0, society.neighborCount(0, 0));
		assertEquals(1, society.neighborCount(0, 1));
		assertEquals(1, society.neighborCount(1, 0));
		assertEquals(1, society.neighborCount(1, 1));
	}

	@Test
	public void testUpdate() {
		GameOfLife society = new GameOfLife(7, 7);

		society.growCellAt(0, 0);
		society.growCellAt(0, 6);
		society.growCellAt(6, 0);
		society.growCellAt(1, 5);
		society.growCellAt(2, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 3);
		society.growCellAt(4, 4);
		society.growCellAt(3, 5);

		society.update();

		assertTrue(society.cellAt(0, 0));
		assertTrue(society.cellAt(0, 6));
		assertTrue(society.cellAt(1, 6));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(2, 3));
		assertTrue(society.cellAt(3, 2));
		assertTrue(society.cellAt(3, 3));
		assertTrue(society.cellAt(4, 4));
		assertTrue(society.cellAt(6, 0));
		assertTrue(society.cellAt(6, 6));
		assertFalse(society.cellAt(1, 1));
		assertFalse(society.cellAt(1, 5));
		assertFalse(society.cellAt(0, 5));
		assertFalse(society.cellAt(3, 5));
		assertFalse(society.cellAt(3, 4));

		society.update();

		assertTrue(society.cellAt(0, 5));
		assertTrue(society.cellAt(1, 0));
		assertTrue(society.cellAt(1, 6));
		assertTrue(society.cellAt(3, 2));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(2, 3));
		assertTrue(society.cellAt(3, 4));
		assertTrue(society.cellAt(4, 3));
		assertTrue(society.cellAt(6, 0));
		assertTrue(society.cellAt(6, 6));
		assertFalse(society.cellAt(0, 0));
		assertFalse(society.cellAt(0, 6));
		assertFalse(society.cellAt(3, 3));
		assertFalse(society.cellAt(4, 4));
	}

}
