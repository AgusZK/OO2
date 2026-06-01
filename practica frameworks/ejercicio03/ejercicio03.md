Ejercicio 3: Extensión de Frameworks  
Dado el documento “Plantillas y ganchos con herencia y composición” que se encuentra en la plataforma cátedras en esta URL. Lea el material provisto y responda:

1) Respecto a la primera propuesta, hotspots con herencia:

Responda las siguientes preguntas:
¿Qué debo hacer si aparece una nueva fuente de energía (por ejemplo, paneles solares con baterías)? ¿Cuántas y cuáles clases debo agregar en caso de querer todas las variantes de robots posibles para este nuevo tipo de fuente de energía?
    -Si aparece una nueva fuente de energia deberias crear 2 clases por cada tipo de locomocion del Robot, es decir, 4 en total siendo estas:
            SolarCaterpillarRobotWithBombs
            SolarCaterpillarRobotWithLasers
            SolarOvercraftRobotWithBombs
            SolarOvercraftRobotWithLasers
¿Puedo cambiarle, a un robot existente, el sistema de armas sin tener que instanciar el robot de nuevo?
    -No se puede, el robot se instancia con su arma laser o bomba
¿Dónde almacenaría usted el nivel de carga de la batería? ¿Qué implicaría eso sí antes de disparar el láser hay que garantizar que la fuente de energía puede satisfacer el consumo del arma?
    -Haria un interface en el que cada robot aplica el metodo de consumo de energia garantizando que la fuente de energia pueda satisfacer el consumo del arma
Implemente en Java, reutilizando el código provisto, lo necesario para satisfacer el punto a. Luego, agregue un nuevo ejemplo de uso del framework instanciando uno de los robots con la nueva fuente de energía.
```java
package ar.edu.unlp.info.oo2.rw.model;

// Creo interfaz de fuente de energia
public interface EnergySource {
    void consumeBattery(String robotName);
}

// Implementacion de energia nuclear
public class NuclearEnergy implements EnergySource {

    @Override
    public void consumeBattery(String robotName) {

        System.out.println(
                "Robot " + robotName + " using nuclear energy"
        );
    }
}

// Implementacion de energia solar
public class SolarEnergy implements EnergySource {

    @Override
    public void consumeBattery(String robotName) {
        System.out.println(
                "Robot " + robotName + " using solar batteries"
        );
    }
}

// Agrego fuente de energia al robot y deja de ser abstracto
public class Robot{
    private EnergySource energySource;
    public Robot(String name, EnergySource energySource) {
        this.name = name;
        this.energySource = energySource;
    }
}

// Lo mismo con el nuclear, ahora tiene fuente de energia
public abstract class NuclearRobot extends Robot {

    public NuclearRobot(String name) {
        super(name, new NuclearEnergy());
    }
}

// Creo el solar y tambien le pones fuente de energia
public abstract class SolarRobot extends Robot {

    public SolarRobot(String name) {
        super(name, new SolarEnergy());
    }
}

// Instancias una variante solar con laser
public class SolarOvercraftRobotWithLasers extends SolarRobot {
    public SolarOvercraftRobotWithLasers(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(
                "Robot " + getName() + " moving on overcraft"
        );
    }

    @Override
    public void fireArms() {
        System.out.println(
                "Robot " + getName() + " firing lasers"
        );
    }
}
```

2) Respecto a la sección Hotspots por composición:
   Responda las siguientes preguntas:
   ¿Qué debo hacer si aparece una nueva fuente de locomoción (por ejemplo, motor con ruedas con tracción 4x4)? ¿Cuántas y cuáles clases debo agregar en caso de querer todas las variantes de robots posibles para este nuevo tipo de sistema de locomoción?
        -Agregas una nueva subclase de Locomotion y listo
   ¿Puedo cambiarle, a un robot existente, el sistema de armas sin tener que instanciar el robot de nuevo?
        -El robot ahora tiene el Arma en la v.i, por lo que con un Setter podrias cambiarle el arma sin necesidad de instanciar un nuevo robot
   ¿Dónde almacenaría usted el nivel de carga de la batería? ¿Qué implicaría eso sí antes de disparar el láser hay que garantizar que la fuente de energía puede satisfacer el consumo del arma?
        -Lo almacenaria en EnergySource igual que antes, solo que ahora es una clase abstracta y deberias consultar con un metodo a la fuente de energia antes de disparar
   Implemente en Java, reutilizando el código provisto, lo necesario para satisfacer el punto a. Luego, agregue un nuevo ejemplo de uso del framework instanciando uno de los robots con la nueva forma de locomoción.
```java
package ar.edu.unlp.info.oo2.rw.model;

public class FourByFour extends Locomotion {

    @Override
    public void move(Robot r) {
        System.out.println(
            "Robot " + r.getName()
            + " moving with 4x4 traction");
    }
}

public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.add(
                new Robot(
                        "RoadRunner",
                        new FourByFour(),
                        new SolarPanel(),
                        new LasersSystem()
                )
        );

        board.runForCicles(5);
    }
}
```
3) Explique las ventajas y desventajas de las dos formas de extensión del framework (herencia y composición).
    -Extension por herencia:
      -Ventajas -> Es mas simple de entender y de implementar y la logica se basa en una jerarquia
                -> Comportamiento comun compartido en las clases base

      -Desventajas -> Cada nueva incorporacion requiere multiples creaciones de clases para satisfacer la necesidad
                   -> Rigidez, no podes cambiar comportamiento ni caracteristiscas en tiempo de ejecucion, un robot nace y muere con lo que se le instancia

    -Extension por composicion:
      -Ventajas -> Menos acoplamiento, agregar una nueva arma locomocion o energia solo necesita de una sola clase nueva
                -> No se repiten combinaciones de clases para satisfacer la necesidad de una nueva incorporacion
                -> No hay rigidez, se pueden cambiar comportamientos/armas/lo que vos quieras de forma dinamica

      -Desventajas -> Mayor cantidad de clases al inicio
                   -> Puede llegar a ser confuso si esta mal diseniado