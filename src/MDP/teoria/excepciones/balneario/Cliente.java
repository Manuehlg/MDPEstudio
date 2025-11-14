package MDP.teoria.excepciones.balneario;

import java.util.ArrayList;
import java.util.List;

// Clase base Cliente
public abstract class Cliente {
    protected String nombre;
    protected String dni;
    protected List<Servicio> servicios;

    public Cliente(String nombre, String dni) throws DniInvalidoException {
        //permitir que el dni tenga de 1 a 8 digitos seguido de una letra
        if (!dni.matches("\\d{1,8}[A-Z]")) {
            throw new DniInvalidoException("DNI inválido: " + dni);
        }
        if (!comprobarLetraDni(dni)) {
            throw new DniInvalidoException("Letra del DNI incorrecta: " + dni);
        }

        this.nombre = nombre;
        this.dni = dni;
        this.servicios = new ArrayList<>();
    }

    private boolean comprobarLetraDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //obtener los números con la longitud adecuada
        int numero = Integer.parseInt(dni.substring(0, dni.length() - 1));
        char letraCorrecta = letras.charAt(numero % 23);
        return letraCorrecta == dni.charAt(dni.length() - 1);
    }

    public void agregarServicio(Servicio s) {
        servicios.add(s);
    }

    public double calcularTotal() {
        double total = 0;
        for (Servicio s : servicios) {
            total += s.getPrecio();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}