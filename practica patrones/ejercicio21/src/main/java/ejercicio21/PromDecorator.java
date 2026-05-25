package ejercicio21;

public class PromDecorator extends WeatherDecorator{
    public PromDecorator(WeatherData component) {
        super(component);
    }

    public String displayData(){
        String data = super.displayData();
        double promedio = this.getTemperaturas()
                .stream()
                .mapToDouble(t -> t.doubleValue())
                .average()
                .orElse(0);
        return data + "Promedio: " + promedio;
    }
}
