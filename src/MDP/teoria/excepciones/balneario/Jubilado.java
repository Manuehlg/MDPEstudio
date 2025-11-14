package MDP.teoria.excepciones.balneario;

public class Jubilado extends Cliente {
    private int edad;

    public Jubilado(String nombre, String dni, int edad) throws DniInvalidoException {
        super(nombre, dni);
        this.edad = edad;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
