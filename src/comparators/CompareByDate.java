package comparators;

import java.time.LocalDate;
import java.util.Comparator;

import model.Client;

public class CompareByDate implements Comparator<Client>{
	private boolean ascendancy;
	public CompareByDate(boolean isAscendancy) {
		ascendancy = isAscendancy;
	}

	@Override
	public int compare(Client o1, Client o2) {
		LocalDate time1 = o1.getDateJoinedBank();
		LocalDate time2 = o2.getDateJoinedBank();
		int result = time1.compareTo(time2);
		result = ascendancy?result:-1*result;
		return result;
	}

}
