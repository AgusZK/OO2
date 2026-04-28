package ejercicio07;

public class CompraPesos implements ProductoFinanciero{
    @Override
    public double retornoInversion(double montoInicial) {
        return montoInicial * 0.99;
    }
}
