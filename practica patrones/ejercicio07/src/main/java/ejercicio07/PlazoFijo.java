package ejercicio07;

public class PlazoFijo implements ProductoFinanciero{
    private int dias;
    private double interesDiario;

    public PlazoFijo(int dias, double interesDiario){
        this.dias = dias;
        this.interesDiario = interesDiario;
    }
    @Override
    public double retornoInversion(double montoInicial) {
        return montoInicial * Math.pow(1 + interesDiario, dias);
    }
}
