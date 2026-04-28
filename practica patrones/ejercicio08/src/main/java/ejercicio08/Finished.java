package ejercicio08;

import java.time.Duration;
import java.time.LocalDateTime;

public class Finished extends State{
    // Si lo cambio a finalizado hay que ponerle end-date
    public Finished (ToDoItem tarea){
        super(tarea);
        tarea.setEndDate();
    }

    @Override
    public void togglePause() {
        throw new RuntimeException("El objeto TodoItem no se encuentra en pause o in-progress");
    }

    @Override
    public Duration workedTime() {
        return Duration.between(this.getTarea().getStart(), this.getTarea().getEnd());
    }
}
