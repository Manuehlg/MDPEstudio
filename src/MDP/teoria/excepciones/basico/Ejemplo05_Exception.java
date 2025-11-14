package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo05_Exception {
	public static void main(String args[]) {
		try {
			metodo1();
		} catch (NullPointerException e) {
			System.out.println("Excepcion en main");
		}
	}

	private static void metodo1() {
		try {
			metodo2();
		} catch (NullPointerException e) {
			System.out.println("Excepcion en método 1");
		}
	}

	private static void metodo2() throws NullPointerException {
		metodo3();
	}

	private static void metodo3() {
		try {
			Object a = null;
			System.out.println(a.toString());
		} catch (NullPointerException e) {
			throw e;
		}
	}
}