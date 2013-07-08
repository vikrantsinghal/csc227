/**
 * ObstacleCourse: A type that reads a text file representing an obstacle course
 * from which to escape. This does not find the shortest path.
 * 
 * Most of the methods for the ObstacleCourse assignment are provided here. You
 * need to implement this one methods that is provided as a method stub at the
 * bottom of this file
 * 
 * public boolean findTheExit(int row, int col)
 * 
 * @author Vikrant Singhal
 */

public class ObstacleCourse {

	protected char[][] course;
	private int sRow;
	private int sCol;
	private int foundRow = -1;
	private int foundCol = -1;

	/**
	 * Initializes the 2d char array course.
	 */
	public ObstacleCourse(int startRow, int startCol, char[][] grid) {
		course = grid;
		sRow = startRow;
		sCol = startCol;
	}

	/**
	 * Returns the start column in the array
	 */
	public int getStartColumn() {
		return sCol;
	}

	/**
	 * Returns the starting row in the array
	 */
	public int getStartRow() {
		return sRow;
	}

	/*
	 * Returns the column of the found exit. Return -1 before trying or and if
	 * no exit was found after trying. There may be more than exit, but this
	 * method must return the row where the exit was found that terminates
	 * findTheExit.
	 */
	public int getExitColumn() {
		return foundCol;
	}

	/*
	 * Returns the row of the found exit. Return -1 before trying or and if no
	 * exit was found after trying. There may be more than exit, but this method
	 * must return the row where the exit was found that terminates findTheExit.
	 */
	public int getExitRow() {
		return foundRow;
	}

	/**
	 * Returns a string representation of the array
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < course[0].length; j++) {
				result += course[i][j];
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * This public method call the private helper provided as a stub below
	 */
	public boolean findTheExit() {
		return findTheExit(getStartRow(), getStartColumn());
	}

	/**
	 * This recursive backtracking method exhaustively searches the maze for an
	 * exit. It returns true if at the start row and start column set in the
	 * constructor an exit was found.
	 * 
	 * This method must also set these two instance variables when the exit is
	 * found foundRow and foundCol = -1;
	 * 
	 * Return false if an exit can not be found from the start position.
	 */
	public boolean findTheExit(int row, int col) {
		boolean escaped = false;
		if (course[row][col] == ' ') {
			course[row][col] = '.';
			if (row == 0 || row == course.length - 1 || col == 0
					|| col == course[0].length - 1) {
				foundRow = row;
				foundCol = col;
				escaped = true;
			} else {
				escaped = findTheExit(row + 1, col);
				if (escaped == false)
					escaped = findTheExit(row, col + 1);
				if (escaped == false)
					escaped = findTheExit(row - 1, col);
				if (escaped == false)
					escaped = findTheExit(row, col - 1);
				if (escaped == true) {
					course[row][col] = 'O';
				}
			}
		}
		return escaped;
	}

}