package data_structures;

public class Queue<T> implements IQueue<T>{
	private Elements<T> first;
	
	public Queue() {
		first =null;
	}
	@Override
	public void enqueue(T element) {
		Elements<T> newElement = new Elements<T>(element);
		
		if(first ==null) {
			first = newElement;
		}else {
			Elements<T> current = first;
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			current.setNext(newElement);
		}
	}

	@Override
	public T dequeue() {
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
	public T consult() {
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
	public Elements<T> getFirst() {
		return first;
	}
	
	

}

