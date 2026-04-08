## Ejercicio 8 - Documentos y estadísticas
#### Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:
```java
public class Document {
    List<String> words;
  
    public long characterCount() {
 	    long count = this.words.stream()
            .mapToLong(w -> w.length())
            .sum();
        return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words.stream()
                .mapToLong(w -> w.length())
                .sum() / this.words.size();
 	    return avgLength;
	}
    // Resto del código que no importa
}
```
- Tareas:
  1) Enumere los code smell y que refactorings utilizará para solucionarlos.
        - Duplicate code, el metodo calculateAvg recorre nueivamente la lista de palabras para sumar la longitud de cada una y eso ya lo hace el metodo de characterCount. Se debe llamar al metodo characterCount en calculateAvg en vez de hardcodearlo denuevo
  2) Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno.
        - Se debe hacer un Reuse/Call method en lugar de duplicar la logica. 
        ```java
        public class Document {
        List<String> words;
        
            public long characterCount() {
                long count = this.words.stream()
                    .mapToLong(w -> w.length())
                    .sum();
                return count;
            }
            public long calculateAvg() {
                // Agrego checkeo de 0 del inciso 3)
                if (this.words.isEmpty()){
                    return 0
                }
                return characterCount() / this.words.size();
            }
        }
        ```
  3) Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?
        - El error en el calculo de estadisticas se puede dar si la lista de palabras esta vacia ya que harias una division por 0. Al momento de hacer el refactoring y eliminar codigo duplicado el problema persiste, por lo que se deberia agregar un checkeo previo para evitar este problema. No se considera refactoring si no mas bien una mejora en el comportamiento del codigo/estructura interna del programa