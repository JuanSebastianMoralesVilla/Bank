package data_structures;

public class Stack<T> implements IStack<T>{
	private Elements<T> first;
	public Stack() {
		first = null;
	}
	@Override
	public void push(T element) {
		Elements<T> newElement = new Elements<>(element);
		if(first==null) {
			first = newElement;
		}else {
			newElement.setNext(first);
			first = newElement;
		}
	}
	@Override
	public T pop() {
		T element = null;
		if(first!=null) {
			element = first.getElement();
			if(first.getNext()!=null) {
				first = first.getNext();
			}else {
				first=null;
			}
		}
		
		
		return element;
	}
	@Override
	public T peek() {
		if(first!=null) {
			T element = first.getElement();
			return element;
		}
		return null;
	}
	@Override
	public boolean isEmpty() {
		return first==null;
	}
	
	
}
