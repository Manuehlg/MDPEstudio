package MDP.practicarexamanes;

public class Pais {
    private int idPais;
    private String nombre;
    private int nOros;
    private int nPlatas;
    private int nBronces;

    public Pais(int idPais, String nombre, int nOros, int nPlatas, int nBronces) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.nOros = nOros;
        this.nPlatas = nPlatas;
        this.nBronces = nBronces;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


}
