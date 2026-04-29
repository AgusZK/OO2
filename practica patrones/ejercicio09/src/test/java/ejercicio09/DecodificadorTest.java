package ejercicio09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecodificadorTest {
    private Decodificador deco;
    private Pelicula p1;
    private Pelicula p2;
    private Pelicula p3;
    private Pelicula p4;
    private Pelicula p5;
    private Pelicula p6;
    private Pelicula p7;
    private Pelicula p8;
    private Pelicula p9;
    private Pelicula p10;

    @BeforeEach
    void setUp() {
        p1 = new Pelicula("Ciudad de Sombras", 2001, 9.1);
        p2 = new Pelicula("Horizonte Rojo", 1998, 7.6);
        p3 = new Pelicula("Nebula", 2012, 7.9);
        p4 = new Pelicula("El Último Viaje", 1995, 8.8);
        p5 = new Pelicula("Eco del Pasado", 2005, 8.7);
        p6 = new Pelicula("Reino Perdido", 2003, 8.9);
        p7 = new Pelicula("Memorias de Hielo", 1993, 8.9);
        p8 = new Pelicula("Código Eclipse", 1999, 8.6);
        p9 = new Pelicula("Viaje Infinito", 2014, 8.5);
        p10 = new Pelicula("Fuego Interior", 2000, 8.4);
        // Similitudes
        p3.agregarSimilar(p6);
        p3.agregarSimilar(p9);
        p1.agregarSimilar(p4);
        p1.agregarSimilar(p10);
        p7.agregarSimilar(p5);
        // Decodificador
        deco = new Decodificador();
        deco.setCatalogo(List.of(
                p1, p2, p3, p4, p5,
                p6, p7, p8, p9, p10
        ));
        deco.setReproducidas(List.of(
                p1, p3, p5, p7
        ));
    }

    @Test
    void testSugerenciasPorSimilitud() {
        deco.setCriterio(new CriterioSimilaridad());
        List<Pelicula> sugeridas = deco.dameSugerencias();
        assertTrue(sugeridas.contains(p6));
        assertTrue(sugeridas.contains(p10));
        assertTrue(sugeridas.contains(p9));
    }

    @Test
    void testSugerenciasPorPuntaje() {
        deco.setCriterio(new CriterioPuntaje());
        List<Pelicula> sugeridas = deco.dameSugerencias();
        assertTrue(sugeridas.contains(p6));
        assertTrue(sugeridas.contains(p4));
        assertTrue(sugeridas.contains(p8));
    }
}