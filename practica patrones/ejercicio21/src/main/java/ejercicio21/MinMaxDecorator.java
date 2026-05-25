package ejercicio21;

public class MinMaxDecorator extends WeatherDecorator{

    public MinMaxDecorator(WeatherData component) {
        super(component);
    }

    public String displayData(){
        String data = super.toString();
        double min = this.getTemperaturas().stream().mapToDouble(t -> t.doubleValue()).min().orElse(0);
        double max = this.getTemperaturas().stream().mapToDouble(t -> t.doubleValue()).max().orElse(0);
        return data + "Minimo: " + min + "Maximo: " + max;
    }
}
