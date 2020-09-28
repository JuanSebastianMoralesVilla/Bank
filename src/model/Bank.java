package model;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import comparators.*;
import data_structures.*;

public class Bank {

	private String nextShift;
	private HashTable<String,Client> clients;
	private Queue<Shift> normalQueue;
	private PriorityQueue<Shift> priorityQueue;
	private Stack<String[]> undo;
	
	public Bank() {
		nextShift = "A00";
		clients = new HashTable<String,Client>();
		normalQueue = new Queue<Shift>();
		priorityQueue = new PriorityQueue<Shift>();
	}

	public void addClient(String name,String lastName,String id,String type,String idAccount,double ammount) {
		boolean save=false;
		if(name!=null&&lastName!=null&&id!=null) {
			if(name!=""&&lastName!=""&&id!="") {
				try {
					Integer.parseInt(idAccount);
					Integer.parseInt(id);
					Client client = new Client(name,lastName,id,type,idAccount,ammount,LocalDate.now());
					save =clients.add(id, client);
				}catch (NumberFormatException e) {
					//Exist characters in the id's
				}
				
			}
		}
		if(!save) {
			//Thrown an message about this key don't exist
		}
		String[] addClient = {"addClient",id};
		undo.push(addClient);
	}
	
	public boolean assingShift(String name,String idClient) {
		Client client = searchUser(name,idClient);
		if(client!= null) {
			Shift shift = new Shift(nextShift,client);
			if(client.getPriorityLevel()==0) {
				normalQueue.enqueue(shift);
			}else {
				priorityQueue.enqueue(shift);
			}
			nextShift();
			return true;
		}
		return false;
	}
	
	private void nextShift() {
		String result = "";
		char letter = nextShift.charAt(0);
		String numberAux = (nextShift.charAt(1)+"")+(nextShift.charAt(2)+"");
		int number = Integer.parseInt(numberAux);
		number++;
		number = number%100;
		if(number==0) {
			letter++;
		}
		result += letter;
		if(number<10) {
			result = result+"0";
		}
		result = result+number;
		nextShift=result;
	}
	
	
	public double retirement(double amount,String idAccount) {
		Client client = null;
		
		try {
			
			client = clients.search(idAccount);
			if(client.getTarjet().getType().equals(Tarjet.AHORROS)||client.getTarjet().getType().equals(Tarjet.BOTH)) {
				double actualAmount = client.getTarjet().getAmount();
				if(actualAmount>=amount) {
					actualAmount -= amount;
					client.getTarjet().setAmount(actualAmount);
				}else {
					//haven't enought money
				}
			}else {
				//User haven't a save account
			}
			
			
			
		}catch(NullPointerException e) {
			
		}
		
		
		return client.getTarjet().getAmount();
	}
	

	public double consignment(double amount, String idAccount) {
		Client client = null;
		
		try {
			
			if(normalQueue.consult().getClient().getId().equals(idAccount)) {
				client = normalQueue.consult().getClient();
			}else if(priorityQueue.consult().getClient().getId().equals(idAccount)) {
				client = priorityQueue.consult().getClient();
			}
			if(client.getTarjet().getType().equals(Tarjet.AHORROS)||client.getTarjet().getType().equals(Tarjet.BOTH)) {
				double actualAmount = client.getTarjet().getAmount();
				actualAmount += amount;
				client.getTarjet().setAmount(actualAmount);
			}else {
				//User haven't a save account
			}
			
			
		}catch(NullPointerException e) {
			
		}
		
		
		return client.getTarjet().getAmount();
	}

	public boolean cancelAccount(String idAccount) {

		return clients.remove(idAccount);
	}

	public boolean payTarjet(String idAccount) {
		boolean result = false;
		
		Client client = null;
		try {
			if(normalQueue.consult().getClient().getId().equals(idAccount)) {
				client = normalQueue.consult().getClient();
			}else if(priorityQueue.consult().getClient().getId().equals(idAccount)) {
				client = priorityQueue.consult().getClient();
			}
			client.getTarjet().setDateUpdateCredit(LocalDate.now());
			result = true;
		}catch(NullPointerException e) {
			
		}
		
		return result;
	}

	public Client searchUser(String name, String id) {
		Client client = clients.search(id);
		if(client!= null) {
			if(client.getName().equals(name)) {
				return client;
			}
		}	
		return null;
	}
	
	public ArrayList<Client> sortList(String sort,String element, boolean isAscendancy){
		ArrayList<Client> array = clients.getList();
		Comparator<Client> comparator;
		switch(element) {
		case Client.NAME:
			comparator = new CompareByName(isAscendancy);
			break;
		case Client.ID:
			comparator = new CompareByID(isAscendancy);
			break;
		case Client.DATE:
			comparator = new CompareByDate(isAscendancy);
			break;
		case Client.AMOUNT:
			comparator = new CompareByAmount(isAscendancy);
			break;
		default:
			comparator = new CompareByName(isAscendancy);
			break;
		
		}
		switch(sort) {
		case ListSorts.SELECTION:
			ListSorts.selectionSort(array, comparator);
			break;
		case ListSorts.HEAP:
			ListSorts.selectionSort(array, comparator);
			break;
		case ListSorts.MERGE:
			ListSorts.selectionSort(array, comparator);
			break;
		case ListSorts.QUICK:
			ListSorts.selectionSort(array, comparator);
			break;	
		}
		return array;
	}

}
