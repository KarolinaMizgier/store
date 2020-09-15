package org.karolinaprojects.store.components;

import org.karolinaprojects.store.model.Product;
import org.karolinaprojects.store.model.ProductIndex;
import org.karolinaprojects.store.model.ProductLabel;

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
        product.setId(Integer.parseInt(map.get(ProductLabel.ID.value())));
        product.setName(map.get(ProductLabel.NAME.value()));
        product.setType(map.get(ProductLabel.TYPE.value()));
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(map.get(ProductLabel.DATE.value()));
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
        product.setId(Integer.parseInt(strings.get(ProductIndex.ID.value())));
        product.setName(strings.get(ProductIndex.NAME.value()));

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strings.get(ProductIndex.DATE.value()));
            product.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        product.setType(strings.get(ProductIndex.TYPE.value()));
        return product;
    }
}
