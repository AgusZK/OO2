## Ejercicio 2: Iteradores circulares
#### Dada la siguiente implementación:
```java
 1   public class CharRing extends Object {
 2      char[] source;
 3      int idx;
 4  
 5      public CharRing(String srcString) {
 6          char result;
 7          source = new char[srcString.length()];
 8          srcString.getChars(0, srcString.length(), source, 0);
 9          result = 0;
10          idx = result;
11      }
12  
13      public char next() {
14          int result;
15          if (idx >= source.length)
16              idx = 0;
17          result = idx++;
18          return source[result];
19      }
20  }
```

#### Tareas:
1) Se quiere aplicar el refactoring Rename Variable sobre la variable result que se usa en la línea 18 con el nuevo nombre currentPosition.
2) ¿Cómo queda el código final y qué inconveniente se podría encontrar?
- Codigo modificado con Rename Variable:
    ```java
        public char next() {
            int currentPosition;
            if (idx >= source.length)
                idx = 0;
            currentPosition = idx++;
            return source[currentPosition];
    }
    ```
- Los inconvenientes que pueden llegar a encontrarse es a nivel de legibilidad ya que currentPosition no es en realidad la posicion actual del anillo si no que es la posicion anterior a idx