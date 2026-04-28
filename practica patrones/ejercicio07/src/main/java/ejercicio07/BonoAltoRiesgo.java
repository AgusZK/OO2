package ejercicio07;

public class BonoAltoRiesgo implements ProductoFinanciero{
    private int parking;

    public BonoAltoRiesgo (int parking){
        this.parking = parking;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return montoInicial * 1.70;
    }
}
