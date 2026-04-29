package ejercicio10;

public class Suma extends Operando{
    @Override
    public void setValor(double valor, Calculadora c){
        c.setValorAcumulado(c.getValor() + valor);
        c.setEstado(new Base());
    }
}
