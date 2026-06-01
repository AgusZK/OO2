## Ejercicio 4:  tcp.server.reply (B)
A partir del código compartido en teoría de tcp.server.reply.
i) Reimplementar el servidor PasswordServer empleando un enfoque basado en composición de objetos utilizando los componentes del framework tcp.server.reply vistos en teoría
```java
package tcp.server.reply;

import java.io.PrintWriter;
import java.security.SecureRandom;

public class PasswordHandler implements IMessageHandler {
    private SecureRandom random = new SecureRandom();
    
    @Override
    public void handleMessage(String message, PrintWriter out) {
        String[] args = message.split("\\s+");
        if (args.length != 3) {
            out.println("Enviar  3 argumentos");
            return;
        }
        String letters = args[0];
        String numbers = args[1];
        String specials = args[2];

        String password = generate(letters, numbers, specials);

        out.println(password);
    }

    private String generate(String letters, String numbers, String specials) {
        StringBuilder pwd = new StringBuilder();
        // 1 especial
        pwd.append(randomChar(specials));
        // 1 numero
        pwd.append(randomChar(numbers));
        // completar hasta 8 con letras
        while (pwd.length() < 8) {
            pwd.append(randomChar(letters));
        }
        return shuffle(pwd.toString());
    }

    private char randomChar(String s) {
        return s.charAt(random.nextInt(s.length()));
    }

    private String shuffle(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }
}
```
```java
import tcp.server.reply.*;

public class PasswordServerApp {
    
    public static void main(String[] args) {
        IMessageHandler handler = new PasswordHandler();
        IConnectionHandler conn = new SingleConnectionHandler(handler);
        new TCPControlLoop(conn).startLoop(args);
    }
}
```
ii) Modifique el framework para que la condición de cierre de una conexión sea configurable con strings provistos por las instanciaciones.
```java
public interface EndSessionPolicy {
    boolean shouldTerminate(String msg);
}

public class EmptyStringPolicy implements EndSessionPolicy {

    public boolean shouldTerminate(String msg) {
        return msg.equalsIgnoreCase("");
    }
}

public class KeywordEndSessionPolicy implements EndSessionPolicy {
    private String keyword;

    public KeywordEndSessionPolicy(String keyword) {
        this.keyword = keyword;
    }

    public boolean shouldTerminate(String msg) {
        return msg.equalsIgnoreCase(keyword);
    }
}

// Agregar private EndSessionPolicy policy en SingleConnectionHandler y MultiConnectionHandler 
// y reemplazar if (inputLine.equalsIgnoreCase("")) por if (policy.shouldTerminate(inputLine))
```
iii) Respecto a las dos formas vistas para implementar los servidores (PasswordServer ejercicio 1) iii) y 4) i) :
    ¿Qué debe hacer un desarrollador para extender el framework en cada una de las formas? Especifique qué clases debe subclasificar o implementar, qué métodos debe definir.
        -Ejercicio 1:
            -Subclasificar SingleThreadTCPServer, implementar handleMessage() y hooks opcionales
        -Ejercicio 4:
            -Implementar interfaz IMessageHandler, instanciar el framework en el main

    ¿Cuánto conocimiento necesita tener el desarrollador sobre la estructura interna del framework para instanciarlo? ¿Y para  extenderlo?
        -Ejercicio 1:
             -Requiere alto conocimiento del framework ya que debe saber sobre su ciclo de vida, realizar un template method y hooks disponibles
        -Ejercicio 4:
             -Requiere un bajo conocimiento, solo necesita saber que interfaz implementar y como instanciar el framework en el main

    ¿Qué técnica usarías si tuviera que ofrecer muchas configuraciones posibles para el servidor? ¿Por qué?
        -Utilizaria un strategy ya que se permitiria brindar muchas configuraciones posibles que pueden ser seleccionadas de forma dinamica al momento de querer instanciarlas o modificarlas

    Identifique los hotspots y frozen spots en cada una de las implementaciones.
        -Ejercicio 1
            -Hospots -> handleMessage() y hooks opcionales
            -FrozenSpots -> handleClient(), loop, manejo de sockets
        -Ejercicio 4
            -Hospots -> IMessageHandler, IConnectionHandler, EndSessionPolicy
            -FrozenSpots -> TCPControlLoop, threads

    Considerando las dos formas de implementación del servidor PasswordServer, los programadores pueden asegurar que hay inversión de control? Justifique su respuesta identificando en qué parte se produce la inversión de control en cada uno de los casos.
        -Si hay, en el ejercicio 1 ocurre cuando el framework controla el flujo (TCPServer -> handleClient() -> handleMessage()) y el usuario solo implementaria la parte del handleMessage
        -Y en el ejercicio 4 ocurre cuando el framework delega el comportamiento a otros objetos (TCPControlLoop -> ConnectionHandler -> MessageHandler) ya que sigue siendo del framework
