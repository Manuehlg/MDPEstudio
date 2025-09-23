package MDP.practicarexamanes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Olimpiada oi = new Olimpiada("Z", new Date());
        oi.crearOlimpiada();
        System.out.println("Olimpiada creada com sucesso");
        System.out.println();
        oi.comprobarpruebasdisputadas();
        System.out.println();
        System.out.println(("La comision de France tiene: " + oi.AtletasPorPais("France"))+ " atletas.");
        System.out.println();
        oi.ganadorOrosPruebas();

    }
}
