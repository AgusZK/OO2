package ejercicio01;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONAdapter extends VoorheesExporter{
    public JSONObject instanciarSocio (Socio socio){
        JSONObject objectJSON = new JSONObject();
        // Represento el socio en un objeto JSON
        objectJSON.put("nombre", socio.getNombre());
        objectJSON.put("legajo", socio.getLegajo());
        objectJSON.put("email", socio.getEmail());

        return objectJSON;
    }

    @Override
    public String exportar (List<Socio> socios){
        JSONArray arrayJSON = new JSONArray();
        // Antes de agregarlo tengo que crearlo con el metodo de arriba y dps hago
        // el toString ya implementado
        socios.forEach(s -> arrayJSON.add(this.instanciarSocio(s)));

        return arrayJSON.toJSONString();
    }
}
