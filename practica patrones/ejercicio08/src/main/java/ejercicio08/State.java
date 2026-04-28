package ejercicio08;

import java.time.Duration;

public abstract class State {
    private ToDoItem tarea;

    public State(ToDoItem tarea){
        this.tarea = tarea;
    }

    public ToDoItem getTarea() {
        return tarea;
    }

    public void start(){};
    public abstract void togglePause();
    public void finish(){}
    public abstract Duration workedTime();
    public void addComment(String comment){
        this.tarea.getComments().add(comment);
    }
}
