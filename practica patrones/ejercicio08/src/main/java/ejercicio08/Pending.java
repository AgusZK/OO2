package ejercicio08;

import java.time.Duration;

public class Pending extends State {
    public Pending(ToDoItem tarea){
        super(tarea);
    }

    @Override
    public void start() {
        ToDoItem tarea = this.getTarea();
        tarea.changeState(new InProgress(tarea));
    }

    @Override
    public void togglePause() throws RuntimeException {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pausa o in-progress");
    }

    @Override
    public Duration workedTime() {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pause, in-progress o finished");
    }
}
