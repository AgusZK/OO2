package ejercicio07;

public class CreadorProducto3 extends Creador{
    @Override
    public ProductoFinanciero crearProducto() {
        ProductoCombinado p3 = new ProductoCombinado();
        p3.add(new BonoAltoRiesgo(70));
        p3.add(new BonoBajoRiesgo(70));
        p3.add(new PlazoFijo(30,0.05));

        return p3;
    }
}
