package ejercicio12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaDeCancelacion{

    @Override
    public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancel, double monto) {
        long dias = ChronoUnit.DAYS.between(fechaCancel,fechaInicio);
        if (dias >= 7){
            return monto;
        }
        if (dias >= 2){
            return monto * 0.5;
        }
        else {
            return 0;
        }
    }
}
