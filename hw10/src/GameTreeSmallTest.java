/*
 * A start of a unit test for class GameTree in the Game of 20 questions project.
 *
 * This class contains three methods to get you started and to explain some behavior.
 *
 *---@BeforeClass public static void setUp() throws FileNotFoundException
 * This setUp() method contains code that write a new file at
 * the beginning so that file always will have the same exact questions and answers.
 * Any method with @BeforeClass executes before any @Test method.
 *
 *---@Test public void testGameWithSevenNodes() {
 * Show how a game could be played by selecing Choice.Yes and Choice.No whi;
 * testing the current values of the nodes and asking if an abswer was found.
 *
 *---@Test public void testSaveGane() {
 * Test the save method after everything else is working!!!!!
 * Use testSaveGame to test your GameTree save method (you need to remove comments)
 * Method testSaveGame is a large test method that writes a new file, adds
 * questions and answers, saves the modified gGameTree and reads the new
 * game back to ensure save is working correctly.
 *
 * @author Rick Mercer
 */
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTreeSmallTest {

	// This code executes once and only once before and @Test method runs. Good
	// for initialization.
	// This allows you to ALWAYS begin with the same exact questions and answers
	@BeforeClass
	public static void setUp() throws FileNotFoundException {
		// Let outfile be an object like System.out. You can send println
		// messages to outfile
		PrintWriter outFile = new PrintWriter(new FileOutputStream(
				"t2UofATEST.txt"));

		// Write seven lines to an output file:
		outFile.println("Has feathers?");
		outFile.println("Barnyard?");
		outFile.println("chicken");
		outFile.println("owl");
		outFile.println("Is it a mammal?");
		outFile.println("tiger");
		outFile.println("rattlesnake");

		outFile.close(); // Make sure you close() the file
	}

	@Test
	public void testGameWithSevenNodes() {
		/*
		 * This test uses the following input file t2UofATEST.txt Has feathers?
		 * Barnyard? chicken owl Is it a mammal? tiger rattlesnake
		 */
		GameTree aGame = new GameTree("t2UofATEST.txt");
		// Output from toString()
		// - - rattlesnake
		// - Is it a mammal?
		// - - tiger
		// Has feathers?
		// - - owl
		// - Barnyard?
		// - - chicken
		//
		// Has feathers?
		// / \
		// Barnyard? Is it a mammal?
		// / \ / \
		// owl chicken rattlesnake tiger

		assertFalse(aGame.foundAnswer());
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		Choice userSelection = Choice.Yes;
		aGame.playerSelected(userSelection);
		assertEquals("Barnyard?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.No);
		assertEquals("owl", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());
		aGame.playerSelected(Choice.Yes);
		assertFalse(aGame.foundAnswer());
		assertEquals("", aGame.getCurrent());
		aGame.reStart();
		assertEquals("Has feathers?", aGame.getCurrent());

		System.out.println(aGame.toString());
	}

	@Test
	public void testWithThreeNodes(){
		GameTree game = new GameTree("teams.txt");
		game.saveGame();
		//game.playerSelected(Choice.Yes);
		//assertEquals("Manchester United", game.getCurrent());
		//game.add("Is it Manchester City?", "Manchester City");
		//game.playerSelected(Choice.No);
		//assertEquals("Manchester United", game.getCurrent());
		//System.out.println(game.toString());
	}
	
	@Test
	public void testWithNoFile() {
		GameTree game = new GameTree("lol.txt");
		game.saveGame();
	}
	
	@Test
	public void actorsTest() {
		GameTree game = new GameTree("actors.txt");
		game.saveGame();
		System.out.println(game.toString());
		game.playerSelected(Choice.Yes);
		game.add("Was he there in Cassino Royale?", "Daniel Craig");
		assertEquals("Was he there in Cassino Royale?", game.getCurrent());
		game.playerSelected(Choice.Yes);
		assertEquals("Daniel Craig", game.getCurrent());
	}
	
	@Test
	public void animalsTest() {
		GameTree game = new GameTree("animals.txt");
		System.out.println(game.toString());
	}
}