package MDP.practicarexamanes.Eurovision;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private String nombre;
    private int sumaTotalPuntos;
    private Cantante cantante;
    private Presentador presentador;
    private List<Coreografo> coreografos;
    private List<Puntos> puntosEmitidos;
    private List<Puntos> puntosRecibidos;

    public Pais(Presentador presentador, String nombre, int sumaTotalPuntos, Cantante cantante) {
        this.presentador = presentador;
        this.nombre = nombre;
        this.sumaTotalPuntos = sumaTotalPuntos;
        this.cantante = cantante;
        this.coreografos = new ArrayList<>();
        this.puntosRecibidos = new ArrayList<>();
        this.puntosEmitidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSumaTotalPuntos() {
        return sumaTotalPuntos;
    }

    public void setSumaTotalPuntos(int sumaTotalPuntos) {
        this.sumaTotalPuntos = sumaTotalPuntos;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    public Presentador getPresentador() {
        return presentador;
    }

    public void setPresentador(Presentador presentador) {
        this.presentador = presentador;
    }

    public List<Coreografo> getCoreografos() {
        return coreografos;
    }

    public void setCoreografos(List<Coreografo> coreografos) {
        this.coreografos = coreografos;
    }

    public List<Puntos> getPuntosEmitidos() {
        return puntosEmitidos;
    }

    public void setPuntosEmitidos(List<Puntos> puntosEmitidos) {
        this.puntosEmitidos = puntosEmitidos;
    }

    public List<Puntos> getPuntosRecibidos() {
        return puntosRecibidos;
    }

    public void setPuntosRecibidos(List<Puntos> puntosRecibidos) {
        this.puntosRecibidos = puntosRecibidos;
    }


}
