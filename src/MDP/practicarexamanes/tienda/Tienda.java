package MDP.practicarexamanes.tienda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tienda {

    private String nombre;
    private LinkedList<Producto> productos;
    private List<Cliente> clientes;

    public Tienda(String nombre, LinkedList<Producto> productos, List<Cliente> clientes) {
        this.nombre = nombre;
        this.productos = new LinkedList<>();
        this.clientes = new ArrayList<>();
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
