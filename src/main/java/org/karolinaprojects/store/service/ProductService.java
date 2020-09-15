package org.karolinaprojects.store.service;

import org.karolinaprojects.store.components.ProductSerializer;
import org.karolinaprojects.store.model.Product;
import org.karolinaprojects.store.utils.FileUtil;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static Map<Integer,Product> replace(Map<Integer,Product> newProducts, List<String> list){
        List<Product> products = ProductSerializer.serialize(list);
        Map<Integer, Product> productsMap = new HashMap<>();
        products.forEach(product->{
            productsMap.put(product.getId(), product);
        });

        newProducts.forEach((key, value)->{
            productsMap.put(key,value);
        });
        return productsMap;
    }

    public static List<Product> occurances(List<Product> list, String key) {
        long count = list.stream()
                .map(p -> p.getType())
                .filter(p -> p.equals(key))
                .count();
        System.out.println(key + ": " + count);
        return null;
    }
}










