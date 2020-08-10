package org.karolinaprojects.store;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductService {

    private static List<Product> sortByType(List<Product> products) {


        return products.stream()
                .sorted(Comparator.comparing(Product::getType))
                .collect(Collectors.toList());
    }

    private static List<Product> sortByName(List<Product> products) {

        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    private static List<Product> sortById(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getId))
                .collect(Collectors.toList());

    }

    private static List<Product> sortByDate(List<Product> products) {

        return products.stream()
                .sorted(Comparator.comparing(Product::getDate))
                .collect(Collectors.toList());
    }


    public static List<Product> sortBy(List<Product> products, String field) {
        // switch
        switch (field) {

            case "name":
                return sortByName(products);

            case "type":
                return sortByType(products);

            case "id":
                return sortById(products);

            case "date":
                return sortByDate(products);
        }
        return null;
    }

    public static List<Product> occurances(List<Product> list, String key) {
        List<Product> list1 = new ArrayList<>();
        list.forEach(line->{
            System.out.println(line);
        });

        long count = list.stream()
                .map(p -> p.getType())
                .filter(p -> p.equals(key))
                .count();

        System.out.println(key + ": " + count);
        return null;



    }

}



   //  public List<Product> sortBy(List<Product> products, String field) {
     //    if (field == "type") {
       //      return sortByType(products, "type");
         //}
     //}









