package model;

import java.time.LocalDate;

public class Client implements Comparable<Client>{
	private String name;
	private String lastName;
	private String id;
	private int priorityLevel;
	private LocalDate dateJoinedBank;
	
	private Tarjet tarjet;
	private String reason;
	
	public final static String NAME = "name";
	public final static String ID = "id";
	public final static String DATE = "date";
	public final static String AMOUNT = "amount";
	
	public Client(String name,String lastName,String id,int priorityLevel,String type,String idAccount,double amount,LocalDate dateJoinedBank) {
		reason = "";
		this.name = name;
		this.priorityLevel = priorityLevel;
		this.lastName = lastName;
		this.id = id;
		this.dateJoinedBank = dateJoinedBank;
		tarjet = new Tarjet(type,idAccount,amount,dateJoinedBank);
	}
	
	public double getAmount() {
		return tarjet.getAmount();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public LocalDate getDateJoinedBank() {
		return dateJoinedBank;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(id);
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Client o) {
		return priorityLevel-o.getPriorityLevel();
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public Tarjet getTarjet() {
		return tarjet;
	}

	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
}
