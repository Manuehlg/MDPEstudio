package MDP.practicarexamanes.tienda;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int nif;
    private String nombre;
    private int telefono;
    private int edad;
    private List<Producto> historiaCompra;
    private boolean vip;


    public Cliente(int nif, String nombre, int telefono, int edad, List<Producto> historiaCompra, boolean vip) {
        this.nif = nif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.historiaCompra = new ArrayList<>();
        this.vip = vip;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Producto> getHistoriaCompra() {
        return historiaCompra;
    }

    public void setHistoriaCompra(List<Producto> historiaCompra) {
        this.historiaCompra = historiaCompra;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
