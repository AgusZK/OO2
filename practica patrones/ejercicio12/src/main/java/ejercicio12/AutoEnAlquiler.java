package ejercicio12;

import java.time.LocalDate;

public class AutoEnAlquiler {
    private double precioPorDia;
    private int cantidadPlazas;
    private String marca;
    private PoliticaDeCancelacion politica;

    public AutoEnAlquiler(PoliticaDeCancelacion politica, String marca, int cantidadPlazas, double precioPorDia) {
        this.politica = politica;
        this.marca = marca;
        this.cantidadPlazas = cantidadPlazas;
        this.precioPorDia = precioPorDia;
    }

    public double getPrecioPorDia(){
        return this.precioPorDia;
    }

    public void setPolitica(PoliticaDeCancelacion politica){
        this.politica = politica;
    }

    public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancel, double monto){
        return this.politica.montoAReembolsar(fechaInicio, fechaCancel, monto);
    }
}

