## Ejercicio 5: StreamBeacons
El software StreamBeacons es una solución para procesar eventos en una aplicación. Su objetivo es desacoplar a quien genera un evento de quien lo procesa. Un componente puede producir un evento (por ejemplo, el resultado de una validación, la llegada de un mensaje, un error, o un cambio de estado), y otros componentes pueden reaccionar sin acoplamiento directo entre ellos.
Componentes de la solución
Evento (Event): representa un dato o mensaje que comunica que un suceso determinado ocurrió en el sistema.
Oyente (Listener): espera a que ocurran eventos y reacciona a estos. Define qué hacer cuando ocurre un Evento.
Despachador (Dispatcher): intermediario entre Eventos y Oyentes. Mantiene un registro de Oyentes y notifica a cada uno cuando ocurre un Evento.
```java
public interface BeaconEvent {
  public String getName();
  public LocalDateTime getTimestamp();
}

public class DefaultEvent implements BeaconEvent {
  private String name;
  private LocalDateTime timestamp = LocalDateTime.now();

  public String getName() {
    return this.name;
  }

  public LocalDateTime getTimestamp() {
    return this.timestamp;
  }
}

public interface BeaconListener {
  void onEvent(BeaconEvent event);
}

public interface BeaconDispatcher {
  void register(BeaconListener listener);
  void unregister(BeaconListener listener);
  void dispatch(BeaconEvent event);
  List<BeaconListener> getListeners();
}

public final class StreamBeacons {
  private BeaconDispatcher dispatcher = new DefaultDispatcher();

  public StreamBeacons() {}

  public void setDispatcher(BeaconDispatcher newDispatcher) {
    for (BeaconListener bl : this.dispatcher.getListeners()) {
      newDispatcher.register(bl);
    }
    this.dispatcher = newDispatcher;
  }

  public void registerListener(BeaconListener listener) {
    this.dispatcher.register(listener);
  }

  public void unregisterListener(BeaconListener listener) {
    this.dispatcher.unregister(listener);
  }

  public void emit(BeaconEvent event) {
    this.dispatcher.dispatch(event);
  }

  public void emit(String eventName) {
    BeaconEvent event = new DefaultEvent(eventName);
    dispatcher.dispatch(event);
  }
}

public class DefaultDispatcher implements BeaconDispatcher {
  private List<BeaconListener> listeners = new ArrayList<>();
  @Override
  public void register(BeaconListener listener) {
    this.listeners.add(listener);
  }

  @Override
  public void unregister(BeaconListener listener) {
    this.listeners.remove(listener);
  }
  @Override
  public void dispatch(BeaconEvent event) {
    for (BeaconListener bl : this.listeners) {
      try {
        bl.onEvent(event);
      } catch (Exception e) { /* Ignore exception */ }
    }
  }

    @Override
    public List<BeaconListener> getListeners() {
        return this.listeners;
    }
}

public class DoNotDisturbDispatcher implements BeaconDispatcher {
    private List<BeaconListener> listeners = new ArrayList<>();
    private Queue<BeaconEvent> queue = new LinkedList<>();
    private boolean paused = false;

    @Override
    public void register(BeaconListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregister(BeaconListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void dispatch(BeaconEvent event) {
        if (paused) {
            queue.add(event);
        } else {
            notifyListeners(event);
        }
    }

    @Override
    public List<BeaconListener> getListeners() {
        return this.listeners;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
        while (!queue.isEmpty()) {notifyListeners(queue.poll());
        }
    }

    private void notifyListeners(BeaconEvent event) {
        for (BeaconListener bl : listeners) {
            try {
                bl.onEvent(event);
            } catch (Exception e) { /* Ignore exception */ }
        }
    }
}
```
Tareas:
1) Indique si el diseño corresponde a un framework o a una librería. Justifique adecuadamente.
    -Es un framework, el usuario no controla el flujo de ejecucion ya que este mismo esta determinado por el sistema.
    -El usuario solo registra listeners, configura el dispatcher y emite eventos

2) Identifique si existe Inversión de Control. En caso afirmativo, indique dónde ocurre. Justifique claramente.
    -Hay inversion de control, ocurre en dispatcher.dispatch(event) y listener.onEvent(event),
      el usuario no llama a los listeners directamente, recibe un evento, lo despacha e invoca callbacks, el control del flujo lo tiene el FW

3) Cree un mecanismo para registrar en consola cada evento despachado, mostrando: nombre del evento, fecha y hora. Restricción: no se permite modificar el código provisto.
```java
public class LoggingDispatcher implements BeaconDispatcher {

    private BeaconDispatcher delegate;

    public LoggingDispatcher(BeaconDispatcher delegate) {
        this.delegate = delegate;
    }

    @Override
    public void register(BeaconListener listener) {
        delegate.register(listener);
    }

    @Override
    public void unregister(BeaconListener listener) {
        delegate.unregister(listener);
    }

    @Override
    public void dispatch(BeaconEvent event) {
        System.out.println( "Event: " + event.getName() + " | Time: " + event.getTimestamp());
        delegate.dispatch(event);
    }

    @Override
    public List<BeaconListener> getListeners() {
        return delegate.getListeners();
    }
}
```
4) Se desea que los Listeners reciban únicamente aquellos eventos que sean de su interés, evitando que reaccionen a eventos irrelevantes.
   a) Proponga una solución de diseño.
   b) Explique cómo un Listener determina qué eventos le interesan.
   c) ¿Considera que la solución es una extensión o una instanciación? Justifique.
   Nota: en caso de escribir código, puede indicar únicamente el código agregado o modificado.
```java
public interface FilteredListener extends BeaconListener {
    boolean supports(BeaconEvent event);
}

public class FilteringDispatcher implements BeaconDispatcher {
    private BeaconDispatcher delegate;

    public FilteringDispatcher(BeaconDispatcher delegate) {
        this.delegate = delegate;
    }

    @Override
    public void dispatch(BeaconEvent event) {
        for (BeaconListener l : delegate.getListeners()) {
            if (l instanceof FilteredListener) {
                if (((FilteredListener) l).supports(event)) {
                    l.onEvent(event);
                }
            } else {
                l.onEvent(event);
            }
        }
    }

    public void register(BeaconListener l) {
        delegate.register(l);
    }

    public void unregister(BeaconListener l) {
        delegate.unregister(l);
    }

    public List<BeaconListener> getListeners() {
        return delegate.getListeners();
    }
}
```

5) Indicar Verdadero o Falso y justificar en cada caso:
El método dispatch de BeaconDispatcher es un Template Method.
    -Falso, no define un metodo con una 'receta' es solo un metodo de estrategia
El método register es un método hook.
    -Falso, es obligatorio de la interfaz
El método onEvent constituye un hotspot.
    -Verdadero, para eso se extiende el sistema
La clase StreamBeacons no puede considerarse un frozenspot porque permite cambiar el BeaconDispatcher mediante el método setDispatcher.
    -Verdadero, puede cambiar comportamiento y al dispatcher de manera dinamic
El diseño no permite extender el comportamiento de BeaconDispatcher, por lo tanto, es de caja blanca.
    -Falso, podes extenderlo mediante interfaces como hice en el 4 y 3, es de caja negra
El uso de interfaces confirma que se trata de un diseño de caja negra.
    -Verdadero ya que ocultan implementacion y solo exponen comportamiento
Dado que DoNotDisturbDispatcher no hereda del DefaultDispatcher, se puede afirmar que es un diseño de caja negra.
    -Verdadero, al no heredar y usar composicion y ser independiente de una jerarquia lo hace un FW de caja negra
