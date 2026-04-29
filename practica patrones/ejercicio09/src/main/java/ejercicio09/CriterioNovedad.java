package ejercicio09;

import java.util.List;

public class CriterioNovedad extends CriterioSugerencia{
    @Override
    public List<Pelicula> aplicarCriterio(Decodificador decodificador) {
        return decodificador
                .getCatalogo()
                .stream()
                .filter(p -> !decodificador.fueReproducida(p))
                .sorted((p1,p2) -> Integer.compare(p2.getEstreno(), p1.getEstreno()))
                .toList();
    }
}
