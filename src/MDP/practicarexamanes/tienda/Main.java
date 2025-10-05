package MDP.practicarexamanes.tienda;

public class Main {
    public static void main(String[] args) {
        Tienda tiendota = new Tienda("MegaTiendaChachiPistachi");

        tiendota.crearTiendina();
        System.out.println("Una tienda ha spawneado");

        System.out.println("Hay un total de: "+ tiendota.calcularProductosDisponiblesStock() + " productos con stock disponible");
    }


}
