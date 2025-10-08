package MDP.practicarexamanes.Eurovision;

public class Cantante extends Persona{
    private int edad;

    public Cantante(String nombre, String apellidos, int edad) {
        super(nombre, apellidos);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
