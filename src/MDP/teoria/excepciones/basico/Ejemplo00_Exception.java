package MDP.teoria.excepciones.basico;

import java.util.Scanner;

public class Ejemplo00_Exception {
	public static void main(String args[]) {		
		Scanner scan = new Scanner(System.in);
		// NumberFormatException
		String s=scan.nextLine(); //Introducimos una a
		int x= Integer.parseInt(s);
		
		//InputMismatchException
		x=scan.nextInt(); //Introducimos una a
		
		//NullPointerException
		String s1 = null; //null value
        System.out.println(s1.charAt(0));
		
		//ArithmeticException
		int b= scan.nextInt(); //Introducimos un 0
		int a = 30;
		int c = a / b; // cannot divide by zero
		System.out.println("Result = " + c);

		//ArrayIndexOutOfBound
		int []v = new int[] {1,2,3,4,5};
		for (int i=0;i<=v.length;i++) {
			System.out.println(v[i]);
		}	
	}

}
