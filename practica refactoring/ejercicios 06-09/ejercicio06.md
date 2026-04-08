## Ejercicio 6
#### Para cada una de las siguientes situaciones, realice en forma iterativa los siguientes pasos:
##### (i) indique el mal olor,
##### (ii) indique el refactoring que lo corrige,
##### (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda).
##### Si vuelve a encontrar un mal olor, retorne al paso (i).
### 6.1 Empleados
```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
    return this.sueldoBasico
        (this.horasTrabajadas * 500);
        (this.cantidadHijos * 1000) 
        (this.sueldoBasico * 0.13);
    }
}
```
```java
public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
            }
    }

public class EmpleadoPasante extends Empleado {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
- <u>Malos olores detectados</u>:
    - Duplicate code, nombre, apellido y sueldo basico estan repetidos en todas las clases, siendo los 2 primeros v.i y el ultimo un metodo. Se deberia crear una superclase Empleado que contenga atributos y comportamiento comunes para que las subclases los hereden y eliminen el codigo/comportamiento duplicado. Ademas genero un metodo nuevo para el descuento aplicado a todos los empleados, evitando el hardcodeo.
    - Encapsulate Field, todas las v.i de todas las clases estan en publico, lo que rompe encapsulamiento. Se debe cambiar a private
- <u>Codigo correspondiente</u>:
    ```java
    public abstract class Empleado {
        private String nombre;
        private String apellido;
        private double sueldoBasico = 0;

        public double descuento (){
            return this.sueldoBasico * 0.13;
        }
    
        public abstract double sueldo();
    }
    ```
    ```java
    public class EmpleadoTemporario extends Empleado {
        private double horasTrabajadas = 0;
        private double cantidadHijos = 0;

        public double sueldo(){
            return this.sueldoBasico + (this.horasTrabajadas * 500) 
            + (this.cantidadHijos * 1000) - (this.descuento());
        }
    }
    ```
    ```java
    public class EmpleadoPlanta extends Empleado {
        private double cantidadHijos = 0;

        public double sueldo(){
            return this.sueldoBasico + (this.cantidadHijos * 2000) - this.descuento();
        }
    }
    ```
    ```java
    public class EmpleadoPasante extends Empleado {
        public double sueldo(){
            return this.sueldoBasico - this.descuento();
        }
    }
    ```
  
### 6.2 Juegos
```java
    public class Juego {
        // ......
        public void incrementar(Jugador j) {
            j.puntuacion = j.puntuacion + 100;
        }
        public void decrementar(Jugador j) {
            j.puntuacion = j.puntuacion - 50;
        }
    }
    
    public class Jugador {
        public String nombre;
        public String apellido;
        public int puntuacion = 0;
    }
```
- <u>Malos olores detectados</u>:
    - Feature envy, la clase Juego modifica directamente la variable puntuacion de la clase Jugador y ademas esta no esta protegida ya que esta en publico. Se debe crear un metodo para incrementar y decrementar en la clase jugador que modifique esta v.i y en los metodos de la clase Juego llamar a los mismos, evitando envidia de atributo.
    - Encapsule field, las v.i de Jugador estan declaradas publicas, se deben poner en private.
- <u>Codigo correspondiente</u>:
```java
    public class Juego {
        // ......
        public void incrementar(Jugador j) {
            j.incrementar();
        }
        public void decrementar(Jugador j) {
            j.decremntar();
        }
    }
    public class Jugador {
        private String nombre;
        private String apellido;
        private int puntuacion = 0;
        
        public void incrementar(){
            this.puntuacion += 100;
        }
        
        public void decremntar(){
            this.puntuacion -= 50;
        }
    }
