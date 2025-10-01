package MDP.practicarexamanes.tienda;

import java.util.Queue;

public class Consola extends Producto{
    private boolean conMandos;

    public Consola(int idProducto, String nombre, float precio, int stock, Queue<Cliente> listaEspera, boolean conMandos) {
        super(idProducto, nombre, precio, stock, listaEspera);
        this.conMandos = conMandos;
    }


    public boolean isConMandos() {
        return conMandos;
    }

    public void setConMandos(boolean conMandos) {
        this.conMandos = conMandos;
    }
}
