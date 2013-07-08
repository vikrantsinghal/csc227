import static org.junit.Assert.*;

import org.junit.Test;

public class BoggleTest {
	private char[][] tray = { { 'q', 'i', 'e', 't' }, { 'a', 's', 'q', 'k' },
			{ 'a', 'c', 'd', 'a' }, { 'm', 'p', 's', 'n' } };

	@Test
	public void boggleRandomConstructorAndToStringTest() {
		Boggle b = new Boggle();
		System.out.println(b.getBoggleTrayAsString());
	}

	@Test
	public void boggleSetBoggleTrayTest() {
		BoggleTray bt = new BoggleTray(tray);
		Boggle b = new Boggle();
		System.out.println(b.getBoggleTrayAsString());
		b.setBoggleTray(bt);
		int c = b.wordsMissedNumber();
		System.out.println(b.getBoggleTrayAsString());
		b.addGuess("quiet");
		b.addGuess("sad");
		b.addGuess("map");
		assertEquals(0, b.wordsWrongNumber());
		assertEquals(3, b.wordsRightNumber());
		b.addGuess("duggy");
		assertEquals(1, b.wordsWrongNumber());
		assertEquals(c - 3, b.wordsMissedNumber());
		assertEquals(3, b.getScore());
	}

	@Test
	public void addGuessTest() {
		Boggle b = new Boggle();
		int num = b.wordsMissedNumber();
		int c = b.wordsRightNumber();
		assertEquals(0, b.wordsWrongNumber());
		b.addGuess("Lol");
		assertEquals(1, b.wordsWrongNumber());
		assertEquals(-1, b.getScore());
		b.addGuess("a");
		assertEquals(-2, b.getScore());
		b.addGuess("a");
		assertEquals(0, b.wordsRightNumber());
		assertEquals(2, b.wordsWrongNumber());
		assertEquals(-2, b.getScore());
		b.addGuess("");
		assertEquals(0, b.wordsRightNumber());
		assertEquals(2, b.wordsWrongNumber());
		assertEquals(-2, b.getScore());
		assertEquals(num, b.wordsMissedNumber());
		System.out.println(b.wordsMissedNumber());
	}

	@Test
	public void testWhenNoWordFound() {
		Boggle b = new Boggle();
		b.addGuess("Chutiya");
		b.addGuess("Chutiya");
		b.addGuess("Harami");
		b.addGuess("Kamina");
		b.addGuess("Ullu");
		assertEquals(4, b.wordsWrongNumber());
		assertEquals(-4, b.getScore());
	}

	@Test
	public void testGetWordsFoundAfterPrepareResultsCalledWithSetBoggleTray() {

		char[][] tray = { { 'E', 'R', 'H', 'I' },
				          { 'T', 'C', 'O', 'Z' },
				          { 'I', 'E', 'S', 'E' },
				          { 'V', 'E', 'V', 'W' } };

		BoggleTray dt = new BoggleTray(tray);
		Boggle game = new Boggle();
		game.setBoggleTray(dt);
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("tEeS");
		game.addGuess("Receives");
		game.addGuess("Sort");
		game.addGuess("cites");
		game.addGuess("seCreTive");
		game.addGuess("NotHere");
		game.addGuess("NotHere");
		game.addGuess("sew");

		assertEquals(27, game.getScore());
		assertEquals("[cites, receives, secretive, see, sew, sort, tees]", game
				.getWordsFound().toString());

		assertEquals("[nothere]", game.getWordsIncorrect().toString());
		assertTrue(game.getWordsNotGuessed().contains("secret"));
		assertTrue(game.getWordsNotGuessed().contains("recite"));
	}
	
	@Test
	public void scoreTestAgain() {
		char[][] tray1 = {{'N', 'I', 'P', 'P'},
				         {'A', 'S', 'E', 'L'},
				         {'C', 'A', 'T', 'M'},
				         {'B', 'A', 'C', 'K'}};
		Boggle b = new Boggle();
		BoggleTray bt = new BoggleTray(tray1);
		b.setBoggleTray(bt);
		b.addGuess("nipple");
		b.addGuess("nipples");
		b.addGuess("back");
		assertEquals(9, b.getScore());
	}

}
