package ejercicio02;

public class EmpleadoPlanta extends Empleado{
    private int hijos;
    private int antiguedad;
    private boolean casado;

    public EmpleadoPlanta (int hijos, int antiguedad, boolean casado){
        this.hijos = hijos;
        this.antiguedad = antiguedad;
        this.casado = casado;
    }

    public double sueldoBasico(){return 50000;}

    public double sueldoAdicional() {
        int adicional = 2000 * this.hijos + 2000 * this.antiguedad;
        return casado ? adicional + 5000 : adicional;
    }
}
