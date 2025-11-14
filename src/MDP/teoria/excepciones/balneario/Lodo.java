package MDP.teoria.excepciones.balneario;

public class Lodo extends Servicio {
    private String sustancia;

    public Lodo(String id, String nombre, double precio, String sustancia) throws PrecioInvalidoException {
        super(id, nombre, precio);
        this.sustancia = sustancia;
    }

    public String getSustancia() {
        return sustancia;
    }

    public void setSustancia(String sustancia) {
        this.sustancia = sustancia;
    }
    
}