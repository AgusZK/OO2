package ejercicio07;

public class CreadorProducto2 extends Creador{
    @Override
    public ProductoFinanciero crearProducto() {
        ProductoCombinado p2 = new ProductoCombinado();
        p2.add(new BonoBajoRiesgo(72));
        p2.add(new CompraDolares());
        p2.add(new PlazoFijo(35,0.05));
        p2.add(new CompraPesos());

        return p2;
    }
}
