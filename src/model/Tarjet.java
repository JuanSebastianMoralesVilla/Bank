package model;

import java.util.Date;

public class Tarjet {
	private String type;
	private double amount;
	private String idAccount;
	private Date dateUpdateCredit;
	public final String AHORROS = "Ahorros";
	public final String CREDIT = "Credit";
	
	public Tarjet(String type, double amount,String idAccount,Date dateUpdateCredit) {
		this.type = type;
		this.amount = amount;
		this.idAccount = idAccount;
		this.dateUpdateCredit = dateUpdateCredit;
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

	public Date getDateUpdateCredit() {
		return dateUpdateCredit;
	}

	public void setDateUpdateCredit(Date dateUpdateCredit) {
		this.dateUpdateCredit = dateUpdateCredit;
	}

	public String getAHORROS() {
		return AHORROS;
	}

	public String getCREDIT() {
		return CREDIT;
	}
	
	
}
