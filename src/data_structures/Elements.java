package data_structures;


public class Elements<T> {
	private Elements<T> next;
	private T element;
	
	public Elements(T element) {
		this.element = element;
		next =null;
	}

	public Elements<T> getNext() {
		return next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public void setNext(Elements<T> next) {
		this.next = next;
	}
}