```

### 6.3 Publicaciones
![UML](https://i.imgur.com/r7P85xA.png)
```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
        
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
        
   // ordena los posts por fecha
   for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
       int masNuevo = i;
       for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
           if (postsOtrosUsuarios.get(j).getFecha().isAfter(
     postsOtrosUsuarios.get(masNuevo).getFecha())) {
              masNuevo = j;
           }    
       }
      Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
      postsOtrosUsuarios.set(masNuevo, unPost);    
   }
        
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() &&  index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```
- <u>Malos olores detectados</u>:
    - Featury envy, PostApp sabe mucho sobre Post con getUsuario().getFecha(). Deberia delegar el filtro a Post
    - Replace Loop With Pipeline/reinventar la rueda, Implementar un sort con streams en lugar de recorrerlo con los for, tanto para la lista de posts de otros usuarios/ordenamiento de esa lista y tambien para el filtrado de los ultimos N posts
- <u>Codigo correspondiente</u>:
    ```java
        // ASUMO QUE HAY UNA LISTA DE POSTS llamada "posts" como en el ejemplo
        private List<Post> postsDeOtrosUsuarios(Usuario user) {
            return this.posts.stream().filter(post -> !post.esDe(user))
                    .sorted((p1, p2) -> p2.getFecha().compareTo(p1.getFecha()))
                    .toList();
        }
    
        public List<Post> ultimosPosts(Usuario user, int cantidad) {
            return postsDeOtrosUsuarios(user).stream()
                    .limit(cantidad)
                    .toList();
        }
    
    ```

### 6.4 Carrito de compras
![UML](https://i.imgur.com/29xymw9.png)
```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream()
        .mapToDouble(item -> 
        item.getProducto().getPrecio() * item.getCantidad())
        .sum();
    }
}
```
- <u>Malos olores detectados</u>:
    - Feature envy, la clase Carrito sabe mucho de Item y de su Producto ya que le pide a cada uno de sus Items su getProducto().getPrecio y eso deberia ser delegado a ItemCarrito con un metodo. Se debe modificar tambien el stream de la clase Carrito una vez implementado el mismo.
- <u>Codigo correspondiente</u>:
    ```java
    public class Producto {
        private String nombre;
        private double precio;
        
        public double getPrecio() {
            return this.precio;
        }
    }
    
    public class ItemCarrito {
        private Producto producto;
        private int cantidad;
            
        public Producto getProducto() {
            return this.producto;
        }
        
        public int getCantidad() {
            return this.cantidad;
        }
  
        public double total(){
            return this.producto.getPrecio() * this.getCantidad();
        } 
    
    }
    
    public class Carrito {
        private List<ItemCarrito> items;
        
        public double total() {
            return this.items.stream()
            .mapToDouble(item -> item.total())
            .sum();
        }
    }
    ```

### 6.5 Envio de pedidos
![UML](https://i.imgur.com/3LhXCuA.png)
```java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
       String notificacion = MessageFormat.format(
               "Estimado cliente, se le informa que hemos recibido su pedido con número {0}, " +
                       "el cual será enviado a la dirección {1}",
               nroPedido,
               cliente.getDireccionFormateada()
       );

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}

public class Cliente {
    public String getDireccionFormateada() {
        return this.direccion.getLocalidad() + ", " +
                this.direccion.getCalle() + ", " +
                this.direccion.getNumero() + ", " +
                this.direccion.getDepartamento();
    }
}
```
- <u>Malos olores detectados</u>:
    - Feature envy, la clase Cliente arma toda la direccion con sus atributos y eso se deberia delegar a la clase Direccion que actualmente no esta declarada.
    - Long method, se podria hacer que el armado del mensaje y la notificacion del pedido esten en metodos separados
- <u>Codigo correspondiente</u>:
    ```java
    public class Supermercado {
       public String armarMensaje (long nroPedido, Cliente cliente){
            String notificacion = MessageFormat.format(
            "Estimado cliente, se le informa que hemos recibido su pedido con número {0}, " +
            "el cual será enviado a la dirección {1}",
            nroPedido,
            cliente.getDireccionFormateada()
            );
       }
  
       public void notificarPedido(long nroPedido, Cliente cliente) {
            String mensaje = armarMensaje(nroPedido, cliente);
            System.out.println(mensaje);
       }
    }
    
    public class Cliente {
       private Direccion direccion;
       public String getDireccionFormateada() {
        return 
            this.direccion.toString();
        }
    }
  
    public class Direccion{
        private String localidad;
        private String calle;
        private String numero;
        private String departamento;
  
        public String toString(){
            return this.localidad + ", " + this.calle + ", " + this.numero 
            + ", " + this.departamento;
        }
    }
    ```