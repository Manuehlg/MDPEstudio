package MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03;



import MDP.Practicas.sesion3.es.unex.cume.mdp.sesion03.boleto.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainBoleto1 {
    public static void main(String[] args) {
        List<Boleto> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Boleto b = new Gordo(i, new Date());
            b.rellenarNumerosAleatorios();
            System.out.println(b.toString());
            l.add(b);
        }
        for (Boleto b2 : l) {
            System.out.println(b2.getIdentificador() + " " + b2.getNumeros().toString());
        }
    }
}
