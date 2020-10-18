package data_structures;

import java.util.ArrayList;

public class HashTable<T1, T2> implements IHashTable<T1,T2>{
	private Entry<?, ?>[] table;
	int size;
	public final static int SIZE_DATA = 500;
	public HashTable() {
		size = 0;
		table = new Entry<?,?>[SIZE_DATA];
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public boolean add(T1 key, T2 value) {
		Entry<T1, T2> entry = new Entry<>(key,value);
		int index = hashFuntion(key);
		if(index !=-1) {
			if(table[index]!=null) {
				if(table[index].isDelated()) {
					table[index] =entry;
					size++;
					return true;
				}else if(table[index].getValue().equals(value)){
					size++;
					return true;
				}
			}else {
				table[index] =entry;
				size++;
				return true;
			}
		
		
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T2 search(T1 key) {
		int index = hashFuntion(key);
		if(index!=-1) {
			if(table[index]!=null) {
				if(!table[index].isDelated()) {
					return (T2) table[index].getValue();
				}
			}
		}
		//Thrown an exception about this key don't exist
		return null;
	}
	
	@Override
	public boolean remove(T1 key) {
		int index = hashFuntion(key);
		if(index!=-1) {
			if(table[index]!=null) {
				if(!table[index].isDelated()) {
					table[index].setDelated(true);
					table[index].setKey(null);
					table[index].setValue(null);
					size--;
					return true;
				}
			}
			
		}
		//Thrown an exception about this key don't exist
		return false;
		
	}

	@Override
	public int size() {
		return size;
	}
	
	private int hashFuntion(T1 key) {
		int index = key.hashCode();
		int result = -1;
		for(int i = 0;i<table.length ;i++) {
			int aux = index%table.length;
			aux = (aux+i)%table.length;
			if(table[aux]!=null) {
				if(!table[aux].isDelated()) {
					if(table[aux].getKey().equals(key)) {
						result = aux;
						break;
					}
				}else {
					result = aux;
					break;
				}
			}else {
				result = aux;
				break;
			}
			
			
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T2> getList(){
		ArrayList<T2> array = new ArrayList<T2>();
		for (int i = 0; i < table.length; i++) {
			if(table[i]!=null) {
				if(!table[i].isDelated()) {
					array.add((T2) table[i].getValue());
				}
			}
			
		}
		return array;
	}


}
