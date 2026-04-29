package ejercicio09;

import java.util.List;

public abstract class CriterioSugerencia {
    public abstract List<Pelicula> aplicarCriterio(Decodificador decodificador);

    public List<Pelicula> getSugerencias(Decodificador decodificador){
        return this.aplicarCriterio(decodificador)
                .stream()
                .filter(p -> !decodificador.fueReproducida(p))
                .limit(3)
                .toList();
    }
}
