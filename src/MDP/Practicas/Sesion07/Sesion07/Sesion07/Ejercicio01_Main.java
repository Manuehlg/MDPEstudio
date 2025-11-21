package MDP.Practicas.Sesion07.Sesion07.Sesion07;

public class Ejercicio01_Main {
	public static void main(String[]args) {
		Ejercicio01_Main e=new Ejercicio01_Main();
		try {
			e.ejecutar();
		} catch (MDPException e1){
			System.out.println (e1.getMessage());
		}
	}
	
	public void ejecutar() throws MDPException {
		Ejercicio01_Calc c= new Ejercicio01_Calc();
		System.out.println("Antes del try");
//		try {
			c.divide(10, 0);
			System.out.println(" despues de dividir");
//		} catch (NullPointerException e){
//			System.out.println(" en el catch");
//		} finally {
//			System.out.println("En el finally");
//		}

//		System.out.println("Después de dividir");
//		System.out.println("En el catch");
//
		
	}
}
