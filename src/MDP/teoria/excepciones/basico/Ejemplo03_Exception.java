package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo03_Exception {
	public static void main(String args[]) {
		try {
			// try block1
			try {
				System.out.println("Inicio try bloque 1");
				int num = 15 / 0;
				System.out.println("No llega nunca: bloque 1");
			} catch (ArithmeticException e1) {
				System.out.println("Bloque 1 Exception: e1");
			}
			// try block2
			try {
				System.out.println("Inicio  try bloque 2");
				int num = 100 / 0;
				System.out.println("No llega nunca: bloque 2");
			} catch (ArrayIndexOutOfBoundsException e2) {
				System.out.println("Bloque 2 Exception: e2");
			} finally {
				System.out.println("Finally 1");
			}
			
			System.out.println("Después bloque 1 y 2");
		} catch (ArithmeticException e3) {
			System.out.println("Main Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException e4) {
			System.out.println("Main ArrayIndexOutOfBoundsException");
		} catch (Exception e5) {
			System.out.println("Main General Exception");
		} finally {
			System.out.println("finally 2");
		}
		System.out.println("Después del try-catch");
	}
}
