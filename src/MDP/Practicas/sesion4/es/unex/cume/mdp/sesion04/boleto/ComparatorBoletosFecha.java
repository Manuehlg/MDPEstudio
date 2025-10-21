package MDP.Practicas.sesion4.es.unex.cume.mdp.sesion04.boleto;

import java.util.*;

public class ComparatorBoletosFecha implements Comparator<Boleto> {
    @Override
    public int compare(Boleto b1, Boleto b2) {
        return b1.getFecha().compareTo(b2.getFecha());
    }
}