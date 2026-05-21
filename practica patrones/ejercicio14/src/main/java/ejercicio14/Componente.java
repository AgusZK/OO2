package ejercicio14;

public class Componente {
    private String nombre;
    private String descripcion;
    private double precio;
    private double consumo;

    public Componente(String nombre, String descripcion, double precio, double consumo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.consumo = consumo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getConsumo() {
        return consumo;
    }
}
