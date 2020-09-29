package model;

public class Shift implements Comparable<Shift>{
	
	private String idShifth;
	private Client client;

	public Shift(String idShift,Client cleint) {
		this.idShifth=idShift;
		this.client = cleint;
	}
	public String getIdShifth() {
		return idShifth;
	}

	public Client getClient() {
		return client;
	}
	@Override
	public int compareTo(Shift o) {
		// TODO Auto-generated method stub
		return client.compareTo(o.client);
	}
	
	

}
