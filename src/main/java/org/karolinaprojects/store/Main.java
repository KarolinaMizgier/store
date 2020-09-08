package org.karolinaprojects.store;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Product> deserialized = JsonDeserializer.deserializeJson(json);
        System.out.println(deserialized);
    }
}


