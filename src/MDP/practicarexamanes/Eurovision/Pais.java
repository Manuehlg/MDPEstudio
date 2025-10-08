package MDP.practicarexamanes.Eurovision;

import java.util.List;

public class Pais {

    private String nombre;
    private int sumaTotalPuntos;
    private Cantante cantante;
    private Presentador presentador;
    private List<Coreografo> coreografos;


    public Pais(String nombre, int sumaTotalPuntos, Cantante cantante, Presentador presentador, List<Coreografo> coreografos) {
        this.nombre = nombre;
        this.sumaTotalPuntos = sumaTotalPuntos;
        this.cantante = cantante;
        this.presentador = presentador;
        this.coreografos = coreografos;
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
}
