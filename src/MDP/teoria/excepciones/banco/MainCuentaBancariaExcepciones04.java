package MDP.teoria.excepciones.banco;

//Solución 4. Hago varios try-catch por cada tipo 
//Problema: en la línea 18 se produce el error y no hace el resto de líneas de retiro			

public class MainCuentaBancariaExcepciones04 {
	public static void main(String[] args) {
		CuentaBancariaExcepciones b = new CuentaBancariaExcepciones();
		try {
			System.out.println(b.getDisponible());
			deposito(b, 100.0F); // Funciona
			deposito(b, -50.0F); // Error
		} catch (ExceptionNumeroNegativo e) {
			System.out.println("Numero negativo");
		}
		try {
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
