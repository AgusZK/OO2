package ejercicio07;

public abstract class Creador {
    public abstract ProductoFinanciero crearProducto();
    public double ejecutarInversion(double montoInicial){
        return crearProducto().retornoInversion(montoInicial);
    }
}
