package MDP.teoria.JUnit.vehiculoss;

public class Pieza {
	private String id;
	private String nombre;
	private int stock;
	
	public Pieza() {	
		this.id = new String();
		this.nombre = new String();
		this.stock = 0;
	}

	public Pieza(String id, String nombre, int contador) {		
		this.id = id;
		this.nombre = nombre;
		this.stock = contador;
	}
	
	public Pieza(Pieza p) {
		this.id = p.id;
		this.nombre = p.nombre;
		this.stock = p.stock;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stock;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Pieza other = (Pieza) obj;
		if (stock != other.stock)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pieza [id=" + id + ", nombre=" + nombre + ", stock=" + stock + "]";
	}




}
