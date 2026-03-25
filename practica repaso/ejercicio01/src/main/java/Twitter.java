import java.util.*;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter (){
        this.usuarios = new ArrayList<Usuario>();
    }

    public Usuario crearUsuario (String screenName){
        Usuario u = null;
        if (!this.existeUsuario(screenName)){
            u = new Usuario(screenName);
            this.usuarios.add(u);
        }
        return u;
    }

    public boolean existeUsuario(String screenName){
        return this.usuarios.stream().anyMatch( u -> u.getScreenName().equals(screenName));
    }

    public void eliminarUsuario(Usuario u){
        if (existeUsuario(u.getScreenName())){
            u.borrarTweets();
            this.usuarios.remove(u);
        }
    }

    public List<Usuario> getUsuarios(){
        return new ArrayList<Usuario>(usuarios);
    }
}
