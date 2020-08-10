package org.karolinaprojects.store;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductMapper {
    public static List<Product> mapStringsToProducts(List<String> text){
        List<Product> products = new ArrayList<>();
        text.forEach(line ->{
            products.add(mapStringToProduct(line));
        });
        return products;
    }

    public static Product mapStringMapToProduct(Map<String, String> map){

        Product product = new Product();
        product.setId(Integer.parseInt(map.get("Id")));
        product.setName(map.get("name"));
        product.setType(map.get("type"));
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(map.get("date"));
            product.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return product;
    }


    private static Product mapStringToProduct(String text){
        String[] split = text.split(",");
        List<String> strings = Arrays.asList(split);
        Product product = new Product();
        product.setId(Integer.parseInt(strings.get(0)));
        product.setName(strings.get(1));

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strings.get(2));
            product.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        product.setType(strings.get(3));
        return product;
    }



}
