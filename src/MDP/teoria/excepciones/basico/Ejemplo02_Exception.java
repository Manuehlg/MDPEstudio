package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo02_Exception {
	public static void main(String args[]) {
		try {
			System.out.println("Inicio");
			int myArray[] = new int[] {1,2,3,4,5};
			myArray[5] = 10 / 0;
			System.out.println("No llega NUNCA");
			// multiple catch blocks
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception :: División por cero!!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds :: Fuera de rango");
		} catch (Exception e) {
			System.out.println("Otra Excepcion :: " + e.getMessage());
		}
		System.out.println("Después del try-catch");
	}
}
