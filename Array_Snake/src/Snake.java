

public class Snake {
	/* Attribute declarations */
	private int snakeLength;
	private Position[] snakeBody;
	/** 
	 * initialize the snake length and snakeBody 
	 */
	public Snake(int row, int col) {
		snakeLength = 1;
		snakeBody = new Position[5];
		snakeBody[0] = new Position(row,col);
	}
	/** 
	 * getLength method returns the Length of snake
	 */
	public int getLength() {
		return snakeLength;
	}
	/** 
	 * getPosition method returns the snake body in specific index
	 */
	public Position getPosition(int index) {
		if (index<0 || index >= snakeLength) { 		//it will return nothing if the index is out of range or is minus
			return null;
		}else {
				return snakeBody[index];
			}
		}
	/** 
	 * shrink method reduce the snake length by 1 
	 */
	public void shrink(){
		snakeLength = snakeLength -1;
	}
	/** 
	 * snakePosition method returns true if the place pos in the all coordinates of the snakeBody
	 * otherwise return false  
	 */
	public boolean snakePosition(Position pos) {
		for (int i=0;i<snakeLength;i++) {
			 if (snakeBody[i].equals(pos)) {
				 return true;
			 }
		}
	 return false;
	}
	/** 
	 * newHeadPosition method returns the head position when the snake is moved 
	 */
	Position newHeadPosition(String direction) {
		/**if (direction.equals("right")) {
			snakeBody[0].setCol(snakeBody[0].getCol()+1);
		}  else if (direction.equals("left"))  {
			snakeBody[0].setCol(snakeBody[0].getCol()-1);
		}  else if (direction.equals("up")) {
			snakeBody[0].setRow(snakeBody[0].getRow()-1);
		}  else if (direction.equals("down")) {
			snakeBody[0].setRow(snakeBody[0].getRow()+1);
		}
		return snakeBody[0];	
		}
		version 0.0 code that I dont know where is wrong
		*/
		if (direction.equals("right")) return (new Position(snakeBody[0].getRow(), snakeBody[0].getCol()+1));
			else if (direction.equals("left"))  return (new Position(snakeBody[0].getRow(),snakeBody[0].getCol()-1));
			else if (direction.equals("up")) 	return (new Position(snakeBody[0].getRow()-1,snakeBody[0].getCol()));
			else if (direction.equals("down")) return (new Position(snakeBody[0].getRow()+1,snakeBody[0].getCol()));
		return null;
		}
	/** 
	 * moveSnake method set the new coordinates of the whole snakeBody
	 */
	public void moveSnake(String direction) {
			for (int i = snakeLength-1;i > 0; i--) {			//because the special way of moving the further snakeBody
				snakeBody[i] = snakeBody[i-1];					//will move to former snake body's coordinate
			}
			snakeBody[0] = newHeadPosition(direction);				
	}
	/** 
	 * grow method set the new coordinates of the whole snakeBody when snake becomes longer
	 */
	public void grow(String direction) {
		if (snakeBody.length == snakeLength) {				  //use increaseArraySize method to avoid exception
			increaseArraySize();
		}
		snakeLength = snakeLength + 1;
		snakeBody[snakeLength-1] = snakeBody[snakeLength-2];
		for (int i = snakeLength-2;i > 0; i--) {
			snakeBody[i] = snakeBody[i-1];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	/** 
	 * increaseArraySize method sets the Array snakeBody to a Array that can contain 
	 * two times objects as the original one
	 */
	public void increaseArraySize() {
		Position[] increasedArray;
		increasedArray = new Position[snakeBody.length*2];
		for (int i = 0;i < snakeBody.length;i++) {
			increasedArray[i] = snakeBody[i];
		}
		snakeBody = increasedArray;
	}
	}
	

