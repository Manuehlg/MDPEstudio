package MDP.teoria.excepciones.balneario;

public class Socio extends Cliente {
    private String identificador;

    public Socio(String nombre, String dni, String identificador) throws DniInvalidoException {
        super(nombre, dni);
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
