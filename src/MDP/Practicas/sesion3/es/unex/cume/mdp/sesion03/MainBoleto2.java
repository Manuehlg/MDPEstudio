package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03;

import MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainBoleto2 {
    public static void main(String[] args) {
        int veces = 10;
        Random r = new Random();
        Map<Integer, Boleto> m = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Boleto b = new Gordo(i, new Date());
            b.rellenarNumerosAleatorios();
//System.out.println(b.toString());
            m.put(b.getIdentificador(),b);
        }
        for (int i = 0; i < veces; i++) {
            System.out.println(m.get(r.nextInt(veces)));//Acceso aleatorio
        }
    }
}
