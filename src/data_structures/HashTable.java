package data_structures;


public class HashTable<T1, T2> implements IHashTable<T1,T2>{
	private Entry<?, ?>[] table;
	int size;
	
	public HashTable() {
		size = 0;
		table = new Entry<?,?>[100];
	}
	
	public Entry<?, ?>[] getTable() {
		return table;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean put(T1 key, T2 value) {
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
		}else {
			increaseSize();
			put(key,value);
		}
		return false;
		
	}
	private void increaseSize() {
		Entry<?, ?>newTable[] = new Entry<?,?>[table.length+100];
		for (int i = 0; i < table.length; i++) {
			newTable[i] = table[i];
		}
		table = newTable;
	}

	@Override
	public boolean remove(T1 key) {
		int index = hashFuntion(key);
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

}
