package ejercicio21;

import java.util.List;

public abstract class WeatherDecorator {
    private WeatherData component;
    public WeatherDecorator(WeatherData component){
        this.component = component;
    }

    public WeatherData getComponent() {return component;}
    public double getTemperatura(){ return this.component.getTemperatura();}
    public double getPresion() {return this.component.getPresion();}
    public double getRadiacionSolar() {return this.component.getRadiacionSolar();}
    public List<Double> getTemperaturas() {return this.component.getTemperaturas();}
    public String displayData(){ return this.component.displayData();}
}
