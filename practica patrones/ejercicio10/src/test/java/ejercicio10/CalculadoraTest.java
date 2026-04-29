package ejercicio10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    void testBase(){
        assertEquals("0.0", calculadora.getResultado());
        calculadora.setValor(3);
        assertEquals("3.0", calculadora.getResultado());
    }

    @Test
    void testSuma(){
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.setValor(8);
        assertEquals("18.0", calculadora.getResultado());
    }

    @Test
    void testResta(){
        calculadora.setValor(10);
        calculadora.menos();
        calculadora.setValor(9);
        assertEquals("1.0", calculadora.getResultado());
    }

    @Test
    void testMultiplicacion(){
        calculadora.setValor(10);
        calculadora.por();
        calculadora.setValor(5);
        assertEquals("50.0", calculadora.getResultado());
    }

    @Test
    void testDivision(){
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(5);
        assertEquals("2.0", calculadora.getResultado());
    }

    @Test
    void testDivisionPor0(){
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0);
        assertEquals("Error", calculadora.getResultado());
    }

    // Lo testeo 1 vez y abarca todos los estados (menos el testBorrar()
    // que testea que en Error no haga operaciones
    @Test
    void testOperacionEncadenada(){
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.setValor(5);
        calculadora.por();
        calculadora.setValor(10);
        assertEquals("150.0", calculadora.getResultado());
    }
    @Test
    void testOperacionIncompleta(){
        calculadora.setValor(10);
        calculadora.mas();
        assertEquals("Error", calculadora.getResultado());
    }
    @Test
    void testOperacionDoble(){
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.menos();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    void testBorrar(){
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0);
        calculadora.borrar();
        assertEquals("0.0", calculadora.getResultado());
    }

    @Test
    void testEstadoError(){
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0);
        calculadora.mas();
        calculadora.setValor(500);
        assertEquals("Error", calculadora.getResultado());
    }
}
