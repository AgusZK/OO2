## Ejercicio 2: Java Logging
En las clases teóricas de frameworks se trabajó con el framework de Logging de Java. Con lo visto en teoría y leyendo la documentación provista en el link anterior, resuelva los siguientes ejercicios.
Parte A: En este apartado utilizaremos el framework como usuarios, aprovechando las implementaciones ya provistas por éste.

i)Tomando su implementación del ejercicio de protección para el acceso a una base de datos (Cuadernillo patrones, ejercicio 20), incorpore logging de mensajes en las siguientes situaciones:
 Acceso válido para búsquedas a la base de datos con nivel INFO.
 Acceso válido para inserciones a la base de datos con nivel WARNING.
 Acceso inválido a la base de datos con nivel SEVERE.
```java
package ejercicio20;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseProxy implements DatabaseAccess{
    private DatabaseAccess db;
    private String clave;
    private boolean logeado;
    private static final Logger logger =  Logger.getLogger(DataBaseProxy.class.getName());

    public DataBaseProxy(DatabaseAccess db, String clave) {
        this.db = db;
        this.clave = clave;
        this.logeado = false;
    }

    public void logIn(String password){
        if (!this.logeado){
            if (this.clave.equals(password)){
                this.logeado = true;
            } else {
                throw new IllegalArgumentException("Contrasenia incorrecta");
            }
        } else{
            throw new IllegalArgumentException("Usuario ya logeado");
        }
    }

    public void logOut(){
        if (this.logeado){
            this.logeado = false;
        } else {
            throw new IllegalArgumentException("Usuario no logeado");
        }
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        if (this.logeado){
            logger.info("Ejecutando busqueda " + queryString);
            return this.db.getSearchResults(queryString);
        }
        logger.severe("Acceso invalido a getSearchResults()");
        throw new IllegalArgumentException("Usuario no logeado");
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (this.logeado){
            logger.warning("Insercion realizada " + rowData);
            return this.db.insertNewRow(rowData);
        }
        logger.severe("Acceso invalido a getSearchResults()");
        throw new IllegalArgumentException("Usuario no logeado");
    }
}
```

ii ) Retomamos el ejercicio de Wallpost de Objetos 1, donde trabajamos con mensajes de una red social como Facebook o Twitter. Se cuenta con una clase Wallpost con los siguientes atributos: un texto que se desea publicar, cantidad de likes (“me gusta”) y una marca que indica si es destacado o no.
Para realizar este ejercicio, descargue este material adicional. La implementación provista consta de tres paquetes: uno destinado a la aplicación, otro al modelo y el tercero a la interfaz de usuario de la aplicación.
Nos piden implementar dos registros de eventos, uno destinado al modelo y otro destinado a las interacciones realizadas con la interfaz.  El logger del modelo debe informar un mensaje con nivel warning cuando los dislikes hagan llegar la cantidad de likes a 0 y cuando la cantidad de likes llegue a 10. Además se pide realizar estos registros en un archivo de texto. Por otro lado, el logger de la parte visual debe registrar con nivel info todas las interacciones con la vista, tales como escribir el nombre del post, clickear en like o dislike. Además se solicita que registre un mensaje con nivel de información al iniciar la ejecución de la aplicación.

Asegúrese de completar todas las configuraciones de los loggers requeridas anteriormente dentro de la clase Ejercicio1Application
```java
package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

    public static void main(String[] args)
            throws SecurityException, IOException {

        Logger modelLogger =
                Logger.getLogger("wallpost.model");

        Logger uiLogger =
                Logger.getLogger("wallpost.ui");

        FileHandler fileHandler =
                new FileHandler("wallpost.log", true);

        modelLogger.addHandler(fileHandler);

        modelLogger.setLevel(Level.WARNING);
        uiLogger.setLevel(Level.INFO);

        uiLogger.info("Aplicacion iniciada");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WallPostUI();
            }
        });
    }
}
```
```java
package ar.edu.unlp.oo1.ejercicio1.impl;
import java.util.logging.Logger;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
    // Solo voy a poner los metodos que se usan para hacer lo que pide el FW
    // Las clases en si estan en la carpeta
	private String text;
	private int likes;
	private boolean isFeatured;
    private static final Logger logger = Logger.getLogger("wallpost.model");

	@Override
	public void like() {
		this.likes = this.likes + 1;
        if (this.likes == 10){
            logger.warning("La cantidad de likes llego a 10");
        }
	}

	@Override
	public void dislike() {
		if (likes > 0) {
			this.likes = this.likes - 1;
		}

        if (this.dislikes == 10){
            logger.warning("La cantidad de dislikes llego a 0");
        }
	}
}
```
```java
package ar.edu.unlp.oo1.ejercicio1.ui;
import ar.edu.unlp.oo1.ejercicio1.impl.WallPost;
import ar.edu.unlp.oo1.ejercicio1.impl.WallPostImpl;
import java.util.logging.Logger;

public class WallPostUI {
    // Solo voy a poner los metodos que se usan para hacer lo que pide el FW
    // Las clases en si estan en la carpeta
    private static final Logger logger = Logger.getLogger("wallpost.ui");
    
  private void wireComponents() {
    this.like.addActionListener( e -> {
        logger.info("Click en like");
      this.wallPost.like();
      this.likesLabel.setText(String.valueOf(this.wallPost.getLikes()));
    });
    
    this.dislike.addActionListener( e -> {
        logger.info("Click en dislike");
      this.wallPost.dislike();
      this.likesLabel.setText(String.valueOf(this.wallPost.getLikes()));
    });
    
    this.featuredCheckbox.addActionListener(e -> {
        logger.info("Cambio de featured a " + this.featuredCheckbox.isSelected());
      this.wallPost.toggleFeatured();
    });
    
    this.textArea.getDocument().addDocumentListener(new DocumentListener() {
      
      @Override
      public void removeUpdate(DocumentEvent e) {
          logger.info("Texto modificado: " + textArea.getText());
        wallPost.setText(textArea.getText());
      }
      
      @Override
      public void insertUpdate(DocumentEvent e) {
          logger.info("Texto modificado: " + textArea.getText());
        wallPost.setText(textArea.getText());
      }
      
      @Override
      public void changedUpdate(DocumentEvent e) {
          logger.info("Texto modificado: " + textArea.getText());
        wallPost.setText(textArea.getText());
      }
    });
  }
}

```