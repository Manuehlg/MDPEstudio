package MDP.practicarexamanes.tienda;

public class Consola extends Producto{
    private boolean conMandos;

    public Consola(int idProducto, String nombre, float precio, int stock, boolean conMandos) {
        super(idProducto, nombre, precio, stock);
        this.conMandos = conMandos;
    }


    public boolean isConMandos() {
        return conMandos;
    }

    public void setConMandos(boolean conMandos) {
        this.conMandos = conMandos;
    }

    public boolean equals ( Object o ){
        Consola aux = (Consola) o;
        return this.getIdProducto() == aux.getIdProducto() && this.getNombre().equals(aux.getNombre());
    }
}
