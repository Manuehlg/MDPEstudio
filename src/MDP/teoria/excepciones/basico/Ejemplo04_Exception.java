package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo04_Exception {
	public static void main(String args[]) {
		int val1, val2;
		try {
			System.out.println("Inicio");
			val1 = 0;
			val2 = 25 / val1;
			System.out.println(val2);
			System.out.println("No llega NUNCA");
		} catch (ArithmeticException e) {
			// handler for ArithmeticException
			System.out.println("ArithmeticException :: División por cero!!");
		} finally {
			System.out.println("Siempre ejecuto esto!!");
		}
		System.out.println("Después del try-catch");
	}
}
