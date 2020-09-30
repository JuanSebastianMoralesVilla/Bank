package test;

import org.junit.jupiter.api.Test;

import data_structures.Queue;

class QueueTest {

	@Test
	void testEnqueue() {
		Queue<String> cola = new Queue<>();
		cola.enqueue("hola");
		boolean isEmpty = cola.isEmpty();
		org.junit.Assert.assertEquals(false, isEmpty);
		}

	@Test
	void testDequeue() {
		Queue<String> cola = new Queue<>();
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
		Queue<String> cola = new Queue<>();
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
		Queue<String> cola = new Queue<>();
		cola.enqueue("hola");
		cola.dequeue();
		boolean esperado = cola.isEmpty();
		org.junit.Assert.assertEquals(true, esperado);
	}

	@Test
	void testGetFirst() {
		Queue<String> cola = new Queue<>();
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
