package MDP.practicarexamanes.tienda;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Tienda tiendota = new Tienda("MegaTiendaChachiPistachi");

        tiendota.crearTiendina();
        System.out.println("Una tienda ha spawneado");

        System.out.println("Hay un total de: "+ tiendota.calcularProductosDisponiblesStock() + " productos con stock disponible");
        System.out.println("El total de gasto acumulado del cliente 1 es de "+ tiendota.gastoTotalCliente(1323466)+"€");

    }


}
