## 1.1 Protocolo de Cliente
#### La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo?

```java
/* Retorna el límite de crédito del cliente */
public double lmtCrdt() {}
/* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2*/
protected double mtFcE(LocalDate f1, LocalDate f2) {}
/*
Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
 */
private double mtCbE(LocalDate f1, LocalDate f2) {}
```
- Reemplazar nombres de metodos (Rename Method) para hacerlos mas explicativos
    ```java
        public double getLimiteDeCredito() {}
        protected double getMontoFacturado(LocalDate f1, LocalDate f2) {}
        private double getMontoCobrado(LocalDate f1, LocalDate f2) {}
    ```
- Modificar nombres de parametros con nombres mas descriptivos
    ```java
        public double getLimiteDeCredito() {}
        protected double getMontoFacturado(LocalDate fechaInicio, LocalDate fechaFin) {}
        private double getMontoCobrado(LocalDate fechaInicio, LocalDate fechaFin) {}
    ```
## 1.2 Participacion en proyectos
#### Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.
![Diagrama de Clases](https://i.imgur.com/WoTPRwE.png)
- La variable id en la clase persona es publica y deberia ser privada para no romper encapsulamiento (Encapsulate Field)
- Se movio el metodo participa a la clase Proyecto lo cual es correcto para seguir el paradigma de delegacion y que la Persona no haga envidia de atributo y lo verifique ella misma (Feature Envy)

## 1.3 Calculos
#### Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse
```java
    public void imprimirValores() {
        int totalEdades = 0;
        double promedioEdades = 0;
        double totalSalarios = 0;
    
        for (Empleado empleado : personal) {
            totalEdades = totalEdades + empleado.getEdad();
            totalSalarios = totalSalarios + empleado.getSalario();
        }
        promedioEdades = totalEdades / personal.size();
    
        String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        promedioEdades, totalSalarios);
    
        System.out.println(message);
    }
```
- Renombrar metodo (Rename Method) a algo como "imprimirPromedioEdades" para que describa lo que hace de forma mas clara
- Reemplazar el uso de for por streams (Replace Loop with Pipeline), eliminar totalEdades, promedioEdades y totalSalarios ya que son redundantes y se calculan previamente
    ```java
        public void imprimirValores() {
            double totalEdades = this.personal.stream().mapToDouble(e -> e.getEdad()).average().orElse(0);
            double totalSalarios = this.personal.stream().mapToDouble(e -> e.getSalario()).sum();
    
            String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
    
            System.out.println(message);
        }
    ```
- Delegar la tarea de calculo de edades (Long Method) y salarios a otros metodos para que imprimirValores no haga tantas cosas
    ```java
       public void imprimirValores() {
            double totalEdades = this.calcularEdades();
            double totalSalarios = this.calculaSalarios();
        
            String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
        
            System.out.println(message);
        }
            
       public double calcularEdades(){
           return this.personal.stream().mapToDouble(e -> e.getEdad()).average().orElse(0);
       }
  
       public double calcularSalarios(){
           return this.personal.stream().mapToDouble(e -> e.getSalario()).sum();
        }
    ```