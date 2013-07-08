import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 * 
 * @author Vikrant Singhal
 */
public class GameTree {

	/**
	 * BinaryTreeNode inner class used to create new nodes in the GameTree.
	 */
	private class BinaryTreeNode {
		private String data;
		private BinaryTreeNode left;
		private BinaryTreeNode right;

		BinaryTreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}
	}

	/**
	 * instance variables.
	 */
	private BinaryTreeNode root;
	private Scanner my_inputFile;
	private String fileName;
	private BinaryTreeNode currentNodeReferenceInTree;

	/**
	 * Constructor needed to create the game.
	 * 
	 * @param name
	 *            this is the name of the file we need to import the game
	 *            questions and answers from.
	 */
	public GameTree(String name) {
		fileName = name;

		try {
			my_inputFile = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			my_inputFile = null;
			root = null;
		}

		root = build();
		if (my_inputFile != null)
			my_inputFile.close();
		currentNodeReferenceInTree = root;

	}

	private BinaryTreeNode build() {
		if (my_inputFile != null && my_inputFile.hasNextLine()) {

			String str = my_inputFile.nextLine();
			if (isAQuestion(str)) {
				BinaryTreeNode t = new BinaryTreeNode(str);
				t.left = build();
				t.right = build();
				return t;
			}
			return new BinaryTreeNode(str);
		}
		else return null;
	}

	private boolean isAQuestion(String str) {
		return str.charAt(str.length() - 1) == '?';
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQuestion
	 *            The question to add where the old answer was.
	 * @param newAnswer
	 *            The new Yes answer for the new question.
	 */
	public void add(String newQuestion, String newAnswer) {
		String temp = currentNodeReferenceInTree.data;
		currentNodeReferenceInTree.data = newQuestion;
		currentNodeReferenceInTree.left = new BinaryTreeNode(newAnswer);
		currentNodeReferenceInTree.right = new BinaryTreeNode(temp);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 * 
	 * @return False if the current node is an internal node rather than an
	 *         answer at a leaf.
	 */
	public boolean foundAnswer() {
		if (currentNodeReferenceInTree != null
				&& !isAQuestion(currentNodeReferenceInTree.data))
			return true;
		return false;
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.
	 * 
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		if (currentNodeReferenceInTree != null)
			return currentNodeReferenceInTree.data;
		return "";
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 * 
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo == Choice.Yes)
			currentNodeReferenceInTree = currentNodeReferenceInTree.left;
		else
			currentNodeReferenceInTree = currentNodeReferenceInTree.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the
	 * question at the root of this GameTree.
	 */
	public void reStart() {
		currentNodeReferenceInTree = root;
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 * 
	 */
	public void saveGame() {
		PrintWriter writer = null;
		try {
			if (my_inputFile == null)
				throw new FileNotFoundException(
						"Trying to write to a non-existent file!");
			writer = new PrintWriter(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			return;
		}
		write(writer, root);
		writer.close();
	}

	private void write(PrintWriter writer, BinaryTreeNode t) {
		if (t != null) {
			writer.println(t.data);
			write(writer, t.left);
			write(writer, t.right);
		}
	}

	@Override
	public String toString() {
		return traversal(root, "");
	}

	private String traversal(BinaryTreeNode t, String str) {
		if (t == null)
			return "";
		else {
			return traversal(t.right, str + "-") + str + t.data + '\n'
					+ traversal(t.left, str + "-");
		}
	}
}