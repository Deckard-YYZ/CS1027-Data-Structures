/**
 * The class creates a circularArrasy in a specific order, 
 * and does implementation on the doubleList.
 * @author yunzhuo
 *
 * @param <T>
 */
public class OrderedCircularArray<T> implements SortedListADT<T> {
	private CellData[] list;
	private int front;
	private int rear;
	private int count;

	public OrderedCircularArray() {
		list = (CellData<T>[])(new CellData[5]);
		rear = 0;
		front = 1;
		count = 0;
	}
	/**
	 * the method inserts a cell into the circular array.
	 * 
	 * @param id
	 * @param alue
	 */
	
	public void insert(T id, int value) {
		CellData<T> insertion = new CellData<T>(id, value);
		//this method will determine whether the list is full
		//if so , it will create a longer list to contain extra cells
		if (count == list.length) {
			CellData[] larger = (CellData<T>[])(new CellData[list.length*2]);
			int copy = 0;
			for (int i = front; i < list.length; i++) {
				larger[i] = list[i];
			}
			for (int j = 0; j < count - list.length + front; j++) {
				larger[list.length + j] = list[j];
			}
			rear = list.length + count - list.length + front - 1;
			list = larger;
		}
		//determine whether the list is empty
		//if so, it will simply insert the cell at front
		//and set rear equals to front
		if (isEmpty()) {
			list[front] = insertion;
			count++;
			rear = front;
		//otherwise, it will consider what is the right position to insert
		} else {
			boolean loop = true;
			int indexToI = front;
			int times = 0;		//this variable represent the times to get the right index
			//find the right index
			while (loop && list[indexToI] != null) {
				if (list[indexToI].getValue() > value) {
					int index = indexToI;
					break;
				}
				indexToI = (indexToI + 1) % list.length;
				times++;
			}
			//if no data at that index, that means the new value 
			//is biggest, and we can simply insert there
			if (list[indexToI] == null) {
				list[indexToI] = insertion;
				rear = (rear + 1) % list.length;
				count++;
			//if it is not the largest value, we should move the 
			//data after the index for 1 cell, then insert the new cell
			} else {
				int index1 = indexToI;
				int i = front;
				CellData[] sort = new CellData[list.length];
				while (i != index1) {// to accomplish that, I create a new list
					sort[i] = list[i];//to hold the cells after that index
					i = (i + 1) % list.length;
				}
				for (int j = count - times; j > 0; j--) {//then I append the cells before index to the new list
					sort[(index1 + 1) % list.length] = list[index1];
					index1 = (index1 + 1) % list.length;
				}
				list = sort;
				list[indexToI] = insertion;
				rear = (rear + 1) % list.length;
				count++;
			}
		}

	}
	/**
	 * the method removes a cell in the circular array.
	 * 
	 * @param id
	 * @throws InvalidDataItemException
	 */
	public void remove(T id) throws InvalidDataItemException {
		boolean gotId = false;
		int index = 0;
		//when the list doesn't have values at left of front
		//find values at right side of front
		if (count <= list.length - front) {
			for (int i = front; i <= count; i++) {
				if (list[i].getId().equals(id)) {
					gotId = true;
					index = i;
					break;
				}
			}
		}
		//when the list has values at left of front
		//find values at left and right side of front
		if (count > list.length - front) {
			for (int i = front; i <= list.length - front + 1; i++) {
				if (list[i].getId().equals(id)) {
					gotId = true;
					index = i;
					break;
				}
			}
			for (int i = 0; i < count - list.length + front; i++) {
				if (list[i].getId().equals(id)) {
					gotId = true;
					index = i;
					break;
				}
			}
		}
		//if there is only one cell, we just delete it
		if (count == 1 && gotId == true) {
			list[front] = null;
			rear = front;
			count--;
		//if cells only at right side
		} else if (count > 1 && count <= list.length - front && gotId == true) {
			for (int j = 0; j < count - index; j++) {
				list[j + index] = list[j + index + 1];
			}
			list[count] = null;
			count--;
			rear--;
		//if cells at both left and right side
		} else if (count > list.length - front && gotId == true) {
			if (index >= front) {
				for (int j = 0; j < list.length - index - 1; j++) {
					list[j + index] = list[j + index + 1];
				}
			}
			list[list.length - 1] = list[0];
			for (int i = 0; i < count - list.length + front - 1; i++) {
				list[i] = list[i + 1];
			}
			list[count - list.length + front - 1] = null;
			count--;
			if (count == list.length - front)
				rear = list.length - 1;
			else
				rear--;

		}
		if (!gotId)
			throw new InvalidDataItemException("the data you want to remove does not exist.");
	}
	/**
	 * Class will return cell 
	 * at front and remove it
	 * 
	 * @return node
	 * @throws EmptyListException
	 */
	public T getSmallest() throws EmptyListException {
		if (count == 0) {
			throw new EmptyListException("the list is empty");
		}
		T toReturn = (T) list[front].getId();
		list[front] = null;
		front = (front+1)%list.length;
		count--;
		return toReturn;

	}
	/**
	 * the method change the value stores in a cell in the circular array.
	 * 
	 * @param id
	 * @param newValue
	 * @throws InvalidDataItemException
	 */
	public void changeValue(T id, int newValue) throws InvalidDataItemException {
		remove(id);
		insert(id, newValue);
	}
	/**
	 * the method returns the value stores in a cell in the circular array.
	 * 
	 * @param id
	 * @throws InvalidDataItemException
	 */
	public int getValue(T id) throws InvalidDataItemException {
		int VToGet = 0;
		boolean gotTheid = false;
		if (count == list.length) {
			if (list[0].getId() == id) {
				VToGet = list[0].getValue();
				gotTheid = true;
			} else {
				for (int i = 1; i < count; i++) {
					if (list[i].getId().equals(id)) {
						VToGet = list[i].getValue();
						gotTheid = true;
					}
				}
			}
		} else {
			for (int i = 1; i <= count; i++) {
				if (list[i].getId().equals(id)) {
					VToGet = list[i].getValue();
					gotTheid = true;
				}
			}
		}
		if (gotTheid)
			return VToGet;
		else
			throw new InvalidDataItemException("Invalid dataitem.");

	}
	/**
	 * the method determines whether the list contains
	 * no items
	 * @return true or false
	 */
	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}
	/**
	 * the method returns the number 
	 * of items in the array
	 * @return count
	 */
	public int size() {
		return count;
	}
	/**
	 * the method returns front
	 * no items
	 * @return front
	 */
	public int getFront() {
		return front;
	}
	/**
	 * the method returns rear
	 * @return rear
	 */
	public int getRear() {
		return rear;
	}
}
