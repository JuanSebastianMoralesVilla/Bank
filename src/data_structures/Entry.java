package data_structures;

public class Entry<T1, T2> {
	private T1 key;
	private T2 value;
	private boolean delated;
	public Entry(T1 key, T2 value) {
		setDelated(false);
		this.key = key;
		this.value = value;
	}

	public T1 getKey() {
		return key;
	}

	public void setKey(T1 key) {
		this.key = key;
	}

	public T2 getValue() {
		return value;
	}

	public void setValue(T2 value) {
		this.value = value;
	}

	public boolean isDelated() {
		return delated;
	}

	public void setDelated(boolean delated) {
		this.delated = delated;
	}
}
