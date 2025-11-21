package MDP.teoria.JUnit.banco;

//Solución 1. Hago throws siempre. Problema: Se acaba produciendo el error en ejecución

public class MainCuentaBancariaExcepciones01 {
	public static void main(String[] args) throws ExceptionNumeroNegativo, ExceptionSaldoInsuficiente {

		CuentaBancariaExcepciones b = new CuentaBancariaExcepciones();
		System.out.println(b.getDisponible());
		deposito(b, 100.0F); // Funciona
		deposito(b, -50.0F); // Error
		System.out.println(b.getDisponible());
		retiro(b, -10.0F); // Error
		retiro(b, 20.0F); // Funciona
		retiro(b, 1000.0F); // Error
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
