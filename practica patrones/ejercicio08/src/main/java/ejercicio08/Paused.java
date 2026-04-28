package ejercicio08;

import java.time.Duration;
import java.time.LocalDateTime;

public class Paused extends State{
    public Paused (ToDoItem tarea){
        super(tarea);
    }

    @Override
    public void togglePause() {
        ToDoItem tarea = this.getTarea();
        tarea.changeState(new InProgress(tarea));
    }

    @Override
    public void finish() {
        ToDoItem tarea = this.getTarea();
        tarea.changeState(new Finished(tarea));
    }

    @Override
    public Duration workedTime() {
        return Duration.between(this.getTarea().getStart(), LocalDateTime.now());
    }
}
