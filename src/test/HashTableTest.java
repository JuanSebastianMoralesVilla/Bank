package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import data_structures.HashTable;

class HashTableTest {

	@Test
	void testIsEmpty() {
		HashTable< String, String> tabla = new HashTable<>();
		boolean isEmpty = tabla.isEmpty();
		org.junit.Assert.assertEquals(true, isEmpty);	
	}

	@Test
	void testAdd() {
		HashTable< String, String> tabla = new HashTable<>();
		tabla.add("test", "holaMundo");
		int size = tabla.size();
		boolean tamanio = size==0;
		org.junit.Assert.assertEquals(false, tamanio);
	}

	@Test
	void testSearch() {
		HashTable< String, String> tabla = new HashTable<>();
		tabla.add("test", "hola");
		tabla.add("test2", "mundo");
		String test = tabla.search("test");
		String test2= tabla.search("test2");
		boolean esperado = (test.equals("hola")&& test2.equals("mundo"));
		org.junit.Assert.assertEquals(true, esperado);
		
	}

	@Test
	void testRemove() {
		HashTable< String, String> tabla = new HashTable<>();
		tabla.add("test", "hola");
		tabla.add("test2", "mundo");
		tabla.remove("test");
		boolean esperado = tabla.size()==1;
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testSize() {
		HashTable< String, String> tabla = new HashTable<>();
		tabla.add("test", "hola");
		tabla.add("test2", "mundo");
		boolean esperado = tabla.size()==2;
		org.junit.Assert.assertEquals(true, esperado);
		}

	@Test
	void testGetList() {
		HashTable< String, String> tabla = new HashTable<>();
		tabla.add("test", "hola");
		tabla.add("test2", "mundo");
		ArrayList<String> list = tabla.getList();
		System.out.println("hola");
		String test = list.get(0);
		String test2= list.get(1);
		System.out.println(test + test2);
		boolean esperado = (test.equals("hola")&& test2.equals("mundo"));
		org.junit.Assert.assertEquals(false, esperado);

	}

}
