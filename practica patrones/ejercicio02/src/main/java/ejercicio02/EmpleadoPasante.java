package ejercicio02;

public class EmpleadoPasante extends Empleado{
    private int examenes;

    public EmpleadoPasante (int examenes){
        this.examenes = examenes;
    }

    public double sueldoBasico(){ return 20000;}

    public double sueldoAdicional(){
        return 2000 * this.examenes;
    }
}
