package org.karolinaprojects.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static Map<Integer, Product> additionalProducts = Map.of(
            1, new Product("tomato", "consumable", 1, Date.valueOf(LocalDate.now())),
            3, new Product("potato", "consumable", 3, Date.valueOf(LocalDate.now()))
            );


    static Map<String, String> productsMapStrings = new HashMap<>();
    public static void main(String[] args) {
	// write your code here
        List<String> list = FileUtil.read("./src/main/resources/products");

        //Product product = new Product();
       // System.out.println(list);

        List<Product> products = ProductSerializer.serialize(list);
        Map<Integer, Product> productsMap = new HashMap<>();
        products.forEach(product->{
            productsMap.put(product.getId(), product);
        });

        additionalProducts.forEach((key, value)->{
            productsMap.put(key,value);

       productsMapStrings.put(key.toString(),value.toString());
        });

        JsonSerializer.mapStringStringToJson(productsMapStrings);

        ObjectMapper file = new ObjectMapper();
        try {
            file.writeValue(new File("./src/main/resources/json.json"), productsMapStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(productsMapStrings);

















       // List<Product> sortedProducts = ProductService.sortBy(products,"date");
        //List<Product> occurance = ProductService.occurances(products, "season");

        //System.out.println();



        List<Product> productList = new ArrayList<>();
    }
}
