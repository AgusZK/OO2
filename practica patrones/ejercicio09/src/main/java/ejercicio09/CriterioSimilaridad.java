package ejercicio09;

import java.util.List;

public class CriterioSimilaridad extends CriterioSugerencia{
    @Override
    public List<Pelicula> aplicarCriterio(Decodificador decodificador) {
        return decodificador
                .getReproducidas()
                .stream()
                // Sin el flatmap no anda
                .flatMap(p -> p.getSimilares().stream())
                .distinct()
                .sorted((p1,p2) -> Integer.compare(p2.getEstreno(), p1.getEstreno()))
                .toList();
    }
}
