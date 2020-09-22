package data_structures;

public interface IHashTable	<T1, T2> {
	public boolean isEmpty();
	public boolean put(T1 key, T2 value);
	public boolean remove(T1 key);
	public int size();
}
