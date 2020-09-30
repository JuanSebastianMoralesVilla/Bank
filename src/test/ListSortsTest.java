package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import comparators.CompareByAmount;
import comparators.CompareByDate;
import comparators.CompareByID;
import comparators.CompareByName;
import data_structures.ListSorts;

import model.Client;
import model.Tarjet;

class ListSortsTest {

	private Client cliente1;
	private Client cliente2;
	private Client cliente3;
	private ArrayList<Client> arreglo;

	public void setup1() {
		cliente1 = new Client("Cristian", "Morales", "1101", Tarjet.AHORROS, "123456", 20000, LocalDate.now());
		cliente2 = new Client("Santiago", "Hurtado", "4010", Tarjet.AHORROS, "123456", 10000, LocalDate.now());
		cliente3 = new Client("Juan", "Morales", "3210", Tarjet.AHORROS, "123456", 30000, LocalDate.now());

		arreglo = new ArrayList();

		arreglo.add(cliente1);
		arreglo.add(cliente2);
		arreglo.add(cliente3);
	}

	@Test
	void testSelectionSort() {

		setup1();

		CompareByName comparator = new CompareByName(true);

		ListSorts ordenamiento = new ListSorts();
		
		ArrayList<String> names1 = new ArrayList();
		names1.add("Cristian");
		names1.add("Juan");
		names1.add("Santiago");
		
		ArrayList<String> names2 = new ArrayList();


		ordenamiento.selectionSort(arreglo, comparator);

		for (int i = 0; i < arreglo.size(); i++) {
			names2.add(arreglo.get(i).getName());
			}
		
		boolean esperado = names1.equals(names2);
		
		org.junit.Assert.assertEquals(true, esperado);

	}

	@Test
	void testHeapSort() {

		setup1();

		CompareByID comparator = new CompareByID(true);
		
		ArrayList<String> names1 = new ArrayList();
		names1.add("1101");
		names1.add("3210");
		names1.add("4010");
		
		ArrayList<String> names2 = new ArrayList();

		ListSorts ordenamiento = new ListSorts();

		ordenamiento.heapSort(arreglo, comparator);

		for (int i = 0; i < arreglo.size(); i++) {
			names2.add(arreglo.get(i).getId());
			}
		
		boolean esperado = names1.equals(names2);
		
		org.junit.Assert.assertEquals(true, esperado);

	}

	@Test
	void testMergeSort() {

		setup1();

		CompareByAmount comparator = new CompareByAmount(true);

		ListSorts ordenamiento = new ListSorts();
		
		ArrayList<Double> names1 = new ArrayList();
		names1.add(10000.00);
		names1.add(20000.00);
		names1.add(30000.00);
		
		ArrayList<Double> names2 = new ArrayList();


		ordenamiento.mergeSort(arreglo, comparator);

		for (int i = 0; i < arreglo.size(); i++) {
			names2.add(arreglo.get(i).getTarjet().getAmount());
			}
		
		boolean esperado = names1.equals(names2);
		
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testQuickSort() {

		setup1();

		CompareByDate comparator = new CompareByDate(true);

		ListSorts ordenamiento = new ListSorts();
		
		ArrayList<LocalDate> names1 = new ArrayList();
		names1.add(cliente1.getDateJoinedBank());
		names1.add(cliente2.getDateJoinedBank());
		names1.add(cliente3.getDateJoinedBank());
		
		ArrayList<LocalDate> names2 = new ArrayList();


		ordenamiento.quickSort(arreglo, comparator);

		for (int i = 0; i < arreglo.size(); i++) {
			names2.add(arreglo.get(i).getDateJoinedBank());
			}
		
		boolean esperado = names1.equals(names2);
		
		org.junit.Assert.assertEquals(true, esperado);

	}

}
