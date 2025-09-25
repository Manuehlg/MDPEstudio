package MDP.practicarexamanes.biblioteca;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private int id;
    private boolean amonestado;

    public Usuario(String nombre, int id, boolean amonestado) {
        this.nombre = nombre;
        this.id = id;
        this.amonestado = amonestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAmonestado() {
        return amonestado;
    }

    public void setAmonestado(boolean amonestado) {
        this.amonestado = amonestado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id && amonestado == usuario.amonestado && Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, amonestado);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", amonestado=" + amonestado +
                '}';
    }
}
