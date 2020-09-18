package data_structures;

public interface IQueue<T> {
	public void enqueue(T element);
	public T dequeue();
	public T consultar();
	public boolean isEmpty();
}
