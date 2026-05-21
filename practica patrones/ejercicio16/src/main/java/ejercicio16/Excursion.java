package ejercicio16;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Excursion {
    private Estado estado;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private double costo;
    private int cupoMinimo;
    private int cupoMaximo;
    private List<Usuario> inscriptos;
    private List<Usuario> esperando;

    public Excursion(Estado estado, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo, int cupoMinimo, int cupoMaximo, List<Usuario> inscriptos, List<Usuario> esperando) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puntoEncuentro = puntoEncuentro;
        this.costo = costo;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = inscriptos;
        this.esperando = esperando;
        this.estado = new Provisoria(this);
    }

    public void changeState(Estado estado){
        this.estado = estado;
    }

    public void agregarInscripto(Usuario u){
        this.inscriptos.add(u);
    }

    public void agregarAEspera(Usuario u){
        this.esperando.add(u);
    }

    public int faltasParaMinimo(){
        return this.cupoMinimo > this.inscriptos.size() ? this.cupoMinimo - this.inscriptos.size(): 0;
    }

    public int faltasParaMaximo(){
        return this.cupoMaximo > this.inscriptos.size() ? this.cupoMaximo - this.inscriptos.size(): 0;
    }

    public String mostrarMails(){
        return this.inscriptos.stream()
                .map(i -> i.getMail())
                .collect((Collectors.joining(",")));
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\n"
                + "Costo: " + this.costo + "\n"
                + "Fecha de Inicio: " + this.fechaInicio + "\n"
                + "Fecha de Fin: " + this.fechaFin + "\n"
                + "Punto de Encuentro: " + this.puntoEncuentro + "\n";
    }
}
