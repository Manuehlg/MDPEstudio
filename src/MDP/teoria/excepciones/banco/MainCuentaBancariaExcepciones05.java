package MDP.teoria.excepciones.banco;

//Solución 5. Trato las excepciones donde se produce, no en el main 
//Problema: En el main no se sabe que ha pasado. 			

public class MainCuentaBancariaExcepciones05 {
	public static void main(String[] args) {
		CuentaBancariaExcepciones b = new CuentaBancariaExcepciones();
	
			System.out.println(b.getDisponible());
			deposito(b, 100.0F); // Funciona
			deposito(b, -50.0F); // Error
			System.out.println(b.getDisponible());
			retiro(b, -10.0F); // Error
			retiro(b, 20.0F); // Funciona
			retiro(b, 1000.0F); // Error
		}

	public static void deposito(CuentaBancariaExcepciones c, float f)  {

		try {
			c.depositar(f);
			System.out.println("He metido el dinero");
		} catch (ExceptionNumeroNegativo e) {
			System.out.println("Número negativo");
		}

	}

	public static void retiro(CuentaBancariaExcepciones c, float f) {
		try {
			c.retirar(f);
			System.out.println("He retirado el dinero");
		} catch (ExceptionNumeroNegativo e) {
			System.out.println("Número negativo");
		} catch (ExceptionSaldoInsuficiente e) {
			System.out.println("Saldo insuficiente");
		}
	}
}
