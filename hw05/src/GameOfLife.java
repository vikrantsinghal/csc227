/**
 * A model for John Conway's Game of Life. The design (methods, parameters,
 * return types) by Vikrant Singhal.
 */

public class GameOfLife {

	private int nRows;
	private int nCols;
	private boolean[][] society;
	private boolean[][] societyPrevStatus;
	private String result = new String();
	private int top = 0;
	private int bottom = 0;
	private int right = 0;
	private int left = 0;

	// Constructor: Takes the numbers of rows and values and initialises
	// society. Empty places have false values.
	public GameOfLife(int rows, int cols) {
		top = bottom = right = left = 0;
		nRows = rows;
		nCols = cols;
		society = new boolean[nRows][nCols];
		societyPrevStatus = new boolean[nRows][nCols];

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				society[i][j] = false;
				societyPrevStatus[i][j] = false;
				result = result + ".";
			}
			result = result + '\n';
		}
	}

	// Returns the number of rows in the society.
	public int numberOfRows() {
		return nRows;
	}

	// Returns the number of columns in the society.
	public int numberOfColumns() {
		return nCols;
	}

	// Places a new cell at the specified row and column.
	public void growCellAt(int row, int col) {
		if ((row < nRows && row >= 0) && (col < nCols && col >= 0)) {
			society[row][col] = true;
			societyPrevStatus[row][col] = true;
		}
	}

	// Returns true if there is a cell at the specified location.
	public boolean cellAt(int row, int col) {
		if (row < nRows && col < nCols) {
			if (society[row][col] == true)
				return true;
		}
		return false;
	}

	// Returns a textual representation of the society.
	@Override
	public String toString() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (society[i][j] == true)
					result = result + "O";
				else
					result = result + ".";
			}
			result = result + '\n';
		}
		return result;
	}

	// Returns the number of neighbors around any cell using wrap around.
	public int neighborCount(int row, int col) {
		int count = 0;

		if ((row >= 0 && row < nRows) && (col >= 0 && col < nCols)) {
			top = row - 1;
			bottom = row + 1;
			right = col + 1;
			left = col - 1;

			if (row == 0)
				top = nRows - 1;
			if (row == nRows - 1)
				bottom = 0;
			if (col == 0)
				left = nCols - 1;
			if (col == nCols - 1)
				right = 0;

			if (nRows == 1 && nCols > 1) {
				if (right != left) {
					if (society[row][left] == true)
						count++;
					if (society[row][right] == true)
						count++;
				} else {
					if (society[row][left] == true)
						count++;
				}
			} else if (nRows > 1 && nCols == 1) {
				if (top != bottom) {
					if (society[top][col] == true)
						count++;
					if (society[bottom][col] == true)
						count++;
				} else {
					if (society[top][col] == true)
						count++;
				}
			}

			else if (nRows == 1 && nCols == 1) {
				return 0;
			}

			else if (left != right) {
				if (top != bottom) {
					if (society[top][col] == true)
						count++;
					if (society[top][right] == true)
						count++;
					if (society[row][right] == true)
						count++;
					if (society[bottom][right] == true)
						count++;
					if (society[bottom][col] == true)
						count++;
					if (society[bottom][left] == true)
						count++;
					if (society[row][left] == true)
						count++;
					if (society[top][left] == true)
						count++;
				} else {
					if (society[top][left] == true)
						count++;
					if (society[top][col] == true)
						count++;
					if (society[top][right] == true)
						count++;
					if (society[row][left] == true)
						count++;
					if (society[row][right] == true)
						count++;
				}
			}

			else if (left == right) {
				if (top != bottom) {
					if (society[top][col] == true)
						count++;
					if (society[top][right] == true)
						count++;
					if (society[row][right] == true)
						count++;
					if (society[bottom][right] == true)
						count++;
					if (society[bottom][col] == true)
						count++;
				} else {
					if (society[top][left] == true)
						count++;
					if (society[top][col] == true)
						count++;
					if (society[row][left] == true)
						count++;
				}
			}
		}
		return count;
	}

	// Returns the number of neighbors around any cell in the state of society
	// before getting updated.
	public int neighborCountPrev(int row, int col) {
		int count = 0;

		if ((row >= 0 && row < nRows) && (col >= 0 && col < nCols)) {
			top = row - 1;
			bottom = row + 1;
			right = col + 1;
			left = col - 1;

			if (row == 0)
				top = nRows - 1;
			if (row == nRows - 1)
				bottom = 0;
			if (col == 0)
				left = nCols - 1;
			if (col == nCols - 1)
				right = 0;

			if (nRows == 1 && nCols > 1) {
				if (right != left) {
					if (societyPrevStatus[row][left] == true)
						count++;
					if (societyPrevStatus[row][right] == true)
						count++;
				} else {
					if (societyPrevStatus[row][left] == true)
						count++;
				}
			} else if (nRows > 1 && nCols == 1) {
				if (top != bottom) {
					if (societyPrevStatus[top][col] == true)
						count++;
					if (societyPrevStatus[bottom][col] == true)
						count++;
				} else {
					if (societyPrevStatus[top][col] == true)
						count++;
				}
			}

			else if (nRows == 1 && nCols == 1) {
				return 0;
			}

			else if (left != right) {
				if (top != bottom) {
					if (societyPrevStatus[top][col] == true)
						count++;
					if (societyPrevStatus[top][right] == true)
						count++;
					if (societyPrevStatus[row][right] == true)
						count++;
					if (societyPrevStatus[bottom][right] == true)
						count++;
					if (societyPrevStatus[bottom][col] == true)
						count++;
					if (societyPrevStatus[bottom][left] == true)
						count++;
					if (societyPrevStatus[row][left] == true)
						count++;
					if (societyPrevStatus[top][left] == true)
						count++;
				} else {
					if (societyPrevStatus[top][left] == true)
						count++;
					if (societyPrevStatus[top][col] == true)
						count++;
					if (societyPrevStatus[top][right] == true)
						count++;
					if (societyPrevStatus[row][left] == true)
						count++;
					if (societyPrevStatus[row][right] == true)
						count++;
				}
			}

			else if (left == right) {
				if (top != bottom) {
					if (societyPrevStatus[top][col] == true)
						count++;
					if (societyPrevStatus[top][right] == true)
						count++;
					if (societyPrevStatus[row][right] == true)
						count++;
					if (societyPrevStatus[bottom][right] == true)
						count++;
					if (societyPrevStatus[bottom][col] == true)
						count++;
				} else {
					if (societyPrevStatus[top][left] == true)
						count++;
					if (societyPrevStatus[top][col] == true)
						count++;
					if (societyPrevStatus[row][left] == true)
						count++;
				}
			}
		}
		return count;
	}

	// Updates the society to represent the next society.
	public void update() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				societyPrevStatus[i][j] = society[i][j];
			}
		}
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (societyPrevStatus[i][j] == false) {
					if (this.neighborCountPrev(i, j) == 3)
						society[i][j] = true;
				} else {
					if (this.neighborCountPrev(i, j) == 2
							|| this.neighborCountPrev(i, j) == 3)
						society[i][j] = true;
					else if (this.neighborCountPrev(i, j) < 2)
						society[i][j] = false;
					else
						society[i][j] = false;
				}
			}
		}
	}
}
