package ejercicio07;

public class CompraDolares implements ProductoFinanciero{
    @Override
    public double retornoInversion(double montoInicial) {
        return montoInicial * 1.01;
    }
}
