package MDP.practicarexamanes.biblioteca;

import java.util.Objects;

public class Libro {

    private String titulo;
    private String autor;
    private int stock;
    private String tematica;

    public Libro (String titulo, String autor, int stock, String tematica){
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
        this.tematica = tematica;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo (String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getStock(){
        return stock;
    }

    public void setStock (int stock){
        this.stock = stock;
    }

    public String getTematica(){
        return tematica;
    }
    public void setTematica(String tematica){
        this.tematica = tematica;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return stock == libro.stock && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(tematica, libro.tematica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, stock, tematica);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", stock=" + stock +
                ", tematica='" + tematica + '\'' +
                '}';
    }
}
