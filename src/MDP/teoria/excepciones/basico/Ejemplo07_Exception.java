package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo07_Exception {
	Scanner scan = new Scanner(System.in);

	// Java program to demonstrate ArithmeticException
	public static void main(String args[]) {
		Ejemplo07_Exception e= new Ejemplo07_Exception();
		int x=e.leer();
		int y=e.leer();
		System.out.println(e.dividir(x, y));
	}

	public int leer() { //No devolver excepción. Se retorna cuando haya entero
		String s = scan.nextLine(); 
		int x = Integer.parseInt(s);
		return x;

	}

	public int dividir(int a, int b) { //Devolver excepción
		return a / b;
	}
}
