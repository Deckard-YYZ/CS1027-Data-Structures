/**
 * Class Position is the base for snake class, it determines what the methods in Snake act
 * @author Yunzhuo Zhang
 */


public class Position {
	/* Attribute declarations */
	private int row , col; // represents the row and column in the gameboard respectively
	/** 
	 * initialize the row and column 
	 */
	public Position(int r,int c) {
		row =r;
		col = c;
	}
	/** 
	 * getRow method returns the row of a position object 
	 */
	public int getRow() {
		return row;
	}
	/** 
	 * getCol method returns the column of a position object 
	 */
	public int getCol() {
		return col;
	}
	/** 
	 * setRow method set a new row to the position object 
	 */
	public void setRow(int newRow) {
		row = newRow;
	}
	/** 
	 * setCol method set a new row to the position object 
	 */
	public void setCol(int newCol) {
		col = newCol;
	}
	/** 
	 * equals method check out if the otherPosition's row and column are equaled to the original one
	 * true if the row and column of two objects are equal,false otherwise
	 */
	public boolean equals(Position otherPosition) {
		if (this.row == otherPosition.row && this.col == otherPosition.col) {;
			return true;
		}else {
			return false;
		}
				
				
	}
}
