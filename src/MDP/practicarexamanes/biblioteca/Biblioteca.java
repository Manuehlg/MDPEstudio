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


    public void crearBibliteca() {
        Random random = new Random();
        int i;
        int j;
        for (i = 0; i < 5; i++) {
            usuarios.add(new Usuario("Alumno" + i, i, i % 2 == 0));
        }
        for (j = 0; j < 5; j++) {
            libros.add(new Libro("Titulo Generico" + j, "Autor Generico" + j,
                    random.nextInt(20) + 1, "TematicaGenerica" + j));
        }
        prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                usuarios.get(random.nextInt(usuarios.size())), libros.get(random.nextInt(libros.size()))));

        /*
         prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                usuarios.get(random.nextInt(usuarios.size())), libros.get(3) ));
         prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                usuarios.get(random.nextInt(usuarios.size())), libros.get(3) ));
         prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                usuarios.get(random.nextInt(usuarios.size())), libros.get(3) ));

         -> Prestamos para comprobrar buscarNumeroPrestamosActuales
        */

        /*
         libros.add(new Libro("Titulo Generico"+j+1, "Autor Generico"+j+1 ,
                -2, "TematicaGenerica"+j+1 ));
         -> Libro con stock negativo para comprobacion CalcularTotalLibrosStockPositivo
         */

/*
        Libro libro1 = new Libro("Titulo Generico45", "Autor Generico342", 5, "Informatica");
        Libro libro3 = new Libro("Titulo Generico44", "Autor Generico334", 2, "Informatica");
        libros.add(libro1);
        libros.add(libro3);

        Usuario usuario1 = new Usuario("Alumno0", 342, true);

        Prestamo prestamo1 = new Prestamo(
                LocalDate.now(),
                LocalDate.now().plusDays(15),
                null,
                usuario1,
                libro1   // libro de tematica Informatica
        );
        prestamos.add(prestamo1);

        -> Comprobar metodo mostrarLibrosSinPrestamo
*/

    }

    public int CalcularTotalLibrosStockPositivo() {
        int totalLibrosStockPositivo = 0;

        for (Libro libro : libros) {
            if (libro.getStock() >= 0) {
                totalLibrosStockPositivo++;
            }
        }

        return totalLibrosStockPositivo;

    }

    public int buscarNumeroPrestamosActuales(String nombrechulo) {
        int totalPrestamosActuales = 0;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equals(nombrechulo)) {
                totalPrestamosActuales++;
            }
        }
        return totalPrestamosActuales;
    }

    public ArrayList<Libro> mostrarLibrosSinPrestamo(String tematicachula) {
        ArrayList<Libro> librosSinPrestamosSegunTematica = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTematica().equals(tematicachula)) {
                boolean estaPrestado = false;
                for (Prestamo prestamo : prestamos) {
                    if (prestamo.getLibro() == libro) {
                        estaPrestado = true;
                        break;
                    }
                }
                if (!estaPrestado) {
                    librosSinPrestamosSegunTematica.add(libro);
                }
            }
        }
        return librosSinPrestamosSegunTematica;

    }

    public boolean reservar(int idUsuario, String nombreLibro) {

        for (Usuario usu : usuarios) {
            if (usu.getId() == idUsuario) {
                for (Libro libro : libros) {
                    if (libro.getTitulo().equals(nombreLibro)) {
                        if (!usu.isAmonestado()) {
                            if (libro.getStock() > 0) {
                                prestamos.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(), usu, libro));

                                libro.setStock(libro.getStock() - 1);

                                return true;
                            } else {
                                espera.add(new Prestamo(LocalDate.now(), LocalDate.now(), LocalDate.now(), usu, libro));
                                System.out.println("Añadido a cola de espera");
                                return false;
                            }
                        } else {
                            System.out.println("El usuario esta amonestado");
                            return false;
                        }
                    }
                }
                System.out.println("El libro no existe");
                return false;
            }
        }
        System.out.println("El usuario no existe");
        return false;
    }

    public boolean devolver(int idUsuario, String nombreLibro) {
        return false;
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
