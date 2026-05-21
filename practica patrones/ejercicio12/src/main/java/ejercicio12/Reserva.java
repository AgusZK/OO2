package ejercicio12;

import java.time.LocalDate;

public class Reserva {
    private int cantidadDias;
    private LocalDate fecha;
    private Usuario conductor;
    private AutoEnAlquiler auto;

    public Reserva(int cantidadDias, LocalDate fecha, Usuario conductor, AutoEnAlquiler auto) {
        this.cantidadDias = cantidadDias;
        this.fecha = fecha;
        this.conductor = conductor;
        this.auto = auto;
    }

    public double montoAPagar(){
        return auto.getPrecioPorDia() * this.cantidadDias;
    }

    public double montoAReembolsar(LocalDate fecha){
        return this.auto.montoAReembolsar(this.fecha, fecha, this.montoAPagar());
    }
}
