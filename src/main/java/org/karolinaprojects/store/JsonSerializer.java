package org.karolinaprojects.store;

import com.google.gson.stream.JsonReader;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    // Product deserializeJson(String json)
    // TODO: prepare tests
    // TODO: move deserializers to JsonDeserializer class


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

//    public static List<String> deserializeObject(File file) {
//        List<Product> linksList = new ArrayList<>();
//        try {
//            JsonReader reader = new JsonReader(new FileReader(file));
//            reader.beginArray();
//            while (reader.hasNext()) {
//                String value = reader.nextString();
//                linksList.add(value);
//            }
//            reader.endArray();
//            reader.close();
//        } catch (FileNotFoundException fnfe) {
//            fnfe.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//
//        return linksList;
//    }
}











