package MDP.practicarexamanes.Olimpiadas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Prueba {
    protected String nombre;
    protected Date fecha;

    protected int oro; //idpais
    protected int plata; //idpais
    protected int bronce; //idpais
    // se relacionan con el pais ganador

    protected boolean disputada;

    protected List<Atleta> atletas;

    public Prueba(String nombreOlimpiada, Date fecha,  int oro, int plata, int bronce, boolean disputada) {
        this.nombre = nombreOlimpiada;
        this.fecha = fecha;
        this.oro = oro;
        this.plata  = plata;
        this.bronce = bronce;
        this.disputada = disputada;
        atletas = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBronce() {
        return bronce;
    }

    public void setBronce(int bronce) {
        this.bronce = bronce;
    }

    public boolean isDisputada() {
        return disputada;
    }

    public void setDisputada(boolean disputada) {
        this.disputada = disputada;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }
}
