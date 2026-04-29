package ejercicio10;

public abstract class Operando implements Estado {
    @Override
    public void mas(Calculadora c) {
        c.setEstado( new Error());
    }

    @Override
    public void menos(Calculadora c) {
        c.setEstado(new Error());
    }

    @Override
    public void por(Calculadora c) {
        c.setEstado(new Error());
    }

    @Override
    public void dividido(Calculadora c) {
        c.setEstado(new Error());
    }


    @Override
    public String getResultado(Calculadora c) {
        c.setEstado(new Error());
        return "Error";
    }

    // Todas las subclases hacen setvalor de forma diferente
    // y luego la mandan a modo Base
    @Override
    public abstract void setValor(double valor, Calculadora c);
}
