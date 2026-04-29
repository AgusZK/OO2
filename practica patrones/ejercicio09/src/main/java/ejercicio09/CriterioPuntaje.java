package ejercicio09;

import java.util.Comparator;
import java.util.List;

public class CriterioPuntaje extends CriterioSugerencia{
    @Override
    public List<Pelicula> aplicarCriterio(Decodificador decodificador) {
        return decodificador.getCatalogo()
                .stream()
                .sorted(Comparator.comparing(Pelicula::getPuntaje).reversed()
                        .thenComparing(Pelicula::getEstreno, Comparator.reverseOrder()))
                .toList();
    }

}
