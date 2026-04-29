package ejercicio10;

public interface Estado {
    public void mas(Calculadora c);
    public void menos(Calculadora c);
    public void por(Calculadora c);
    public void dividido(Calculadora c);
    public void setValor(double valor, Calculadora c);
    public String getResultado(Calculadora c);
}
