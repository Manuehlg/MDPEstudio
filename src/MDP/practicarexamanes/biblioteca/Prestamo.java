package MDP.practicarexamanes.biblioteca;

import java.time.LocalDate;
import java.util.Objects;


public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaMaxEntrega;
    private LocalDate fechaDevolucion; //efectuada
    private Usuario usuario;
    private Libro libro;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaMaxEntrega, LocalDate fechaDevolucion, Usuario usuario, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaMaxEntrega = fechaMaxEntrega;
        this.fechaDevolucion = fechaDevolucion;
        this.usuario = usuario;
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaMaxEntrega() {
        return fechaMaxEntrega;
    }

    public void setFechaMaxEntrega(LocalDate fechaMaxEntrega) {
        this.fechaMaxEntrega = fechaMaxEntrega;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prestamo prestamo)) return false;
        return Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(fechaMaxEntrega, prestamo.fechaMaxEntrega) && Objects.equals(fechaDevolucion, prestamo.fechaDevolucion) && Objects.equals(usuario, prestamo.usuario) && Objects.equals(libro, prestamo.libro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaPrestamo, fechaMaxEntrega, fechaDevolucion, usuario, libro);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "fechaPrestamo=" + fechaPrestamo +
                ", fechaMaxEntrega=" + fechaMaxEntrega +
                ", fechaDevolucion=" + fechaDevolucion +
                ", usuario=" + usuario +
                ", libro=" + libro +
                '}';
    }
}
