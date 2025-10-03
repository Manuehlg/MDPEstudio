package MDP.practicarexamanes.tienda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tienda {

    private String nombre;
    private LinkedList<Producto> productos;
    private List<Cliente> clientes;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new LinkedList<>();
        this.clientes = new ArrayList<>();
    }


    public void crearTiendina() {
        Cliente c1 = new Cliente(1323466, "Perez Pelaez", 123456789, 21, false);
        Cliente c2 = new Cliente(1323, "Pelar", 123456789, 21, false);
        Cliente c3 = new Cliente(1466, "Polaez", 123456789, 21, false);
        Cliente c4 = new Cliente(1366, "Juan", 123456789, 21, true);
        Cliente c5 = new Cliente(3466, "Jorge Pelaez", 123456789, 21, false);
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);

        Consola plei = new Consola (1, "Plai6", 212.12f, 23, true);
        Consola Jbox = new Consola (2, "JBox 2", 452.2f, 5, false);
        Juego Banananza = new Juego (3, "KD Banananza", 89.01f, 59, "NoTendo", 12);
        Juego OdiseadeMariano = new Juego (4, "Odisea de Mariano", 45.81f, 14, "NoTendo", 15);
        Accesorio Pokeballfriki = new Accesorio ( 5, "Bola de Bichos", 4f, 6, false);
        productos.add(plei);
        productos.add(Jbox);
        productos.add(Banananza);
        productos.add(OdiseadeMariano);
        productos.add(Pokeballfriki);

        c1.getHistorialCompra().add(plei);
        c2.getHistorialCompra().add(plei);
        c3.getHistorialCompra().add(plei);
        c4.getHistorialCompra().add(plei);
        c5.getHistorialCompra().add(plei);


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tienda tienda)) return false;
        return Objects.equals(nombre, tienda.nombre) && Objects.equals(productos, tienda.productos) && Objects.equals(clientes, tienda.clientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, productos, clientes);
    }
}
