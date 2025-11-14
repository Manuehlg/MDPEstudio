package MDP.teoria.excepciones.banco;

public class CuentaBancaria {
	private float disponible;
	private long numCuenta;

	public CuentaBancaria() {
		disponible = 0.0F;
	}

	public CuentaBancaria(float d) {
		// No se puede sin excepciones
		if (d < 1000.0F) {

		}
		disponible = d;
	}

	public boolean depositar(float f) {
		if (f <= 0.0F)
			return false;
		disponible += f;
		return true;
	}

	public boolean retirar(float f) {
		if (f <= 0.0F)
			return false;
		if (f > disponible) {
			return false;
		}
		disponible -= f;
		return true;
	}

	public float getDisponible() {
		return disponible;
	}

}
