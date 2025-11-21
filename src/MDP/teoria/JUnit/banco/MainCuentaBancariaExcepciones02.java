package MDP.teoria.JUnit.banco;

//Solución 2. Hago un único try-catch con la captura de Exception (clase genérica)
//No es recomendable porque no sabes que excepcion se ha producido

public class MainCuentaBancariaExcepciones02 {
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
		} catch (Exception e) {
			System.out.println("Se ha producido una excepción");
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
