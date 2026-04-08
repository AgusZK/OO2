## Ejercicio 7: Etiquetas
#### Observe el siguiente código:
```java
abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }
}

class EtiquetaSimple extends Etiqueta {
    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA BÁSICA ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio: $" + precio);
        System.out.println("-----------------------");
    }
}

class EtiquetaDetalle extends Etiqueta {
    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA DETALLE ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("Precio final: $" + precio);
        System.out.println("-----------------------");
    }
}
```
- Tareas:
  1) ¿Hay código duplicado? Indique claramente en qué líneas se encuentra.
     - Hay codigo duplicado en la linea 16-18 y 20 de la clase EtiquetaSimple y en la linea 29-31 y 34 de la clase EtiquetaDetalle
  2) Se quiere aplicar el refactoring Pull Up Method para subir el método generar() a la superclase Etiqueta. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
     - No se puede aplicar Pull-up Method debido a que ambos metodos tienen ligeras diferencias y una de las precondicions es que el metodo a subir tiene que ser identico en las N clases que lo contengan
  3) Mencione los refactorings previos necesarios para que sea posible aplicar Pull Up Method.
     - Se deberian sacar las partes que difieren del metodo generar() en las diferentes clases, creando metodos abstractos para que cada clase lo implemente a su forma
     - Se debe definir un metodo "molde" en la clase Etiqueta con comportamiento y estructura comun de las subclases, dejando afuera cosas especificas de cada una
     - Una vez que el metodo generar() se crea como metodo molde en la superclase, aplicar Pull-Up Method
  4) Aplique Pull Up Method para subir el método generar() a la superclase Etiqueta.
        ```java
        abstract class Etiqueta {
            protected String nombreProducto;
            protected double precio;
        
            public Etiqueta(String nombre, double precio) {
                this.nombreProducto = nombre;
                this.precio = precio;
            }
     
            public void generar(){
                this.imprimirEncabezado();
                System.out.println("Producto: " + this.nombreProducto);
                System.out.println("Precio: $" + this.precio);
                this.imprimirPie();
                System.out.println("-----------------------");
            }
     
            public abstract void imprimirEncabezado();
            public abstract void imprimirPie();
        }
        
        class EtiquetaSimple extends Etiqueta {
            public EtiquetaSimple(String nombre, double precio) {
                super(nombre, precio);
            }
        
            public void imprimirEncabezado(){
                System.out.println("--- ETIQUETA BÁSICA ---");
            }
            public void imprimirPie(){ 
                // Me quedaria vacio en esta clase porque solo detalle imprime precio con imp
                // Pero a futuro se podrian implementar mas etiquetas que si tengan pies diferentes
                // y deberian implementar este metodo
            }
        }
        
        class EtiquetaDetalle extends Etiqueta {
            public EtiquetaDetalle(String nombre, double precio) {
                super(nombre, precio);
            }
        
            public void imprimrEncabezado(){
                System.out.println("--- ETIQUETA DETALLE ---");
            }
     
            public void imprimrPie(){
                System.out.println("Precio sin Imp: " + (this.precio * 0.79));
            }
        }
        ```