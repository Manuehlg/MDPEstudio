package MDP.practicarexamanes.Olimpiadas;

import java.util.Date;

public class Colectiva extends Prueba{
    private int numP;

    public Colectiva(String nombre, Date fecha, int oro, int plata, int bronce, boolean disputada, int numP) {
        super(nombre, fecha, oro, plata, bronce, disputada);
        this.numP = numP;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }
}
