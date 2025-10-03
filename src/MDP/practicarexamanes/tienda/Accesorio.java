package MDP.practicarexamanes.tienda;

public class Accesorio extends Producto{
    private boolean retro;

    public Accesorio(int idProducto, String nombre, float precio, int stock, boolean retro) {
        super(idProducto, nombre, precio, stock);
        this.retro = retro;
    }

    public boolean isRetro() {
        return retro;
    }

    public void setRetro(boolean retro) {
        this.retro = retro;
    }
}
