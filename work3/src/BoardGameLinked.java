/**
 * Class BoardGame represents the board game where the snake moves around eating
 * apples.
 * 
 * @author Yunzhuo Zhang
 */

public class BoardGameLinked {
	/* Attribute declarations */
	int boardLength; // represents length of board, width of board, the first number and second
						// number of the boardfile
	int boardWidth;
	SnakeLinked theSnake; // represents the snake move on the board game
	DoubleList<String>[] board; // represents the board

	/**
	 * the BoardGame method read the file, store the important information in first
	 * couple lines fill the rest matrix with "empty" then fill the the place with
	 * corresponding
	 */
	public BoardGameLinked(String boardFile) {
		int snake_row, snake_column;
		MyFileReader in = new MyFileReader(boardFile);
		int num = in.readInt();
		num = in.readInt();
		boardLength = in.readInt();
		boardWidth = in.readInt();
		snake_row = in.readInt();
		snake_column = in.readInt();
		theSnake = new SnakeLinked(snake_row, snake_column);
		board = new DoubleList[boardWidth];
		for (int i = 0; i < boardWidth; i++) {
			DoubleList<String> rowList = new DoubleList();
			for (int j = 0; j < boardLength; j++) {
				rowList.addData(j, "empty");
			}
			board[i] = rowList;
		}
		while (!in.endOfFile()) { // fill the corresponding places with objects
			int number1 = in.readInt();
			int number2 = in.readInt();
			String str = in.readString().toLowerCase();
			board[number1].setData(number2, str);

		}
	}

	/**
	 * getObject method returns String in specific place in the board
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		return board[row].getData(col);
	}

	/**
	 * setObject method set the specific place in the board to a String
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		board[row].setData(col, newObject);
	}

	/**
	 * getSnake method returns theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}

	/**
	 * setSnake method sets theSnake to a newSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}

	/**
	 * getLength returns the length of the board
	 */
	public int getLength() {
		return boardLength;
	}

	/**
	 * getWidth returns the width of the board
	 */
	public int getWidth() {
		return boardWidth;
	}
}
