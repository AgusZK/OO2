import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("carlos");
    }

    @Test
    void testTwittearValido() {
        Post p = usuario.twittear("Hola");

        assertNotNull(p);
        assertEquals(1, usuario.getPosts().size());
        assertFalse(p.esRetweet());
    }

    @Test
    void testTwittearTextoVacio() {
        Post p = usuario.twittear("");

        assertNull(p);
        assertEquals(0, usuario.getPosts().size());
    }

    @Test
    void testTwittearTextoMuyLargo() {
        String texto = "a".repeat(281);

        Post p = usuario.twittear(texto);

        assertNull(p);
        assertEquals(0, usuario.getPosts().size());
    }

    @Test
    void testRetwittear() {
        Tweet original = new Tweet("Original");
        Post rt = usuario.retwittear(original);

        assertNotNull(rt);
        assertTrue(rt.esRetweet());
        assertEquals(1, usuario.getPosts().size());
    }

    @Test
    void testGetTweetsSoloOriginales() {
        Tweet t1 = new Tweet("Tweet 1");
        usuario.twittear("Tweet 2");
        usuario.retwittear(t1);

        assertEquals(1, usuario.getTweets().size());
    }

    @Test
    void testBorrarTweets() {
        usuario.twittear("Hola");
        usuario.twittear("Otro");

        usuario.borrarTweets();

        assertEquals(0, usuario.getPosts().size());
    }

    @Test
    void testCheckCaracteres() {
        assertTrue(usuario.checkCaracteres("Hola"));
        assertFalse(usuario.checkCaracteres(""));
        assertFalse(usuario.checkCaracteres("a".repeat(281)));
    }

    @Test
    void testGetScreenName() {
        assertEquals("carlos", usuario.getScreenName());
    }
}