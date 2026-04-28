package ejercicio04;

import static org.junit.jupiter.api.Assertions.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TopografiaTest {
    Mixta mixta1;
    Mixta mixta2;
    Mixta mixta3;
    Mixta mixta4;
    Mixta mixta5;

    Hoja pantano1;
    Hoja pantano2;
    Hoja pantano3;

    @BeforeEach
    void setUp(){
        // Mixta del ejemplo (c)
        mixta1 = new Mixta();
        mixta1.add(new Hoja(1));
        mixta1.add(new Hoja(0));
        mixta1.add(new Hoja(0));
        mixta1.add(new Hoja(1));
        // Creo una igual para comparar
        mixta2 = new Mixta();
        mixta2.add(new Hoja(1));
        mixta2.add(new Hoja(0));
        mixta2.add(new Hoja(0));
        mixta2.add(new Hoja(1));
        // Creo una con las mismas partes en distinto orden
        mixta4 = new Mixta();
        mixta4.add(new Hoja(1));
        mixta4.add(new Hoja(1));
        mixta4.add(new Hoja(0));
        mixta4.add(new Hoja(0));
        // Ejemplo (d)
        mixta3 = new Mixta();
        mixta3.add(new Hoja(1));
        mixta3.add(new Hoja(0));
        mixta3.add(new Hoja(1));
        mixta3.add(mixta1);
        // Igual al D
        mixta5 = new Mixta();
        mixta5.add(new Hoja(1));
        mixta5.add(new Hoja(0));
        mixta5.add(new Hoja(1));
        mixta5.add(mixta1);

        // Pantano
        pantano1 = new Hoja(0.7);
        pantano2 = new Hoja(0.7);
        pantano3 = new Hoja (0.1);
    }

    @Test
    void testEquals(){
        // Mixtas iguales
        assertTrue(mixta1.equals(mixta2));
        assertTrue(mixta2.equals(mixta1));
        // Diferente
        assertFalse(mixta4.equals(mixta1));
        // Mixta recursiva
        assertTrue(mixta3.equals(mixta5));
        // Hoja vs Mixta y Hoja vs Hoja
        assertFalse (new Hoja(1).equals(mixta1));
        assertTrue (new Hoja(1).equals(new Hoja(1)));
        assertFalse (new Hoja(1).equals(new Hoja(0)));
        // Pantanos
        assertTrue (pantano1.equals(pantano2));
        assertFalse (pantano1.equals(pantano3));
        assertFalse (pantano1.equals(new Hoja(1)));
    }
}
