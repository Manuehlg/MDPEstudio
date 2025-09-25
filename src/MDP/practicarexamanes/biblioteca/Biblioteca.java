package MDP.practicarexamanes.biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Biblioteca {

    private List<Libro> libros;
    private LinkedList<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private Queue<Prestamo> espera;


    public Biblioteca() {
        this.usuarios = new LinkedList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.espera = new LinkedList<>();
    }


    public void crearBibliteca (){
        Random random = new Random();
        int i;
        int j;
        for ( i = 0; i<5; i++) {
            usuarios.add(new Usuario("Alumno" + i, i, i % 2 == 0));
        }
        for ( j = 0; j<5; j++) {
            libros.add(new Libro("Titulo Generico"+j, "Autor Generico"+j ,
                    random.nextInt(20)+1, "TematicaGenerica"+j ));
        }
        prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                usuarios.get(random.nextInt(usuarios.size())), libros.get(random.nextInt(libros.size())) ));
        System.out.println(prestamos);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Queue<Prestamo> getEspera() {
        return espera;
    }

    public void setEspera(Queue<Prestamo> espera) {
        this.espera = espera;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Biblioteca that)) return false;
        return Objects.equals(libros, that.libros) && Objects.equals(usuarios, that.usuarios) && Objects.equals(prestamos, that.prestamos) && Objects.equals(espera, that.espera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libros, usuarios, prestamos, espera);
    }

}
