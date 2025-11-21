package MDP.teoria.JUnit.vehiculoss;

import java.util.Arrays;


public class Vehiculo {
	private String marca;
	private String modelo;
	private Persona propietario;
	private Pieza[] piezas;
	private Integer bastidor;
	private int cont;

	
	
	public Vehiculo(String marca, String modelo, Persona propietario, Integer bastidor,int tam) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = propietario;
		this.bastidor = bastidor;
		piezas=new Pieza[tam];
	}

	public Vehiculo() {

		this.marca = new String();
		this.modelo = new String();
		this.piezas = new Pieza[3];
		this.cont = 0;
		propietario = new Persona();
	}

	public Vehiculo(int tam) {

		this.marca = new String();
		this.modelo = new String();
		this.piezas = new Pieza[tam];
		this.cont = 0;
		propietario = new Persona();
	}
	public Vehiculo(String marca, String modelo, Persona p, int tam) {

		this.marca = marca;
		this.modelo = modelo;
		this.piezas = new Pieza[tam];
		this.cont = 0;
		propietario = p;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Pieza[] getPiezas() {
		return piezas;
	}

	public void setPiezas(Pieza[] piezas) {
		this.piezas = piezas;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public boolean addPiezaV(Pieza p) {
		if (cont  == piezas.length)
			return false;
		else {
			for (int i = 0; i < piezas.length; i++) {
				if (piezas[i]!=null && piezas[i].equals(p))
					return false;
			}
			piezas[cont] = p;
			cont++;
			return true;
		}
	}

	public Pieza getPiezaV(int pos) {
		if (pos >= piezas.length)
			return null;
		else if (pos < 0)
			return null;
		return piezas[pos];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cont;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + Arrays.hashCode(piezas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (cont != other.cont)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	public Integer getBastidor() {
		return bastidor;
	}

	public void setBastidor(Integer bastidor) {
		this.bastidor = bastidor;
	}

}
