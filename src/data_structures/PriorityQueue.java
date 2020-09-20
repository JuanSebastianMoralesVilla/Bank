package data_structures;

public class PriorityQueue<T extends Comparable<T>> implements IQueue<T>{
	
	private Elements<T> first;
	
	public PriorityQueue() {
		first = null;
	}
	@Override
	public void enqueue(T element) {
		Elements<T> newElement = new Elements<T>(element);
		if(first.getElement()==null) {
			first = newElement;
		}else if(first.getElement().compareTo(element)<0){
			newElement.setNext(first);
			first = newElement;
		}else {	
			Elements<T> current = first;
			if(current.getNext()==null) {
				while(element.compareTo(current.getNext().getElement())>0) {
					current = current.getNext();
					if(current.getNext()==null) {
						break;
					}
				}
			}
			newElement.setNext(current.getNext());
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
	public T consultar() {
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
