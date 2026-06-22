import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {

    private Twitter twitter;

    @BeforeEach
    void setUp() {
        twitter = new Twitter();
    }

    @Test
    void testCrearUsuario() {
        Usuario u = twitter.crearUsuario("juan");

        assertNotNull(u);
        assertEquals("juan", u.getScreenName());
        assertTrue(twitter.existeUsuario("juan"));
    }

    @Test
    void testNoCrearUsuarioDuplicado() {
        twitter.crearUsuario("juan");
        Usuario u2 = twitter.crearUsuario("juan");

        assertNull(u2);
        assertEquals(1, twitter.getUsuarios().size());
    }

    @Test
    void testExisteUsuario() {
        twitter.crearUsuario("ana");

        assertTrue(twitter.existeUsuario("ana"));
        assertFalse(twitter.existeUsuario("pedro"));
    }

    @Test
    void testEliminarUsuario() {
        Usuario u = twitter.crearUsuario("maria");

        twitter.eliminarUsuario(u);

        assertFalse(twitter.existeUsuario("maria"));
        assertEquals(0, twitter.getUsuarios().size());
    }

    @Test
    void testEliminarUsuarioBorraTweets() {
        Usuario u = twitter.crearUsuario("lucas");
        u.twittear("Hola");

        twitter.eliminarUsuario(u);

        assertEquals(0, u.getPosts().size());
    }

    @Test
    void testGetUsuariosDevuelveCopia() {
        twitter.crearUsuario("uno");

        var lista = twitter.getUsuarios();
        lista.clear();

        assertEquals(1, twitter.getUsuarios().size());
    }
}