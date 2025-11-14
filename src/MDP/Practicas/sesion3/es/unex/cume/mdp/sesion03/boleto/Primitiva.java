
package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto;

import java.util.*;

public class Primitiva extends Boleto {

	// Primitiva: 6 números entre 1 y 49 y 1 complementario entre 0 y 9

	private int complementario;

	public Primitiva(int identificador, Date f, int complementario) {
		super(identificador, f, 6, 49, 10);
		this.complementario = complementario;
	}

	public Primitiva(int identificador, Date f) {
		super(identificador, f, 6, 49, 10);
	}

	public int aciertoComplementarios(Boleto b) {
		Primitiva aux = (Primitiva) b;
		if (this.complementario == aux.complementario)
			return 1;
		else
			return 0;
	}

	public boolean rellenarNumerosAleatorios() {
		Random r = new Random(new Date().getTime());
		while (this.numeros.size() != cantidadNumeros) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			this.numeros.add(r.nextInt(maxNumero) + 1);
		}
		this.complementario = r.nextInt(maxComplementario);

		return true;
	}

	public int getComplementario() {
		return complementario;
	}

	public void setComplementario(int complementario) {
		this.complementario = complementario;
	}

	@Override
	public String toString() {
		return "Primitiva [identificador=" + identificador + ", complementario=" + complementario + ", numeros="
				+ numeros + "]";
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

}
