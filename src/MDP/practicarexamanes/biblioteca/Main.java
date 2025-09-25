package MDP.practicarexamanes.biblioteca;

public class Main {
    public static void main (String[] args){
        Biblioteca biblioMerida = new Biblioteca ();
        biblioMerida.crearBibliteca();
        System.out.println("Biblio creada ratilla");

        System.out.println("Hay un total de "+biblioMerida.CalcularTotalLibrosStockPositivo()+" libros con stock disponible en la biblioteca");

        System.out.println("Hay un total de "+biblioMerida.buscarNumeroPrestamosActuales("Titulo Generico3") +" Titulo Generico3 en prestamo");

        System.out.println("Libros de tematica Informatica que no estan en prestamo:");
        for (Libro libro : biblioMerida.mostrarLibrosSinPrestamo("Informatica")){
            System.out.println(libro);
        }





    }
}
