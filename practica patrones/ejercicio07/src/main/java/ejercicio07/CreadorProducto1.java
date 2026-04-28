package ejercicio07;

public class CreadorProducto1 extends Creador{
    @Override
    public ProductoFinanciero crearProducto() {
        ProductoCombinado p1 = new ProductoCombinado();
        p1.add(new CompraDolares());
        p1.add(new PlazoFijo(35, 0.05));
        p1.add(new CompraPesos());

        return p1;
    }
}
