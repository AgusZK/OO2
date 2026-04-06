package ejercicio05;

public class Hotel {
    private double nightPrice;
    private double discountRate;

    public Hotel(double nightPrice, double discountRate) {
        this.nightPrice = nightPrice;
        this.discountRate = discountRate;
    }

    /* 5) Delego la tarea de calcular su precio al hotel en vez de que lo calcule HotelStay con Envidia de atributo */
    public double price( TimePeriod period) {
        return period.duration() * this.nightPrice * this.discountRate();
    }

    public double discountRate() {
        return this.discountRate;
    }
}
