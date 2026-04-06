## Ejercicio 3: Iteradores circulares bis
#### Se cuenta con las siguientes implementaciones de iteradores circulares, las cuales presentan implementaciones similares. 
```java
 1 public class CharRing {
 2  private char[] source;
 3  private int idx;
 4 
 5  public CharRing(String src) {
 6      source = src.toCharArray();
 7      idx = 0;
 8  }
 9
10  public char next() {
11     if (idx >= source.length)
12         idx = 0;
13     return source[idx++];
14  }
15 }
```
```java
 1 public class IntRing {
 2  private int[] source;
 3  private int idx;
 4
 5  public IntRing(int[] src) {
 6      source = src;
 7      idx = 0;
 8  }
 9
10  public int next() {
11      if (idx >= source.length)
12          idx = 0;
13      return source[idx++];
14  }
15 }
```
- Tareas:
1) Diseñe e implemente Test de Unidad para las clases CharRing e IntRing. Asegúrese de que los test pasen.
    ```java
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    public class CharRingTest {
        private CharRing ringABC;
        private CharRing ringAB;
        private CharRing ring1;
    
        @BeforeEach
        public void setUp(){
            ringABC = new CharRing ("abc");
            ringAB = new CharRing ("ab");
            ring1 = new CharRing ("x");
        }
        
        @Test
        void testNext(){
            assertEquals('a', ringABC.next());
            assertEquals('b', ringABC.next());
            assertEquals('c', ringABC.next());
        }
        
        @Test
        void testCirculo(){
            assertEquals('a', ringAB.next());
            assertEquals('b', ringAB.next());
            assertEquals('a', ringAB.next());
            assertEquals('b', ringAB.next());
        }
        
        @Test
        void testUnElemento(){
            assertEquals('x', ring1.next());
            assertEquals('x', ring1.next());
            assertEquals('x', ring1.next());
        }
    }
    ```
    ```java
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    public class IntRingTest {
        private IntRing ring123;
        private IntRing ring12;
        private IntRing ring1;
    
        @BeforeEach
        public void setUp(){
            ring123 = new IntRing(new int[]{1, 2, 3});
            ring12 = new IntRing(new int[]{1, 2});
            ring1 = new IntRing(new int[]{9});
        }
        
        @Test
        void testNext(){
            assertEquals(1, ring123.next());
            assertEquals(2, ring123.next());
            assertEquals(3, ring123.next());
        }
        
        @Test
        void testCirculo(){
            assertEquals(1, ring12.next());
            assertEquals(2, ring12.next());
            assertEquals(1, ring12.next());
            assertEquals(2, ring12.next());
        }
        
        @Test
        void testUnElemento(){
            assertEquals(9, ring1.next());
            assertEquals(9, ring1.next());
            assertEquals(9, ring1.next());
        }
    }
    ```
2) Aplique el refactoring Extract Superclass. Detalle cada uno de los pasos intermedios que son necesarios para poder aplicar correctamente este refactoring.
3) Verifique que los tests definidos en el paso 1 sigan funcionando correctamente.
    - Creo una clase abstracta "AbstractRing" que contenga logica comun de ambos Rings, ademas de la v.i idx inicializada en 0
    ```java
        public abstract class AbstractRing {
            private int idx = 0;
            
            public void reset(int length){
                if (idx >= length) {
                    idx = 0;
                }
            }
    }
    ```
   - Hago que tanto CharRing como IntRing hereden de la nueva clase creada
   - Refactorizo el codigo utilizando el nuevo metodo reset en ambas subclases
    ```java
       public class CharRing extends AbstractRing{
            private char[] source;
   
            public CharRing (String src){
                this.source = src.toCharArray();
            }
   
            public char next(){
                reset(source.length);
                return source[idx++];
            }
       }
   
       public class IntRing extends AbstractRing{
            private int[] source;
   
            public IntRing (int[] src){
                this.source = src;
            }
   
            public int next() {
                reset(source.length);
                return source[idx++];
            }
    }
    ```
   - Se podria hacer tambien utilizando genericos tipo <T> y que al momento de instanciar un Ring es cuando se le asigna el tipo de elemento que va a tener el arreglo, total la funcionalidad es muy similar
4) Realice un diagrama de clases UML con el diseño refactorizado.
    ![Diagrama UML](https://i.imgur.com/YgMTun3.png)
