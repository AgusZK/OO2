package ejercicio21;

import java.util.List;

public class HomeWeatherStation implements WeatherData {
    private double temperatura;
    private double presion;
    private double radiacion;
    private List<Double> listaTemps;

    //retorna la temperatura en grados Fahrenheit.
    public double getTemperatura(){
        return this.temperatura;
    }

    //retorna la presión atmosférica en hPa
    public double getPresion(){
        return this.presion;
    }

    //retorna la radiación solar
    public double getRadiacionSolar(){
        return this.radiacion;
    }

    //retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
    public List<Double> getTemperaturas(){
        return this.listaTemps;
    }

    //retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
    public String displayData(){
        return "Temperatura F: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }
}
