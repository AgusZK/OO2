package ejercicio24;

import java.util.List;

public class UserProxy implements PersistableUser{
    private User usuario;
    private PostRepository repo;
    private boolean cargados;

    public UserProxy(User usuario, PostRepository repo) {
        this.usuario = usuario;
        this.repo = repo;
        this.cargados = false;
    }

    @Override
    public String getUsername() {
        return this.usuario.getUsername();
    }

    @Override
    public String getEmail() {
        return this.usuario.getEmail();
    }

    @Override
    public List<Post> getPosts() {
        if (!this.cargados){
            List<Post> postsUsu = this.repo.findPostsByUsername(this.getUsername());
            this.usuario.addPosts(postsUsu);
            this.cargados = true;
        }
        return this.usuario.getPosts();
    }
}
