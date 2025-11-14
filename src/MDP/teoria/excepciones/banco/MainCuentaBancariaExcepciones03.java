package MDP.teoria.excepciones.banco;


//Solución 3. Hago un único try-catch en el main con distintas excepciones 
//Sabemos que excepción se ha producido. 
//Problema: en la línea 15 se produce el error y no hace las líneas 16-19			

public class MainCuentaBancariaExcepciones03 {
	public static void main(String[] args) {
		try {

			CuentaBancariaExcepciones b = new CuentaBancariaExcepciones();
			System.out.println(b.getDisponible());
			deposito(b, 100.0F); // Funciona
			deposito(b, -50.0F); // Error
			System.out.println(b.getDisponible());
			retiro(b, -10.0F); // Error
			retiro(b, 20.0F); // Funciona
			retiro(b, 1000.0F); // Error
		} catch (ExceptionNumeroNegativo e) {
			System.out.println("Numero negativo");

		} catch (ExceptionSaldoInsuficiente e) {
			System.out.println("Saldo insuficiente");
		}
	}

	public static void deposito(CuentaBancariaExcepciones c, float f) throws ExceptionNumeroNegativo {

		c.depositar(f);
		System.out.println("He metido el dinero");

	}

	public static void retiro(CuentaBancariaExcepciones c, float f)
			throws ExceptionNumeroNegativo, ExceptionSaldoInsuficiente {

		c.retirar(f);
		System.out.println("Se ha retirado con exito");

	}

}
