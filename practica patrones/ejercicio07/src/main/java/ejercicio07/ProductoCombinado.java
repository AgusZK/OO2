package ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class ProductoCombinado implements ProductoFinanciero {

    private List<ProductoFinanciero> productos;

    public ProductoCombinado(){
        this.productos = new ArrayList<ProductoFinanciero>();
    }

    public void add (ProductoFinanciero p){
        this.productos.add(p);
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return this.productos.stream().reduce(
                        montoInicial,
                        (monto, producto) -> producto.retornoInversion(monto),
                        (a, b) -> b
        );
    }
}
