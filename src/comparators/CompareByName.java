package comparators;

import java.util.Comparator;

import model.Client;

public class CompareByName implements Comparator<Client>{
	private boolean ascendancy;
	public CompareByName(boolean isAcendancy) {
		ascendancy = isAcendancy;
	}
	@Override
	public int compare(Client o1, Client o2) {
		int result=0;
		String name1 = o1.getName();
		String name2 = o2.getName();
		String lastName1 = o1.getLastName();
		String lastName2 = o2.getLastName();
		if(name1.compareTo(name2)>0) {
			result = 1;
		}else if(name1.compareTo(name2)<0) {
			result =-1;
		}else {
			if(lastName1.compareTo(lastName2)>0) {
				result = 1;
			}else if(lastName1.compareTo(lastName2)<0) {
				result = -1;
			}
		}
		result = ascendancy? result: -1*result;
		return result;
	}

}
