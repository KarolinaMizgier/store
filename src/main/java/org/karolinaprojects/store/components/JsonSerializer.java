package org.karolinaprojects.store.components;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JsonSerializer {
    public static String serializeObject(Object list) {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(df);
        String jsonString = "";
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}











