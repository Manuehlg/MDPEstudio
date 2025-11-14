package MDP.teoria.excepciones.balneario;

public class Masaje extends Servicio {
    private String tipo;

    public Masaje(String id, String nombre, double precio, String tipo) throws PrecioInvalidoException {
        super(id, nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}