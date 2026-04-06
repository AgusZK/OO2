package ejercicio05;

public class HotelStay extends Product {
    /* 2) Rename field del campo cost -> quote del metodo priceFactor
        -Por consecuencia se tiene que modificar en la v.i y constructor
        -Es necesario modificar el test de acceso a .cost a .quote ya que es publica
        y no usa un getter para accederla
     */
    public double quote;
    /*private TimePeriod timePeriod; LO ELIMINO PORQUE LO SUBO A PRODUCT (3)) */
    private Hotel hotel;

    /* 3 y 4) Se quiere hacer un pull up method para subir tanto startDate como endDate (ambos metodos compartidos por 2 clases diferentes)
    a producto , para eso se debe mover a producto los atributos compartidos y que las subclases hereden comportamiento y atributos
    modificando al constructor y eliminando los metodos de las subclases, ya que van a estar en la super clase */

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
        this.quote = cost;
        this.hotel = hotel;
    }

    /* LOS ELIMINO PORQUE SUBEN A PRODUCTO CON EL PULL UP METHOD
    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }
    */

    public double priceFactor() {
        return this.quote / this.price();
    }

    /* 5)
        -Este metodo price() tiene code smells de envidia de atributo ya que la clase HotelStay usa los datos de hotel
        y esto no deberia ser asi
        public double price() {
            return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
        }

        -Creo un nuevo metodo en el que le paso el periodo del Stay y el mismo hotel se encarga de calcular su precio
    */
    public double price(){
        return this.hotel.price(this.timePeriod);
    }

}
