package ejercicio09;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
    private List<Pelicula> catalogo;
    private List<Pelicula> reproducidas;
    private CriterioSugerencia criterio;

    public Decodificador (){
        this.catalogo = new ArrayList<Pelicula>();
        this.reproducidas = new ArrayList<Pelicula>();
    }

    public boolean fueReproducida(Pelicula p){
        return this.reproducidas.contains(p);
    }

    public List<Pelicula> dameSugerencias(){
        return this.criterio.getSugerencias(this);
    }

    public List<Pelicula> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Pelicula> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Pelicula> getReproducidas() {
        return reproducidas;
    }

    public void setReproducidas(List<Pelicula> reproducidas) {
        this.reproducidas = reproducidas;
    }


    public void setCriterio(CriterioSugerencia criterio) {
        this.criterio = criterio;
    }
}
