import java.util.Random;

/**
 * This class represents the model for a game of MineSweeper. It has a
 * constructor that takes a preset boolean 2D array where true means there is a
 * mine. This first constructor (you'll need 2) is for testing the methods of
 * this class.
 * 
 * The second constructor that takes the number of rows, the number of columns,
 * and the number of mines to be set randomly in that sized mine field. Do this
 * last.
 * 
 * @author VIKRANT SINGHAL
 */
public class MineSweeper implements MineSweeperModel {

	private class GameSquare {

		private boolean isMine;
		private int row;
		private int col;
		private boolean isVisible;
		private boolean isFlagged;
		private int mineNeighbors;

		// Construct a GameSquare object with all values initialized except
		// mineNeighbors, which is an instance variables that can only be set
		// after
		// all
		// GameSquare objects have been constructed in the 2D array.
		public GameSquare(boolean isMine, int row, int col) {
			this.isMine = isMine;
			this.row = row;
			this.col = col;
			isVisible = false; // Default until someone starts clicking
			isFlagged = false; // Default until someone starts clicking
			// call setAdjacentMines() from both constructors
			// to set this for each new GameSquare.
			mineNeighbors = 0;
		}
	}

	// The instance variable represents all GameSquare objects where each knows
	// its row, column, number of mines around it, if it is a mine, flagged, or
	// visible
	private GameSquare[][] board;
	private int nRows;
	private int nCols;

