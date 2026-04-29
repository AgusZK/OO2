package ejercicio10;

public class Error implements Estado {
    @Override
    public String getResultado(Calculadora c) {
        return "Error";
    }

    @Override
    public void mas(Calculadora c){}
    public void menos(Calculadora c){}
    public void dividido(Calculadora c){}
    public void setValor(double valor, Calculadora c){};
    public void por(Calculadora c) {}
}
