package ejercicio10;

public class Base implements Estado {
    @Override
    public void mas(Calculadora c) {
        c.setEstado(new Suma());
    }

    @Override
    public void menos(Calculadora c) {
        c.setEstado(new Resta());
    }

    @Override
    public void por(Calculadora c) {
        c.setEstado(new Multiplicacion());
    }

    @Override
    public void dividido(Calculadora c) {
        c.setEstado(new Division());
    }

    @Override
    public void setValor(double valor, Calculadora c) {
        c.setValorAcumulado(valor);
    }

    @Override
    public String getResultado(Calculadora c) {
        return Double.toString(c.getValor());
    }
}
