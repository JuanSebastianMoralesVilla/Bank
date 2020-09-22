package data_structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSorts {
	
	
	public  static <T> void selectionSort(List<T> array, Comparator<T> comparator){
		
		for (int i = 0; i < array.size(); i++) {
			int lower = i;
			for (int j = i+1; j < array.size(); j++) {
				if(comparator.compare(array.get(j),array.get(lower))<0) {
					lower = j;
				}
			}
			if(lower!=i) {
				exchange(array,lower,i);
			}
		}
	}
	
	public  static <T> void heapSort(List<T> array, Comparator<T> comparator){
		
		int n = array.size()-1;
		while(n>0) {
			for (int i = (n-1)/2; i >=0; i--) {
				heapifying(array,i,n,comparator);
			}
			exchange(array,0,n);
			n--;
		}
	}
	private static <T> void heapifying(List<T> array, int i,int size, Comparator<T> comparator) {
		int left = 2*i +1;
		int right = 2*i +2;
		int max=i;
		if(left<=size) {
			if(comparator.compare(array.get(left), array.get(i))>0) {
				max = left;
			}
		}
		if(right<=size) {
			if(comparator.compare(array.get(right), array.get(max))>0) {
				max = right;
			}
		}
		if(max!=i) {
			exchange(array,i,max);
			heapifying(array,max,size,comparator);
		}
	}
	
	public  static <T> void mergueSort(List<T> array, Comparator<T> comparator){
		mergueSortR(array,0,array.size()-1,comparator);
	}
	public static <T> void mergueSortR(List<T> array, int start,int end,Comparator<T> comparator) {
		if(end-start+1>=2) {
			mergueSortR(array,start,(start+end)/2,comparator);
			mergueSortR(array,((start+end)/2)+1,end,comparator);
		}
		toCombine(array,start,(start+end)/2,end,comparator);
	}
	private static <T> void toCombine(List<T>array, int start, int middle, int end,Comparator<T> comparator) {
		int i = start;
		int j = middle +1;
		List<T> listAux = new ArrayList<T>();
		if((end-start+1)>1) {
			while(i<=middle && j<=end) {
				
				if(comparator.compare(array.get(i), array.get(j))<0) {
					listAux.add(array.get(i));
					i++;
				}else {
					listAux.add(array.get(j));
					j++;
				}
			}
			for (int k = i; k <= middle; k++) {
				listAux.add(array.get(k));
			}
			for (int k = j; k <= end; k++) {
				listAux.add(array.get(k));
			}
		}
		int position = start;
		for (int k = 0; k < listAux.size(); k++) {
		
			array.set(position,listAux.get(k));
			position++;
		}
		
	}
	
	public  static <T> void quickSort(List<T> array, Comparator<T> comparator){
		quickSortR(array,0,array.size()-1,comparator);
	}
	
	private static <T> void quickSortR(List<T> array,int start, int end, Comparator<T> comparator) {
		int firstStart = start;
		int firstEnd = end;
		if(end-start+1<=2) {
			if(end<array.size()&& start<array.size() && end >start) {
				if(comparator.compare(array.get(start), array.get(end))>0) {
					exchange(array,start,end);
				}
			}
		}else {
			int pivot= (start+end)/2;
			boolean order = false;
			boolean alreadyOrdained = true;
			while(!order) {
				boolean lower = false;
				boolean upper = false;
				if(comparator.compare(array.get(start), array.get(pivot))<0) {
					start++;
				}else if(start<=pivot){
					lower = true;
				}
				if(comparator.compare(array.get(end), array.get(pivot))>0) {
					end--;
				}else if(end>=pivot){
					upper = true;
				}
				if(lower&&upper) {
					if(pivot == end) {
						pivot = start;
					}else if(pivot == start) {
						pivot = end;
					}
					alreadyOrdained = false;
					
					exchange(array,end,start);
					if(start<pivot) {
						start++;
					}
					if(end>pivot) {
						end--;
					}
					
				}
				order = end == start && end == pivot;
			}
			if(!alreadyOrdained) {
				quickSortR(array,firstStart,pivot-1,comparator);
				quickSortR(array,pivot+1,firstEnd,comparator);
			}
		}
		
	}
	private static <T> void exchange(List<T> array, int i, int j) {
		T aux = array.get(i);
		array.set(i, array.get(j));
		array.set(j, aux);
	}
}
