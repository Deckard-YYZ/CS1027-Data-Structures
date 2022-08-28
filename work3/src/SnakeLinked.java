
public class SnakeLinked {
	/* Attribute declarations */
	int snakeLength;
	DoubleList<Position> snakeBody;

	/**
	 * initialize the snake length and snakeBody
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList();
		snakeBody.addData(0, new Position(row, col));
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
		if (index < 0 || index >= snakeLength) { // it will return nothing if the index is out of range or is minus
			return null;
		} else {
			return snakeBody.getData(index);
		}
	}

	/**
	 * snakePosition method returns true if the place pos in the all coordinates of
	 * the snakeBody otherwise return false
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i++) {
			if (snakeBody.getData(i).equals(pos)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * newHeadPosition method returns the head position when the snake is moved
	 */
	public Position newHeadPosition(String direction) {
		if (direction.equals("right"))
			return (new Position(snakeBody.getNode(0).getData().getRow(), snakeBody.getNode(0).getData().getCol() + 1));
		else if (direction.equals("left"))
			return (new Position(snakeBody.getNode(0).getData().getRow(), snakeBody.getNode(0).getData().getCol() - 1));
		else if (direction.equals("up"))
			return (new Position(snakeBody.getNode(0).getData().getRow() - 1, snakeBody.getNode(0).getData().getCol()));
		else if (direction.equals("down"))
			return (new Position(snakeBody.getNode(0).getData().getRow() + 1, snakeBody.getNode(0).getData().getCol()));
		return null;
	}

	/**
	 * moveSnake method set the new coordinates of the whole snakeBody
	 */
	public void moveSnakeLinked(String direction) {

		for (int i = snakeLength - 1; i > 0; i--) { // because the special way of moving the further snakeBody
			snakeBody.setData(i, snakeBody.getData(i - 1)); // will move to former snake body's coordinate
		}
		snakeBody.setData(0, newHeadPosition(direction));
	}

	/**
	 * shrink method reduce the snake length by 1
	 */
	public void shrink() {
		snakeLength = snakeLength - 1;
	}

	/**
	 * grow method set the new coordinates of the whole snakeBody when snake becomes
	 * longer
	 */
	void grow(String direction) {
		snakeLength++; // increment snake length.
		snakeBody.addData(0, newHeadPosition(direction)); // insert data at the front without change any node.
	}
}
