package ejercicio09;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int estreno;
    private List<Pelicula> similares;
    private double puntaje;

    public Pelicula(String titulo, int estreno, double puntaje){
        this.titulo = titulo;
        this.estreno = estreno;
        this.similares = new ArrayList<Pelicula>();
        this.puntaje = puntaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEstreno() {
        return estreno;
    }

    public List<Pelicula> getSimilares() {
        return similares;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void agregarSimilar(Pelicula p){
        if (!this.similares.contains(p)){
            this.similares.add(p);
            p.agregarSimilar(this);
        }
    }
}
