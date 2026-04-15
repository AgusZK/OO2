package ejercicio02;

public abstract class Empleado {
    public double sueldo(){
        return this.sueldoBasico() + this.sueldoAdicional() - this.descuento();
    }

    public abstract double sueldoBasico();
    public abstract double sueldoAdicional();

    public double descuento(){
        return this.sueldoBasico() * 0.13 + this.sueldoAdicional() * 0.05;
    }
}
