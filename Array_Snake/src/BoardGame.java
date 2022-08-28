/**
 * Class BoardGame represents the board game where the snake moves around eating apples.
 * @author Yunzhuo Zhang
 */

import java.io.*;
public class BoardGame {
	/* Attribute declarations */
	private int board_length, board_width,number1,number2;  //represents length of board, width of board, the first number and second number of the boardfile
	private Snake theSnake; 								//represents the snake move on the board game
	private String[][] matrix; 								//represents the board
	/** 
	 * the BoardGame method read the file, store the important information in first couple lines
	 * fill the rest matrix with "empty"
	 * then fill the the place with corresponding
	 */
	public BoardGame(String boardFile) {
		int snake_row,snake_column;							//represents the row and column of the snake body
		MyFileReader in = new MyFileReader(boardFile);
		int num = in.readInt();
		num = in.readInt();
		board_length = in.readInt();
		board_width = in.readInt();
		snake_row = in.readInt();
		snake_column = in.readInt();	
		matrix = new String[board_width][board_length];
		theSnake = new Snake(snake_row,snake_column);
		for (int a=0; a < board_width;a++) {            	//fill with "empty"
			for (int b=0; b< board_length;b++) {
				matrix [a][b] = "empty";
			}
		}
		while (!in.endOfFile()) {							//fill the corresponding places with objects
			number1 = in.readInt();
			number2 = in.readInt();
			matrix[number1][number2] = in.readString().toLowerCase();
		}	
		
	}
	/** 
	 * getObject method returns String in specific place in the board
	 */
	public String getObject(int row,int col) {
		return matrix[row][col];
		
	}
	/** 
	 * setObject method set the specific place in the board to a String
	 */
	public void setObject(int row,int col,String newObject) {
		matrix[row][col] = newObject;
	}
	/** 
	 * getSnake method returns theSnake
	 */
	public Snake getSnake() {
		return theSnake;
	}
	/** 
	 * a replicate code
	 */
	public void getSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	/** 
	 * setSnake method sets theSnake to a newSnake  
	 */
	public void setSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	/** 
	 * getLength returns the length of the board 
	 */
	public int getLength() {
		return board_length;
	}
	/** 
	 * getWidth returns the width of the board
	 */
	public int getWidth() {
		return board_width;
	}
	/** 
	 * getType method return the String store in the specific place
	 */
	public String getType(int row,int col) {
		return matrix[row][col];
	}
}
