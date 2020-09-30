package test;

import org.junit.jupiter.api.Test;

import data_structures.Stack;

class StackTest {

	@Test
	void testStack() {
		Stack<String> pila = new Stack<>();
		boolean seCreo = false;
		if (pila != null) {
			seCreo = true;
		}
		org.junit.Assert.assertEquals(true, seCreo);
	}
	
	@Test
	void testPush() {

		Stack<String> pila = new Stack<>();
		pila.push("hola");
		boolean isEmpty = pila.isEmpty();
		org.junit.Assert.assertEquals(false, isEmpty);
	}

	@Test
	void testPop() {
		Stack<String> pila = new Stack<>();
		pila.push("hola");
		String verificacion = pila.pop();
		boolean esperado = false;
		if(verificacion.equals("hola")) {
			esperado = true;
		}
		org.junit.Assert.assertEquals(true, esperado);

	}

	@Test
	void testPeek() {
		Stack<String> pila = new Stack<>();
		pila.push("hola");
		String verificacion = pila.peek();
		boolean esperado = false;
		boolean isEmpty = pila.isEmpty();
		if(verificacion.equals("hola") && !isEmpty) {
			esperado = true;
		}
		org.junit.Assert.assertEquals(true, esperado);	
	}

	@Test
	void testIsEmpty() {
		Stack<String> pila = new Stack<>();
		pila.push("hola");
		pila.pop();
		boolean esperado = pila.isEmpty();
		org.junit.Assert.assertEquals(true, esperado);
	}

}
