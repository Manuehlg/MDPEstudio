package MDP.Practicas.Sesion07.Sesion07.Sesion07;

public class Ejercicio01_Calc {
	public double add(double a, double b) {
		return a + b;
	}

	public double subtract(double a, double b) {
		return a - b;
	}

	public double multiply(double a, double b) {
		return a * b;
	}

	public double divide(double a, double b) throws MDPException {

			if (b == 0) {
				throw new MDPException();
			}
			return a / b;


	}



}
