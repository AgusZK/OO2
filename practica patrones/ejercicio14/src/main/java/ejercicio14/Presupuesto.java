package ejercicio14;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    private List<Componente> componentes;
    private String nombre;
    private LocalDate fecha;

    public Presupuesto(){
        this.fecha = LocalDate.now();
        this.componentes = new ArrayList<Componente>();
    }

    public void add (Componente comp){
        this.componentes.add(comp);
    }

    public void setProcesador(Componente comp){
        this.add(comp);
    }

    public void setRam(Componente comp){
        this.add(comp);
    }

    public void setDisco(Componente comp){
        this.add(comp);
    }

    public void setGrafica(Componente comp){
        this.add(comp);
    }

    public void setGabinete(Componente comp){
        this.add(comp);
    }

    public double calcularConsumo(){
        return this.componentes.stream()
                .mapToDouble(c -> c.getConsumo())
                .sum();
    }

    public double calcularPrecio(){
        return this.componentes.stream()
                .mapToDouble(c -> c.getPrecio())
                .sum();
    }
}
