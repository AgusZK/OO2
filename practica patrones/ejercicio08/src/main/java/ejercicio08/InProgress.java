package ejercicio08;

import java.time.Duration;
import java.time.LocalDateTime;

public class InProgress extends State{
    // Cuando se crea el estado in progress hay que ponerle el start date
    public InProgress(ToDoItem tarea){
        super(tarea);
        this.getTarea().setStartDate();
    }

    @Override
    public void togglePause() {
        ToDoItem tarea = this.getTarea();
        tarea.changeState(new Paused(tarea));
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
