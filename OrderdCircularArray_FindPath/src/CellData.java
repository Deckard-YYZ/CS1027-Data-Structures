
/**
 * This class represents a cell with specific data,
 * which contains Id and Value. It is the base to implement
 * OrderedCircularArray and shortestPath
 * @author yunzhuo
 * 
 *@param <T>
 */
public class CellData<T> {
	private T id;
	private int value;
	public CellData(T theld,int theValue) {
		id = theld;
		value = theValue;
	}
	/**
	 * the method gets the data of value in one cell
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * the method gets the data of id in one cell
	 * @return id
	 */
	public T getId() {
		return id;
	}
	/**
	 * the method sets the data of value to a new number
	 */
	public void setValue(int newValue) {
		value = newValue;
	}/**
	 * the method sets the data of id to a new T item newId
	 */
	public void setId(T newId) {
		id = newId;
	}
	

}
