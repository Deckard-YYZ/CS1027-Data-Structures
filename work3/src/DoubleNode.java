/**
 * Class represents the node and its next, prev and data.
 * 
 * @author yunzhuo zhang
 *
 */
public class DoubleNode<T> {
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;

	/**
	 * class creates a empty node.
	 */

	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * class creates an empty node and stores the newData into that node.
	 * 
	 * @param newData
	 */

	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}

	/**
	 * class gets the information of the next of the current node
	 * 
	 * @return next node of the current node.
	 */

	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * class gets the information of the previous node
	 * 
	 * @return previous node of the current node.
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}

	/**
	 * class gets the data which stored in this node.
	 * 
	 * @return data in the node
	 */

	public T getData() {
		return data;
	}

	/**
	 * class sets the current node pointer to the next node.
	 * 
	 * @param nextNode
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}

	/**
	 * class sets the current node pointer to the previous node.
	 * 
	 * @param prevNode
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}

	/**
	 * class sets the data into the node.
	 * 
	 * @param newData
	 */

	public void setData(T newData) {
		data = newData;
	}
}
