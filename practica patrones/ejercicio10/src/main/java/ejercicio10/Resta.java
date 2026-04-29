package ejercicio10;

public class Resta extends Operando{
    @Override
    public void setValor(double valor, Calculadora c) {
        c.setValorAcumulado(c.getValor() - valor);
        c.setEstado(new Base());
    }
}
