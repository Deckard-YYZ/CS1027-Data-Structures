/**
 * class implements a stack which holds the Mapcells 
 * that the program  walks
 * @author yunzhuo
 *
 * @param <T>
 */
public class ArrayStack<T> implements ArrayStackADT<T> {
private T[] stack; 				// array to be the stack 
private int top;				//index of the object at the very top
private int initialCapacity;	//initial capacity of stack
private int sizeIncrease;		//size to extend the stack
private int sizeDecrease;	//size to decrease the stack
/**
 * constructor to initialize the variables
 * @param initialCap
 * @param sizeInc
 * @param sizeDec
 */
public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
	top = -1;
	stack = (T[]) (new Object[initialCap]);
	initialCapacity = initialCap;
	sizeIncrease = sizeInc;
	sizeDecrease = sizeDec;
	
}
/**
 * push method to add a new object into the stack
 */
public void push(T dataItem) {
	if (top+1 == stack.length) {
		T[] increasedStack = (T[]) (new Object[stack.length + sizeIncrease]);
		for (int i = 0;i < stack.length;i++) {
			increasedStack[i] = stack[i];
		}
		stack = increasedStack;
	}
	top++;
	stack[top] = dataItem;

}
/**
 * pop method to remove the top item of the stack
 * @return the removed object
 */
public T pop() throws EmptyStackException {
	if (top == -1) {
		throw new EmptyStackException("Empty stack");
		}
	T topItem = stack[top];
	stack[top] = null;
	top--;
	if (top +1 < stack.length/4 && stack.length > initialCapacity) {
		T[] decreasedStack = (T[]) (new Object[stack.length - sizeDecrease]);
		for (int i = 0;i < decreasedStack.length;i++) {
			decreasedStack[i] = stack[i];
		}
		stack = decreasedStack;
	}	
	 return topItem;
}
/**
 * peek method
 *  @return the top object
 */
public T peek() throws EmptyStackException {
	if (top == -1) {
		throw new EmptyStackException("Empty stack");
		}
	return stack[top];
}
/**
 * isEmpty method check if the stack is empty
 * @return true if it is ,false otherwise
 */
public boolean isEmpty() {
	if (top == -1) return true;
	return false;
}
/**
 * size method
 *  @return returns the size of the stack
 * 
 */
public int size() {
	return top+1;
}
/**
 * length do almost the same thing with size
 * @return
 */
public int length() {
	return stack.length;
}
/**
 *toString method organize the information in a stack
 * @return a string
 */
public String toString() {
	String aString = "Stack: ";
	int last = stack.length-1;
	for (int i = 0;i < stack.length;i++) {
		if (i == stack.length-1) break;
		aString = aString + stack[i] + ", ";
	}
	aString = aString + stack[last];
	return aString;
}

}
