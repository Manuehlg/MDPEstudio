package MDP.practicarexamanes.Olimpiadas;

public class Atleta {
    private int id;
    private String nombre;
    private Pais pais;

    private int nOros;
    private int nPlatas;
    private int nBronces;

    public Atleta(int id, String nombre, Pais pais, int nOros, int nPlatas, int nBronces) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.nOros = nOros;
        this.nPlatas = nPlatas;
        this.nBronces = nBronces;
    }

    public Atleta(int id, String nombre, int nOros, int nPlatas, int nBronces) {
        this.id = id;
        this.nombre = nombre;
        this.nOros = nOros;
        this.nPlatas = nPlatas;
        this.nBronces = nBronces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getnOros() {
        return nOros;
    }

    public void setnOros(int nOros) {
        this.nOros = nOros;
    }

    public int getnPlatas() {
        return nPlatas;
    }

    public void setnPlatas(int nPlatas) {
        this.nPlatas = nPlatas;
    }

    public int getnBronces() {
        return nBronces;
    }

    public void setnBronces(int nBronces) {
        this.nBronces = nBronces;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais=" + pais +
                ", nOros=" + nOros +
                ", nPlatas=" + nPlatas +
                ", nBronces=" + nBronces +
                '}';
    }
}
