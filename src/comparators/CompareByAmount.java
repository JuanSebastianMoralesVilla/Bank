package comparators;

import java.util.Comparator;

import model.Client;

public class CompareByAmount implements Comparator<Client>{
	private boolean ascendancy;
	
	public CompareByAmount(boolean isAcendancy) {
		ascendancy = isAcendancy;
	}
	@Override
	public int compare(Client o1, Client o2) {
		int result = 0;
		double amount1 = o1.getTarjet().getAmount();
		double amount2 = o2.getTarjet().getAmount();
		if(amount1<amount2) {
			result = -1;
		}else if(amount1>amount2) {
			result = 1;
		}
		result = ascendancy?result:-1*result;
		return result;
	}

}
