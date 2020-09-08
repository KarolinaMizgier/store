package org.karolinaprojects.store;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static Map<Integer, Product> additionalProducts = Map.of(
            1, new Product("tomato", "consumable", 1, Date.valueOf(LocalDate.now())),
            3, new Product("potato", "consumable", 3, Date.valueOf(LocalDate.now()))
            );


    static Map<String, String> productsMapStrings = new HashMap<>();
    public static void main(String[] args) {
        List<String> list = FileUtil.read("./src/main/resources/products");
        List<Product> products = ProductSerializer.serialize(list);
        Map<Integer, Product> productsMap = new HashMap<>();
        products.forEach(product->{
            productsMap.put(product.getId(), product);
        });

        additionalProducts.forEach((key, value)->{
            productsMap.put(key,value);

       productsMapStrings.put(key.toString(),value.toString());
        });

        String json = JsonSerializer.serializeObject(products);
        //FileUtil.write(json,"./src/main/resources/json2.json");
        //File jsonFile = new File("./src/main/resources/json2.json");
        List<Product> deserialized = JsonSerializer.deserializeJson(json);
        System.out.println(deserialized);
    }
}


