package ejercicio02;

public class EmpleadoTemporario extends Empleado{
    private int horasTrabajadas;
    private int hijos;
    private boolean casado;

    public EmpleadoTemporario (int horasTrabajadas, int hijos, boolean casado){
        this.horasTrabajadas = horasTrabajadas;
        this.hijos = hijos;
        this.casado = casado;
    }

    public double sueldoBasico(){
        return 20000 + (this.horasTrabajadas * 300);
    }

    public double sueldoAdicional(){
        return casado ? 5000 + 2000 * this.hijos : 2000 * this.hijos;
    }
}
