package model;

import java.time.LocalDate;

public class Tarjet {
	private String type;
	private String idAccount;
	private double amount;
	private LocalDate dateUpdateCredit;
	public static final String AHORROS = "Ahorros";
	public static final String CREDIT = "Credit";
	public static final String BOTH = "Both";
	
	public Tarjet(String type, String idAccount,double amount,LocalDate dateUpdateCredit) {
		this.type = type;
		this.amount = amount;
		this.idAccount = idAccount;
		this.setDateUpdateCredit(dateUpdateCredit);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getAHORROS() {
		return AHORROS;
	}

	public String getCREDIT() {
		return CREDIT;
	}

	public LocalDate getDateUpdateCredit() {
		return dateUpdateCredit;
	}

	public void setDateUpdateCredit(LocalDate dateUpdateCredit) {
		this.dateUpdateCredit = dateUpdateCredit;
	}
	
	
}
