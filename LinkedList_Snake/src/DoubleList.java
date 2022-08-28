/**
 * The class creates a doubleList and does implementation on the doubleList.
 * 
 * @author yunzhuo zhang
 *
 * @param <T>
 */
public class DoubleList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;

	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}

	/**
	 * the method inserts a node into the link list.
	 * 
	 * @param index
	 * @param newdata
	 * @throws InvalidPositionException
	 */

	public void addData(int index, T newData) throws InvalidPositionException {
		if (index > numDataItems || index < 0)
			throw new InvalidPositionException("Invalid index");
		DoubleNode<T> newNode = new DoubleNode(newData);
		DoubleNode<T> current;
		if (index == 0) { // when index is 0, insert the node into the head
			if (head == null) {
				head = newNode;
				rear = newNode;
			} else if (head != null && head.getNext() == null) {
				head = rear;
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else if (head != null && head.getNext() != null) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
		} else if (index > 0 && index < numDataItems) { //// insert the node in the middle
			current = head;
			for (int i = 0; i <= index; i++) {
				current = current.getNext();
			}
			newNode.setPrev(current.getPrev());
			newNode.setNext(current);
			current.setPrev(newNode);
		} else if (index == numDataItems) { // when index is numDataItems, insert the node into rear
			rear.setNext(newNode);
			newNode.setPrev(rear);
			rear = newNode;
		}
		numDataItems++;
	}

	/**
	 * Class will return node which had given index
	 * 
	 * @param index
	 * @return return node
	 * @throws InvalidPositionException
	 */

	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		DoubleNode<T> current;
		current = head;
		if (index == 0)
			return current;
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index");
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * This method will remove the node
	 * 
	 * @param index
	 * @throws InvalidPositionException
	 */

	public void removeData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index");
		DoubleNode<T> current = new DoubleNode();
		if (index == 0 && head.getNext() == null) {
			head = null;
			rear = null;
		} else if (index == 0 && head.getNext() != null) {
			current = head;
			current = current.getNext();
			current.setPrev(null);
			head = current;
		} else if (index > 0 && index != numDataItems - 1) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			(current.getPrev()).setNext(current.getNext());
			(current.getNext()).setPrev(current.getPrev());
		} else if (index == numDataItems - 1) {
			rear.getPrev().setNext(null);
			rear = rear.getPrev();
		}
		numDataItems--;
	}

	/**
	 * Method will get the node in the list
	 * 
	 * @param index
	 * @return node
	 * @throws InvalidPositionException
	 */

	public T getData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index");
		DoubleNode<T> current = new DoubleNode();
		if (index == 0)
			return head.getData();
		else if (index > 0) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			return current.getData();

		}
		return null;
	}

	/**
	 * Method will replace the data in the node to new data.
	 * 
	 * @param index
	 * @param newData
	 * @throws InvalidPositionException
	 */

	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index");
		DoubleNode<T> current = new DoubleNode();
		if (index == 0)
			head.setData(newData);
		else if (index > 0) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			current.setData(newData);
		}
	}
}
