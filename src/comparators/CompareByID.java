package comparators;

import java.util.Comparator;

import model.Client;

public class CompareByID implements Comparator<Client>{
	private boolean ascendancy;
	public CompareByID(boolean isAcendancy) {
		ascendancy = isAcendancy;
	}

	@Override
	public int compare(Client o1, Client o2) {
		String id1 = o1.getId();
		String id2 = o2.getId();
		int result = id1.compareTo(id2);
		result = ascendancy?result:-1*result;
		return result;
	}	
		
	
}
