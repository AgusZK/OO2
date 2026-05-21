package ejercicio12;

import java.time.LocalDate;

public class PoliticaEstricta implements  PoliticaDeCancelacion{
    @Override
    public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancel, double monto) {
        return 0;
    }
}
