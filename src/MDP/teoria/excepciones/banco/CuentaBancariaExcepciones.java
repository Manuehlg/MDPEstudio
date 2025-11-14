package MDP.teoria.excepciones.banco;

public class CuentaBancariaExcepciones {
	private float disponible;
	private long numCuenta;

	public CuentaBancariaExcepciones() {
		disponible = 0.0F;
	}

	public CuentaBancariaExcepciones(float d) throws ExceptionCuentaRacana {
		// No se puede sin excepciones
		if (d < 1000.0F) {
			throw new ExceptionCuentaRacana();
		}
		disponible = d;
	}

	public void depositar(float f) throws ExceptionNumeroNegativo {
		if (f <= 0.0F)
			throw new ExceptionNumeroNegativo();
		disponible += f;

	}

	public void retirar(float f) throws ExceptionNumeroNegativo, ExceptionSaldoInsuficiente {
		if (f <= 0.0F)
			throw new ExceptionNumeroNegativo();
		if (f > disponible) {
			throw new ExceptionSaldoInsuficiente();
		}
		disponible -= f;

	}

	public float getDisponible() {
		return disponible;
	}

}
