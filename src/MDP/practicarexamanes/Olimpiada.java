package MDP.practicarexamanes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Olimpiada {
    private String nombreOlimpiada;
    private Date fecha;
    private List<Prueba> pruebas;
    private List<Atleta> atletas;
    private List<Pais> paises;

    public Olimpiada(String nombreOlimpiada, Date fecha) {
        this.nombreOlimpiada = nombreOlimpiada;
        this.fecha = fecha;
        this.pruebas = new ArrayList<>();
        this.atletas = new ArrayList<>();
        this.paises = new ArrayList<>();
    }


    public void crearOlimpiada(){

        Pais Spain = new Pais(1, "Spain", 0,0,0);
        Pais France = new Pais(2, "France", 0,0,0);
        Pais China = new Pais(3, "China", 0,0,0);
        Pais Bolivia = new Pais(4, "Bolivia", 0,0,0);
        Pais Uganda = new Pais(5, "Uganda", 0,0,0);


        Prueba salto = new Individual("Salto", new Date(), 0, 0, 0, false);
        Prueba saltoLong = new Individual("Salto de Longitud", new Date(), 0, 0, 0, false);
        Prueba tiroConArco = new Individual("Tiro con Arco", new Date(), 0, 0, 0, false);
        Prueba baloncesto = new Colectiva("salto4", new Date(), 0, 0, 0, false, 8);
        Prueba waterpolo = new Colectiva("salto5", new Date(), 0, 0, 0, false, 10);
        pruebas.add(saltoLong);
        pruebas.add(salto);
        pruebas.add(tiroConArco);
        pruebas.add(baloncesto);
        pruebas.add(waterpolo);
        int i = 0;
        for (Prueba prueba : pruebas) {
            for ( i = 0; i < 4; i++) {}
             prueba.getAtletas().add (new Atleta( i, "Atleta Genérico"+i, Bolivia, 0, 0, 0));
            System.out.println(i + " - " + prueba.getAtletas().get(i).getNombre());
        }



    }


    public void comprobarpruebasdisputadas(){

        int totalDisputadas =0;
        for (Prueba prueba : pruebas) {
            if (prueba.isDisputada()){
                System.out.println("La prueba de "+ prueba.getNombre()+"ya ha sido disputada");
                totalDisputadas++;
            }
            else {
                System.out.println("La prueba de "+ prueba.getNombre()+"todavia NO ha sido disputada");

            }

            System.out.println("Se han disputado un total de:"+ totalDisputadas);
        }
    }

    //getters and setters, equals and hash, toString
    public String getNombreOlimpiada() {
        return nombreOlimpiada;
    }

    public void setNombreOlimpiada(String nombreOlimpiada) {
        this.nombreOlimpiada = nombreOlimpiada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(List<Prueba> pruebas) {
        pruebas = pruebas;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        atletas = atletas;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        paises = paises;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Olimpiada olimpiada)) return false;
        return Objects.equals(nombreOlimpiada, olimpiada.nombreOlimpiada) && Objects.equals(fecha, olimpiada.fecha) && Objects.equals(pruebas, olimpiada.pruebas) && Objects.equals(atletas, olimpiada.atletas) && Objects.equals(paises, olimpiada.paises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreOlimpiada, fecha, pruebas, atletas, paises);
    }

    @Override
    public String toString() {
        return "Olimpiada{" +
                "nombreOlimpiada='" + nombreOlimpiada + '\'' +
                ", fecha=" + fecha +
                ", Pruebas=" + pruebas +
                ", Atletas=" + atletas +
                ", Paises=" + paises +
                '}';
    }
}
