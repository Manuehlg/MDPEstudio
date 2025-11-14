package MDP.teoria.excepciones.balneario;

public class Hidroterapia extends Servicio {
    private String modelo;

    public Hidroterapia(String id, String nombre, double precio, String modelo) throws PrecioInvalidoException {
        super(id, nombre, precio);
        this.modelo = modelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}