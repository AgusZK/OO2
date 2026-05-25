package ejercicio21;

import java.util.List;
import java.util.stream.Collectors;

public class CelsiusDecorator extends WeatherDecorator{
    public CelsiusDecorator (WeatherData component){
        super(component);
    }
    public double getTemperatura(){
        return (super.getTemperatura() - 32) / 1.8;
    }

    public List<Double> getTemperaturas(){
        return this.getTemperaturas().stream()
                .map(t -> (t-32)/1.8)
                .collect(Collectors.toList());
    }

    public String displayData() {
        return "Temperatura C: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }
}
