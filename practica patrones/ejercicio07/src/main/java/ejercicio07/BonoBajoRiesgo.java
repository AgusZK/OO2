package ejercicio07;

public class BonoBajoRiesgo implements ProductoFinanciero{
    private int parking;

    public BonoBajoRiesgo (int parking){
        this.parking = parking;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return montoInicial * 1.10;
    }
}
