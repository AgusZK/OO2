package ejercicio10;

public class Division extends Operando{
    @Override
    public void setValor(double valor, Calculadora c) {
        if (valor == 0){
            c.setEstado(new Error());
        } else {
            c.setValorAcumulado(c.getValor() / valor);
            c.setEstado(new Base());
        }
    }
}
