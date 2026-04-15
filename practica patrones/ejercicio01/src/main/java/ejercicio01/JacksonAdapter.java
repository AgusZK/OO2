package ejercicio01;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonAdapter extends VoorheesExporter{

    @Override
    // Pasa lista de socios a una cadena JSON con el mapper y la retorna
    // En caso de que falle esta vacia y ocurre el error del catch
    public String exportar (List<Socio> socios){
        ObjectMapper mapper = new ObjectMapper();
        String cadena = "";

        try{
            cadena = mapper.writeValueAsString(socios);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return cadena;
    }
}
