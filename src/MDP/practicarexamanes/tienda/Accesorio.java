package MDP.practicarexamanes.tienda;

import java.util.Queue;

public class Accesorio extends Producto{
    private boolean retro;

    public Accesorio(int idProducto, String nombre, float precio, int stock, Queue<Cliente> listaEspera, boolean retro) {
        super(idProducto, nombre, precio, stock, listaEspera);
        this.retro = retro;
    }

    public boolean isRetro() {
        return retro;
    }

    public void setRetro(boolean retro) {
        this.retro = retro;
    }
}
