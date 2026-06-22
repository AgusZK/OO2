import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    Match piedra = new Piedra();
    Match papel = new Papel();
    Match tijera = new Tijera();
    Match lagarto = new Lagarto();
    Match spock = new Spock();

    @Test
    void testPiedra() {
        assertEquals("Empate", piedra.jugarContra(piedra));
        assertEquals("Gana papel", piedra.jugarContra(papel));
        assertEquals("Gana piedra", piedra.jugarContra(tijera));
        assertEquals("Gana piedra", piedra.jugarContra(lagarto));
        assertEquals("Gana spock", piedra.jugarContra(spock));
    }

    @Test
    void testPapel() {
        assertEquals("Gana papel", papel.jugarContra(piedra));
        assertEquals("Empate", papel.jugarContra(papel));
        assertEquals("Gana tijera", papel.jugarContra(tijera));
        assertEquals("Gana lagarto", papel.jugarContra(lagarto));
        assertEquals("Gana papel", papel.jugarContra(spock));
    }

    @Test
    void testTijera() {
        assertEquals("Gana piedra", tijera.jugarContra(piedra));
        assertEquals("Gana tijera", tijera.jugarContra(papel));
        assertEquals("Empate", tijera.jugarContra(tijera));
        assertEquals("Gana tijera", tijera.jugarContra(lagarto));
        assertEquals("Gana spock", tijera.jugarContra(spock));
    }

    @Test
    void testLagarto() {
        assertEquals("Gana piedra", lagarto.jugarContra(piedra));
        assertEquals("Gana lagarto", lagarto.jugarContra(papel));
        assertEquals("Gana tijera", lagarto.jugarContra(tijera));
        assertEquals("Empate", lagarto.jugarContra(lagarto));
        assertEquals("Gana lagarto", lagarto.jugarContra(spock));
    }

    @Test
    void testSpock() {
        assertEquals("Gana spock", spock.jugarContra(piedra));
        assertEquals("Gana papel", spock.jugarContra(papel));
        assertEquals("Gana spock", spock.jugarContra(tijera));
        assertEquals("Gana lagarto", spock.jugarContra(lagarto));
        assertEquals("Empate", spock.jugarContra(spock));
    }
}
