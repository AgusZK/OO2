package ejercicio05;


public class CarRental extends Product {
    /* 1) Declaro cost como privada con Escapsulate Field
        a y b)
        El test falla ya que esta accediendo directamente a la variable porque
        en su momento era publica y podia hacerlo. El test deberia estar previamente hecho de forma
        correcta con un getter (ya declarado en las ultimas lineas)
        y no usar directamente la variable y te ahorrarias la modificacion
    * */

    private double cost;
    /*private TimePeriod timePeriod; LO ELIMINO PORQUE LO SUBO A PRODUCT (3)) */
    private Company company;

    /* 3 y 4 ) Se quiere hacer un pull up method para subir tanto startDate como endDate (ambos metodos compartidos por 2 clases diferentes)
    a producto , para eso se debe mover a producto los atributos compartidos y que las subclases hereden comportamiento y atributos
    modificando al constructor y eliminando los metodos de las subclases, ya que van a estar en la super clase */
    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        super(timePeriod);
        this.cost = cost;
        this.company = company;
    }

    /* LOS ELIMINO PORQUE SUBEN A PRODUCTO CON EL PULL UP METHOD
    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }
    */

    /* 5)
        -Este metodo tiene code smells de envidia de atributo ya que la clase CarRental usa datos de
        de la clase company, siendo que la logica deberia estar en esa clase
        public double price() {
            return this.company.price() * this.company.promotionRate();
        }
        -Creo un nuevo metodo que delega la tarea de calcular su precio a la company
    */

    public double price(){
        return this.company.price();
    }

    public double cost() {
        return this.cost;
    }
}
