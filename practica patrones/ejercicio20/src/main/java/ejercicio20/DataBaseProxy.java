package ejercicio20;

import java.util.Collection;
import java.util.List;

public class DataBaseProxy implements DatabaseAccess{
    private DatabaseAccess db;
    private String clave;
    private boolean logeado;

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
            return this.db.getSearchResults(queryString);
        }
        throw new IllegalArgumentException("Usuario no logeado");
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (this.logeado){
            return this.db.insertNewRow(rowData);
        }
        throw new IllegalArgumentException("Usuario no logeado");
    }

}