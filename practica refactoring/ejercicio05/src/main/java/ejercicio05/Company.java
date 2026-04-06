package ejercicio05;

public class Company {
    private final double price;
    private final double promotionRate;

    public Company(double price, double promotionRate) {
        this.price = price;
        this.promotionRate = promotionRate;
    }

    /* 5) Delego la tarea de calcular su precio a Company en vez de que lo calcule CarRental con Envidia de atributo */
    public double price() {
        return this.price * this.promotionRate();
    }

    public double promotionRate() {
        return this.promotionRate;
    }
}
