package model;

import java.util.Date;

public class Client {
	private String name;
	private String id;
	private Date dateJoinedBank;
	
	// añadir un tipo de cliente verdadero si es de tipo prioritario, y falso si es cliente normal.
	private boolean typeClient;
	
	public Client(String name,String id,Date dateJoinedBank,Boolean typeBoolean) {
		this.name = name;
		this.id = id;
		this.dateJoinedBank = dateJoinedBank;
		this.typeClient=typeClient;
		
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
