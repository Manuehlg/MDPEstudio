package MDP.practicarexamanes.Olimpiadas;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Olimpiada oi = new Olimpiada("Paris", new Date());
        oi.crearOlimpiada();
        System.out.println("Olimpiada creada com sucesso");
        System.out.println();
        System.out.println(("La comision de France tiene: " + oi.AtletasPorPais("France"))+ " atletas.");
        System.out.println();
        oi.actualizar(4,5,6, "Salto");
        oi.ganadorOrosPruebas();
        System.out.println();
        oi.comprobarpruebasdisputadas();

    }
}
