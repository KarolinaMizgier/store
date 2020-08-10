package org.karolinaprojects.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSerializer {
    public static String serializeObject (Object list) {
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





