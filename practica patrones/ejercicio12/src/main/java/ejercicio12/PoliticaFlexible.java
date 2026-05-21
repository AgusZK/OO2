package ejercicio12;

import java.time.LocalDate;

public class PoliticaFlexible implements  PoliticaDeCancelacion {
    @Override
    public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancel, double monto) {
        return monto;
    }
}
