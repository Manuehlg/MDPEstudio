package MDP.teoria.excepciones.balneario;

public abstract class Servicio {
    protected String id;
    protected String nombre;
    protected double precio;

    public Servicio(String id, String nombre, double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("Precio inválido: " + precio);
        }
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}