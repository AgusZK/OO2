## Ejercicio 4: Alcance en Redes Sociales
#### Una nueva red social está desarrollando un sistema para modelar perfiles y publicaciones, y medir su alcance como parte del algoritmo de relevancia. Cada publicación acumula reacciones de los usuarios, y cada perfil consolida el alcance de sus publicaciones amplificándolo según si está verificado o no. El código es el siguiente:
```java
    package redesocial;
    public class Publicacion {
        private String texto;
        private int likes;
        public Publicacion(String texto) {
            this.texto = texto;
            this.likes = 0;
        }
        public void darLike() { likes++; }
        public void darDislike() { likes--; }
        private int procesar() {
            return likes * 3;
        }
        public int calcular() {
            return procesar() * 10;
        }
}
```
```java
    package redesocial;
    import java.util.ArrayList;
    public class Perfil {
        private boolean verificado;
        private ArrayList<Publicacion> publicaciones;
        public Perfil(boolean verificado) {
            this.verificado = verificado;
            this.publicaciones = new ArrayList<>();
        }
        public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
        private int bonus() { return verificado ? 2 : 1; }
        private int alcanceDePublicaciones() {
           return publicaciones.stream().mapToInt(p -> p.calcular()).sum();
        }
       public int calcular() {
           return alcanceDePublicaciones() * bonus();
       }
}
```
- Tarea:
Liste cada uno de los cambios necesarios, indicando archivo y línea afectados, para cada uno de los siguientes refactorings:
1) Rename method: procesar (referenciado en línea 11 de Publicacion.java) por impacto
    ```java
        /* Se modifica la linea 11 de Publicacion.java */
        private int impacto() {
            return likes * 3;
        }
        /* Se modifica la linea 15 de Publicacion.java */
        return impacto() * 10;
    ```
2) Rename method: calcular (referenciado en línea 14 de Publicacion.java) por alcance
    ```java
        /* Se modifica la linea 14 de Publicacion.java */
        private int alcance() {
            return alcanceDePublicaciones() * bonus();
        }
        /* Se modifica la linea 13 de Perfil.java */
        private int alcanceDePublicaciones() {
            return publicaciones.stream().mapToInt(p -> p.alcance()).sum();
        }
    ```
3) Rename method: calcular (referenciado en línea 15 de Perfil.java) por alcance
    ```java
        /* Se modifica la linea 15 de Perfil.java */
        public int alcance() {
            return alcanceDePublicaciones() * bonus();
        }
        /* Se modifica la linea 13 de Perfil.java */
        private int alcanceDePublicaciones() {
            return publicaciones.stream().mapToInt(p -> p.alcance()).sum();
        }
    ```
4) Rename parameter: el parámetro “p” del método agregarPublicacion (línea 10 de Perfil.java) por “publicacion”
   ```java
    /* Se modifica la linea 10 de Perfil.java */
    public void agregarPublicacion(Publicacion publicacion) { publicaciones.add(publicacion); }
    ```