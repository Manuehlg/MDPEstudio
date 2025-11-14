package MDP.teoria.excepciones.balneario;

public class Normal extends Cliente {
    private String telefono;

    public Normal(String nombre, String dni, String telefono) throws DniInvalidoException {
        super(nombre, dni);
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}