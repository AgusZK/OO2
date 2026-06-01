## Ejercicio 1: SingleThreadTCPFramework
A partir del código compartido en teoría en llamado Material Framework Caja Blanca

1) Refactorizar el método SingleThreadTCPFramework::handleClient(Socket) para convertirlo en un Template Method. Este método debe incluir métodos hook opcionales, es decir, métodos hooks que pueden ser implementados por las subclases o no.
-Metodo original:
    ```java
        private final void handleClient(Socket clientSocket) {
            
            try (
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received message: " + inputLine + " from "
                            + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
                    
                    if (inputLine.equalsIgnoreCase("")) {
                        break; // Client requested to close the connection
                    }
                    handleMessage(inputLine, out);
                }
                System.out.println("Connection closed with " + clientSocket.getInetAddress().getHostAddress() + ":"
                        + clientSocket.getPort());
            } catch (IOException e) {
                System.err.println("Problem with communication with client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    ```
   
-Metodo con refactoring y hooks:
```java
        private final void handleClient(Socket clientSocket) {

    try (
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received message: " + inputLine + " from "
                    + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

            if (inputLine.equalsIgnoreCase("")) {
                break; // Client requested to close the connection
            }

            beforeHandleMessage(inputLine, clientSocket);

            handleMessage(inputLine, out);

            afterHandleMessage(inputLine, clientSocket);
        }
            onConnectionClosed(clientSocket);
        
    } catch (IOException e) {
        onCommunicationError(clientSocket, e);
    } finally {
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error closing socket: " + e.getMessage());
        }
    }

    // Hooks opcionales
    protected void onConnectionOpened(Socket clientSocket) {}

    protected void beforeHandleMessage(String message, Socket clientSocket) {}

    protected void afterHandleMessage(String message, Socket clientSocket) {}

    protected void onConnectionClosed(Socket clientSocket) {}

    protected void onCommunicationError(Socket clientSocket, IOException e) {
        System.err.println("Problem with communication with client: "
                + e.getMessage());
    }

    protected boolean shouldCloseConnection(String inputLine) {
        return inputLine.equalsIgnoreCase("");
    }
}
```

2) Extienda el framework para permitir que la “palabra” que produce el cierre de la sesión con un cliente sea configurable. Evalúe las siguientes cuatro alternativas e implemente la que considere más adecuada:
a) Una variable en SingleThreadTCPServer que se configura desde el método main() de las subclases.
b) Un método (hook) que retorna un booleano resultado de evaluar la condición.
c) Un método (hook) que retorna un String que es la palabra de término de sesión.
d) Una jerarquía de Strategies que implementan cada una de las condiciones de cierre de sesión.
Para ayudarlo en definir cuál sería la alternativa que considera más apropiada, puede usar los siguientes aspectos (pero no limitarse a):
Esfuerzo de implementación dentro del framework
Facilidad de uso para los programadores usuarios del framework
Limitaciones de la solución; es decir, que tan flexible es la alternativa elegida, ¿que casos de uso permite abarcar y cuales no podría?
```java
public interface SessionTerminationStrategy{
    public boolean terminate(String message);
}

public class EmptyLineStategy implements SessionTerminationStrategy{
    @Override
    public boolean terminate(String message){
        return message.isEmpty();
    }
}

public class WordStrategy implements SessionTerminationStrategy{
    private String keyword;
    
    public WordStrategy(String key){
        this.keyword = key;
    }
    
    @Override
    public boolean terminate(String message){
        return keyword.equals(message);
    }
}
```
```java
public abstract class SingleThreadTCPServer {
    //Agrego atributo de strategy
    private SessionTerminationStrategy ts = new EmptyLineStrategy();
    public SingleThreadTCPServer(SessionTerminationStrategy ts){
        this.ts = ts;
    }
    //Uso nuevos metodos en el handleClient
    private final void handleClient(Socket clientSocket) {

        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message: " + inputLine + " from "
                        + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

                // Aca uso metodo terminate
                if (ts.terminate(inputLine)) {
                    break; // Client requested to close the connection
                }

                beforeHandleMessage(inputLine, clientSocket);

                handleMessage(inputLine, out);

                afterHandleMessage(inputLine, clientSocket);
            }
            onConnectionClosed(clientSocket);

        } catch (IOException e) {
            onCommunicationError(clientSocket, e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    
}
```
3) Implemente un servidor PasswordServer. Este servidor debe generar una password a partir de los tres argumentos que recibe en el mensaje enviado por el cliente.
Arg[0]: cadena de caracteres (letras) permitidas para utilizar en la password
Arg[1]: cadena de caracteres (números de 0 a 9) permitidos para utilizar en la password
Arg[2]: cadena de caracteres especiales permitidos para utilizar en la password
Las passwords deben ser generadas de forma aleatoria y complir con las 	siguientes reglas:
Tener una longitud de 8 caracteres
Contener letras, al menos un número y un solo carácter especial
```java
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PasswordServer extends SingleThreadTCPServer{
    private SecureRandom random = new SecureRandom();
    
    @Override
    public void handleMessage(String message){
        Strings[] arg  = message.split("\\s+");
        if (arg.length != 3){
            System.out.printf("Enviar 3 argumentos");
        }
        String letters = arg[0];
        String numbers = arg[1];
        String specials = arg[2];
        
        if (letters.isEmpty() || numbers.isEmpty() || specials.isEmpty()){
            System.out.printf("Enviar 3 argumentos validos");
        }

        System.out.printf(generatePassword(letters,numbers,specials));
    }
    
    private String generatePassword(String letters, String numbers, String specials){
        List<Character> passwordChars = new ArrayList<>();
        // 1 especial y 1 numero y al menos 8, luego la mezclo
        passwordChars.add(random(specials));
        passwordChars.add(random(numbers));
        while (passwordChars.size() < 8){
            passwordChars.add(random(letters));
        }
        Collections.shuffle(passwordChars);
        
        // Paso la coleccion a un string y lo retorno
        StringBuilder password = new StringBuilder();
        for (Character c : passwordChars){
            password.append(c);
        }
        
        return password.toString();
    }
}
```
Es igual al de arriba xd
4) Implemente un servidor RepeatServer. Este servidor debe repetir un string a partir de los argumentos que recibe en el mensaje enviado por el cliente:
Arg[0]: es el string a repetir. Este argumento es requerido y no puede ser nulo o vacío.
Arg[1]: es la cantidad de veces que debe repetir el string. Este argumento es requerido y debe ser un número entero mayor a 0.
Arg[2]: es un carácter que se utiliza para delimitar los strings repetidos. Este argumento es opcional, y en caso de que el cliente no lo especifique, es un espacio en blanco.

Notas:
Para repetir un String, puede utilizar el método repeat que ya tienen los objetos String
Para ver sí un String está vacío, puede utilizar el método isEmpty
Para convertir un String a int, puede utilizar el método estático parseInt de la clase Integer: Recuerde que debe manejar la excepción NumberFormatException
