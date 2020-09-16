package model;

import java.util.Date;

public class Client {
	private String name;
	private String id;
	private Date dateJoinedBank;
	
	public Client(String name,String id,Date dateJoinedBank) {
		this.name = name;
		this.id = id;
		this.dateJoinedBank = dateJoinedBank;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Date getDateJoinedBank() {
		return dateJoinedBank;
	}
	
	
}
