package model;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import comparators.*;
import customExceptions.NoUserException;
import data_structures.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Bank {

	private String nextShift;
	private String nextShiftP;
	private Shift currentNormalClient;
	private Shift currentPriorityClient;
	private HashTable<String,Client> clients;
	private Queue<Shift> normalQueue;
	private PriorityQueue<Shift> priorityQueue;
	private Stack<String[]> undo;
	private Stack<String[]> undoP;
	private HashTable<String,Client> delatedClients;
	
	public Bank() {
		nextShift = "A00";
		nextShiftP = "A00";
		clients = new HashTable<String,Client>();
		normalQueue = new Queue<Shift>();
		priorityQueue = new PriorityQueue<Shift>();
		delatedClients = new HashTable<String,Client>();
		undo = new Stack<String[]>();
		undoP = new Stack<String[]>();
		Client client = new Client("Santiago","Hurtado","1234",0,Tarjet.AHORROS,"1234",1234,LocalDate.now());
		clients.add("1234", client);
		client = new Client("Sebastian","Morales","4321",1,Tarjet.AHORROS,"1234",1234,LocalDate.now());
		clients.add("4321", client);
		client = new Client("Esteban","Yusu","56789",2,Tarjet.AHORROS,"1234",1234,LocalDate.now());
		clients.add("56789", client);
		client = new Client("Super","Aristi","98765",3,Tarjet.AHORROS,"1234",1234,LocalDate.now());
		clients.add("98765", client);
		
	}

	public boolean addClient(String name,String lastName,String id,int priorityLevel,String type,String idAccount,double ammount) {
		boolean save=false;
		if(name!=null&&lastName!=null&&id!=null) {
			if(name!=""&&lastName!=""&&id!="") {
				try {
					Integer.parseInt(idAccount);
					Integer.parseInt(id);
					Client client = new Client(name,lastName,id,priorityLevel,type,idAccount,ammount,LocalDate.now());
					save =clients.add(id, client);
				}catch (NumberFormatException e) {
					//Exist characters in the id's
				}
				
			}
		}
		
		/*if(save){
			String[] addClient = {"addClient",id};
			undo.push(addClient);
		}
		*/
		return save;
	}
	
	public boolean assingShift(String fullName,String idClient) {
		
		Client client = searchUser(fullName,idClient);
		if(client!= null) {
			
			if(client.getPriorityLevel()==0) {
				Shift shift = new Shift(nextShift,client);
				normalQueue.enqueue(shift);
				nextShift();
			}else {
				Shift shift = new Shift(nextShiftP,client);
				priorityQueue.enqueue(shift);
				nextShiftP();
			}
			
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
			if(letter!='Z') {
				letter++;
			}else {
				letter = 'A';
			}
		}
		result += letter;
		if(number<10) {
			result = result+"0";
		}
		result = result+number;
		nextShift=result;
	}
	private void nextShiftP() {
		String result = "";
		char letter = nextShiftP.charAt(0);
		String numberAux = (nextShiftP.charAt(1)+"")+(nextShiftP.charAt(2)+"");
		int number = Integer.parseInt(numberAux);
		number++;
		number = number%100;
		if(number==0) {
			if(letter!='Z') {
				letter++;
			}else {
				letter = 'A';
			}
			
			
		}
		result += letter;
		if(number<10) {
			result = result+"0";
		}
		result = result+number;
		nextShiftP=result;
	}
	
	public double retirement(double amount,String idAccount) throws NoUserException {
		Client client = null;
		try {
			client = clients.search(idAccount);
			if(client.getTarjet().getType().equals(Tarjet.AHORROS)||client.getTarjet().getType().equals(Tarjet.BOTH)) {
				double actualAmount = client.getTarjet().getAmount();
				if(actualAmount>=amount) {
					actualAmount =  actualAmount-amount;
					client.getTarjet().setAmount(actualAmount);
					
					if(client.getPriorityLevel()==0){
						String[] retirement = {"retirement",amount+"",idAccount};
						undo.push(retirement);
					}else {
						String[] retirement = {"retirement",amount+"",idAccount};
						undoP.push(retirement);
					}
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setHeaderText("This user does not have enough money");
					alert.show();
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("This user haven't a saving account");
				alert.show();
			}
			
		}catch(NullPointerException e) {
			throw new NoUserException();
		}
		
		
		return client.getTarjet().getAmount();
	}
	

	public double consignment(double amount, String idAccount) throws NoUserException {
		Client client = null;
		
		try {
			
			if(currentNormalClient.getClient().getId().equals(idAccount)) {
				client = currentNormalClient.getClient();
			}else if(currentPriorityClient.getClient().getId().equals(idAccount)) {
				client = currentPriorityClient.getClient();
			}
			if(client.getTarjet().getType().equals(Tarjet.AHORROS)||client.getTarjet().getType().equals(Tarjet.BOTH)) {
				double actualAmount = client.getTarjet().getAmount();
				actualAmount += amount;
				client.getTarjet().setAmount(actualAmount);
				if(client.getPriorityLevel()==0){
					String[] retirement = {"consignment",amount+"",idAccount};
					undo.push(retirement);
				}else {
					String[] retirement = {"consignment",amount+"",idAccount};
					undoP.push(retirement);
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("This user haven't a saving account");
				alert.show();
				
			}
			
			
		}catch(NullPointerException e) {
			throw new NoUserException();
		}
		return client.getTarjet().getAmount();
	}

	public boolean cancelAccount(String idAccount,String reason) {
		Client clientDelated = clients.search(idAccount);
		boolean result =false;
		if(clientDelated!= null) {
			if(clientDelated.getPriorityLevel()==0){
				String[] retirement = {"cancelAccount",idAccount};
				undo.push(retirement);
			}else {
				String[] retirement = {"cancelAccount",idAccount};
				undoP.push(retirement);
			}
			clients.remove(idAccount);
			result = true;
			
			clientDelated.setReason(reason);
			delatedClients.add(idAccount, clientDelated);
			
		}
		return result;
	}

	public boolean payTarjet(String idAccount) {
		boolean result = false;
		String time=" ";
		Client client = null;
		try {
			if(currentNormalClient.getClient().getId().equals(idAccount)) {
				client = currentNormalClient.getClient();
			}else if(currentPriorityClient.getClient().getId().equals(idAccount)) {
				client = currentPriorityClient.getClient();
			}
			time = client.getTarjet().getDateUpdateCredit().toString();
			client.getTarjet().setDateUpdateCredit(LocalDate.now());
			result = true;
		}catch(NullPointerException e) {
			
		}
		if(result) {
			if(client.getPriorityLevel()==0){
				String[] retirement = {"payTarjet",idAccount,time};
				undo.push(retirement);
			}else {
				String[] retirement = {"payTarjet",idAccount,time};
				undoP.push(retirement);
			}
		}
		return result;
	}

	public Client searchUser(String fullName, String id) {
		String aux[] = fullName.split(" ");
		String lastName = " ";
		if(aux.length>1) {
			lastName = aux[1];
		}
		String name = aux[0];
	
		Client client = clients.search(id);
		if(client!= null) {
			if(client.getName().equals(name)&& client.getLastName().equals(lastName)) {
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
	public Client normalCurrent() {
		/*if(normalQueue.consult()!=null) {
			return normalQueue.consult().getClient();
		}
		*/
		if(currentNormalClient!=null) {
			return currentNormalClient.getClient();
		}
		return null;
	}
	public Client priorityCurrent() {
		/*if(priorityQueue.consult()!=null) {
			return priorityQueue.consult().getClient();
		}
		*/
		if(currentPriorityClient!=null) {
			return currentPriorityClient.getClient();
		}
		return null;
		
	}
	public String normalShift() {
		/*
		if(normalQueue.consult()!=null) {
			return  normalQueue.consult().getIdShifth();
		}else {
			return"   ";
		}
		*/
		if(currentNormalClient!=null) {
			return currentNormalClient.getIdShifth();
		}else {
			return"   ";
		}
	}
	public String priorityShift() {
		/*
		if(priorityQueue.consult()!=null) {
			return  priorityQueue.consult().getIdShifth();
		}else {
			return"   ";
		}*/
		if(currentPriorityClient!=null) {
			return currentPriorityClient.getIdShifth();
		}else {
			return"   ";
		}
	}
	public void nextNormalClient() {
		currentNormalClient=normalQueue.dequeue();
	}
	public void nextPriorityClient() {
		currentPriorityClient= priorityQueue.dequeue();
	}
	
	public boolean undo(boolean priority) {
		boolean result = false;
		String[] actualProcess;
		if(priority) {
			actualProcess = undoP.pop();
		}else {
			actualProcess = undo.pop();
		}
		
		if(actualProcess!=null) {
			Client client;
			double amount=0;
			switch(actualProcess[0]) {
			case "addClient":
				clients.remove(actualProcess[1]);
				break;
			case "retirement":
				amount = Double.parseDouble(actualProcess[1]);
				client = clients.search(actualProcess[2]);
				amount += client.getAmount();
				client.getTarjet().setAmount(amount);
				break;
			case "consignment":
				amount = Double.parseDouble(actualProcess[1]);
				client = clients.search(actualProcess[2]);
				amount = client.getAmount()-amount;
				client.getTarjet().setAmount(amount);
				break;
			case "cancelAccount":
				client = delatedClients.search(actualProcess[1]);
				clients.add(actualProcess[1], client);
				break;
			case "payTarjet":
				client = clients.search(actualProcess[1]);
				client.getTarjet().setDateUpdateCredit(LocalDate.parse(actualProcess[2]));
				break;
			}
		}
		return result;
	}

}
