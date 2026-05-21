package ejercicio12;

import java.time.LocalDate;

public interface PoliticaDeCancelacion {
    public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancel, double monto);
}