	/**
	 * Construct a MineSweeper object using a given mine field represented by an
	 * array of boolean values: true means there is mine, false means there is
	 * not a mine at that location.
	 * 
	 * @param mines
	 *            A 2D array to represent a mine field so all methods can be
	 *            tested with no random placements.
	 */
	public MineSweeper(boolean[][] mines) {
		board = new GameSquare[mines.length][mines[0].length];
		nRows = mines.length;
		nCols = mines[0].length;

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				board[i][j] = new GameSquare(mines[i][j], i, j);
			}
		}

		setAdjacentMines();
	}

	/**
	 * Use the almost initialized 2D array of GameSquare objects to set the
	 * instance variable mineNeighbors for every 2D array element (even if that
	 * one GameSquare has a mine). This is similar to GameOfLife neighborCount.
	 */
	private void setAdjacentMines() {
		for (int row = 0; row < nRows; row++) {
			for (int column = 0; column < nCols; column++) {
				for (int i = row - 1; i <= row + 1; i++) {
					for (int j = column - 1; j <= column + 1; j++) {
						if (j < nCols && j >= 0 && i < nRows && i >= 0) {
							if (i == row && j == column)
								;
							else {
								if (this.isMine(i, j))
									board[row][column].mineNeighbors++;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method returns the number of mines surrounding the requested
	 * GameSquare (the mineNeighbors value of the square). A square with a mine
	 * may return the number of surrounding mines, even though it will never
	 * display that information.
	 * 
	 * @param row
	 *            - An int value representing the row in board.
	 * @param column
	 *            - An int value representing the column in board.
	 * @return The number of mines surrounding to this GameSquare
	 *         (mineNeighbors)
	 * 
	 *         Must run O(1)
	 */
	public int getAdjacentMines(int row, int column) {
		return board[row][column].mineNeighbors;
	}

	/**
	 * Construct a MineSweeper of any size that has numberOfMines randomly set
	 * so we get different games.
	 * 
	 * @param rows
	 *            Height of the board
	 * @param columns
	 *            Width of the board
	 * @param numberOfMines
	 *            How m any mines are to randomly placed
	 */
	public MineSweeper(int rows, int columns, int numberOfMines) {
		Random generator = new Random();
		board = new GameSquare[rows][columns];
		nRows = rows;
		nCols = columns;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = new GameSquare(false, i, j);
			}
		}
		for (int i = 1; i <= numberOfMines; i++) {
			int k = 0;
			while (k != 1) {
				int r = generator.nextInt(rows);
				int c = generator.nextInt(columns);
				if (! isMine(r, c)) {
					board[r][c].isMine = true;
					k = 1;
				}
			}
		}
		this.setAdjacentMines();
	}

	/**
	 * This method returns the number of mines found in the game board.
	 * 
	 * @return The number of mines.
	 */
	public int getTotalMineCount() {
		int count = 0;
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (board[i][j].isMine == true)
					count++;
			}
		}
		return count;
	}

	/**
	 * This method returned whether or not the square has been flagged by the
	 * user. Flags are a tool used by players to quickly tell which squares they
	 * think contain mines as well as prevent accidental clicking on those
	 * squares.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean value representing the flagged state of this location.
	 */
	public boolean isFlagged(int row, int column) {
		return board[row][column].isFlagged == true;
	}

	public void toggleFlagged(int row, int column) {
		if (board[row][column].isFlagged == true
				&& board[row][column].isVisible == false)
			board[row][column].isFlagged = false;
		else if (board[row][column].isFlagged == false
				&& board[row][column].isVisible == false)
			board[row][column].isFlagged = true;
	}

	/**
	 * This method determines if the square in question is a mine.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean representing the mine status of the square.
	 */
	public boolean isMine(int row, int column) {
		return board[row][column].isMine == true;
	}

	/**
	 * This method gets the visibility of the square in question. Visibilty is
	 * initially defined for all squares to be false and uncovered when the
	 * click method checks the square.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean representing whether or not the square is set to be
	 *         visible.
	 */
	public boolean isVisible(int row, int column) {
		return board[row][column].isVisible == true;
	}

	/**
	 * This method determines if the player has lost on the current board. A
	 * player loses if and only if they have clicked on a mine.
	 * 
	 * @return A boolean representing player failure.
	 */
	public boolean lost() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (board[i][j].isMine == true && board[i][j].isVisible == true)
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns a textual representation of the GameBoard. Squares will be
	 * represented by one character followed by a space, except the last
	 * character which will have no following space. Visible squares will either
	 * be the number of mines next to the square, a blank space if no mines are
	 * adjacent, or a '*' character for a mine. Newlines will separate each row
	 * of the game board.
	 * 
	 * @return A String representation of the game board data.
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (this.isMine(i, j)) {
					if (j < nCols - 1)
						result = result + "*" + " ";
					else
						result = result + "*" + '\n';
				} else if (this.getAdjacentMines(i, j) > 0) {
					if (j < nCols - 1)
						result = result + this.getAdjacentMines(i, j) + " ";
					else
						result = result + this.getAdjacentMines(i, j) + '\n';
				} else {
					if (j < nCols - 1)
						result = result + " " + " ";
					else
						result = result + " " + '\n';
				}
			}
		}
		return result;
	}

	/**
	 * This method determines if a player has won the game. Winning means all
	 * non-mine squares are visible and no mines have been detonated.
	 * 
	 * @return A boolean representing whether or not the player has won.
	 */
	public boolean won() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (board[i][j].isVisible == false) {
					if (board[i][j].isMine == false)
						return false;
				} else if (board[i][j].isMine == true
						&& board[i][j].isVisible == true)
					return false;
			}
		}
		return true;
	}

	/**
	 * This method alerts the Game Board the user has clicked on the square at
	 * the given row/column. There are five possibilities for updating the board
	 * during the click messages to your MineSweeper. The GameSquare object
	 * stored at the just clicked row and column
	 * 
	 * 1. is a mine (player looses)
	 * 
	 * 2. is visible already (do nothing)
	 * 
	 * 3. is flagged (do nothing)
	 * 
	 * 4. has mineNeighbors >- 1 (simply mark that visible)
	 * 
	 * 5. is not adjacent to any mines with mineNeighbors == 0 (mark many
	 * visible)
	 * 
	 * Because MineSweeper automatically clears all squares adjacent to any
	 * blank square connected to the square clicked, a special algorithm is
	 * needed to set the proper part of the board visible. This pseudo-code
	 * shows the suggested algorithm.
	 */
	// Check special cases first, there may be nothing to do or the user clicked
	// a mine
	// if the clicked GameSquare is flagged
	// return, there is nothing to do
	// else if the clicked GameSquare is a mine
	// record loss so when this click is done, lost() returns true
	// else if the clicked GameSquare has already been marked as visible
	// return, there is nothing to do
	// else if the clicked GameSquare has 1 or more neighboring mines
	// set the square to be visible, which applies only when mineNeighbors is
	// 1..8
	// else
	// mark the clicked GameSquare as visible
	// push the GameSquare onto the stack
	// while the stack is not empty:
	// pop the stack and mark GameSquare as the current GameSquare
	// if the current square must has no neighboring mines (not 1..8)
	// for each adjacent square
	// if it's visible or flagged
	// ignore it
	// else
	// push adjacent GameSquare on stack
	// set adjacent GameSquare to visible
	/**
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 */
	public void click(int row, int column) {
		if (this.isMine(row, column)) {
			board[row][column].isVisible = true;
			lost();
		} else if (this.isFlagged(row, column))
			return;
		else if (this.isVisible(row, column))
			return;
		else if (this.getAdjacentMines(row, column) > 0) {
			board[row][column].isVisible = true;
			return;
		} else {
			board[row][column].isVisible = true;
			LinkedStack<GameSquare> stack = new LinkedStack<GameSquare>();
			stack.push(board[row][column]);

			while (!stack.isEmpty()) {
				GameSquare current = stack.pop();
				if (this.getAdjacentMines(current.row, current.col) == 0) {
					for (int i = current.row - 1; i <= current.row + 1; i++) {
						for (int j = current.col - 1; j <= current.col + 1; j++) {
							if (j < nCols && j >= 0 && i < nRows && i >= 0) {
								if (i == current.row && j == current.col)
									;
								else {
									if (board[i][j].isVisible == true
											|| board[i][j].isFlagged == true)
										;
									else {
										stack.push(board[i][j]);
										board[i][j].isVisible = true;
									}
								}
							}
						}
					}
				}
			}
		}
	}
}