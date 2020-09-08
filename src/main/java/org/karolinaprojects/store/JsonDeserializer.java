package org.karolinaprojects.store;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonDeserializer {
    public static List<Product> deserializeJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(df);
        try {
            List<Product> product = mapper.readValue(json, new TypeReference<List<Product>>(){});
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
