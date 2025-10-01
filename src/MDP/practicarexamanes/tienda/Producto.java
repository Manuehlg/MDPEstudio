package MDP.practicarexamanes.tienda;

import java.util.Queue;

public abstract class Producto {

    private int idProducto;
    private String nombre;
    private float precio;
    private int stock;
    private Queue<Cliente> listaEspera;


    public Producto(int idProducto, String nombre, float precio, int stock, Queue<Cliente> listaEspera) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.listaEspera = listaEspera;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Queue<Cliente> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(Queue<Cliente> listaEspera) {
        this.listaEspera = listaEspera;
    }
}
