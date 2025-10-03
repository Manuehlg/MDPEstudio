package MDP.practicarexamanes.tienda;

public class Juego extends Producto {
    private String plataforma;
    private int pegi;

    public Juego(int idProducto, String nombre, float precio, int stock, String plataforma, int pegi) {
        super(idProducto, nombre, precio, stock);
        this.plataforma = plataforma;
        this.pegi = pegi;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }
}
