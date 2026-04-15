package ejercicio02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    private EmpleadoTemporario temporario;
    private EmpleadoPasante pasante;
    private EmpleadoPlanta planta;

    @BeforeEach
    void setUp() {
        temporario = new EmpleadoTemporario(10, 2, true);
        pasante = new EmpleadoPasante(3);
        planta = new EmpleadoPlanta(2, 5, true);
    }

    @Test
    void testEmpleadoTemporario() {
        double basico = 20000 + (10 * 300);
        double adicional = 5000 + (2 * 2000);
        double descuento = basico * 0.13 + adicional * 0.05;
        double esperado = basico + adicional - descuento;

        assertEquals(esperado, temporario.sueldo(), 0.01);
    }

    @Test
    void testEmpleadoPasante() {
        double basico = 20000;
        double adicional = 3 * 2000;
        double descuento = basico * 0.13 + adicional * 0.05;
        double esperado = basico + adicional - descuento;

        assertEquals(esperado, pasante.sueldo(), 0.01);
    }

    @Test
    void testEmpleadoPlanta() {
        double basico = 50000;
        double adicional = (2 * 2000) + (5 * 2000) + 5000;
        double descuento = basico * 0.13 + adicional * 0.05;
        double esperado = basico + adicional - descuento;

        assertEquals(esperado, planta.sueldo(), 0.01);
    }
}