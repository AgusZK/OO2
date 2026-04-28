package ejercicio07;

public class CreadorProducto4 extends Creador{
    @Override
    public ProductoFinanciero crearProducto() {
        ProductoCombinado p4 = new ProductoCombinado();
        p4.add(new BonoAltoRiesgo(72));
        p4.add(new BonoAltoRiesgo(72));
        p4.add(new BonoAltoRiesgo(72));

        return p4;
    }
}
