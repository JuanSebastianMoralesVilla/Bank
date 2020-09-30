package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data_structures.PriorityQueue;
import data_structures.Queue;


class PriorityQueueTest {

	@Test
	void testEnqueue() {
		PriorityQueue<String> cola = new PriorityQueue<>();
		cola.enqueue("hola");
		boolean isEmpty = cola.isEmpty();
		System.out.println(isEmpty);
		org.junit.Assert.assertEquals(false, isEmpty);
	}

	@Test
	void testDequeue() {
		PriorityQueue <String> cola = new PriorityQueue<>();
		cola.enqueue("hola");
		String verificacion = cola.dequeue();
		boolean esperado = false;
		if(verificacion.equals("hola")) {
			esperado = true;
		}
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testConsult() {
		PriorityQueue<String> cola = new PriorityQueue <>();
		cola.enqueue("hola");
		String verificacion = cola.consult();
		boolean esperado = false;
		boolean isEmpty = cola.isEmpty();
		if(verificacion.equals("hola") && !isEmpty) {
			esperado = true;
		}
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testIsEmpty() {
		PriorityQueue<String> cola = new PriorityQueue<>();
		cola.enqueue("hola");
		cola.dequeue();
		boolean esperado = cola.isEmpty();
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testGetFirst() {
		PriorityQueue<String> cola = new PriorityQueue<>();
		cola.enqueue("hola");
		String verificacion = cola.getFirst().getElement();
		boolean esperado = false;
		boolean isEmpty = cola.isEmpty();
		if(verificacion.equals("hola") && !isEmpty) {
			esperado = true;
		}
		org.junit.Assert.assertEquals(true, esperado);
	}

}
