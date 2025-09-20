package MDP.practicarexamanes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Olimpiada oi = new Olimpiada("Z", new Date());
        oi.crearOlimpiada();
        oi.comprobarpruebasdisputadas();
        System.out.println("Olimpiada creada com sucesso");
    }
}
