package org.karolinaprojects.store;

import java.util.*;

public class ProductSerializer {

    public static List<Product> serialize(List<String> list){
        String firstLine = list.get(0);
        String[] split = firstLine.split(",");
        List<String> keys = Arrays.asList(split);
        list.remove(0);
        List<Product> products = new ArrayList<>();
        list.forEach(line -> {
            List<String> values = Arrays.asList(line.split(","));
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
            products.add(ProductMapper.mapStringMapToProduct(map));

       });
        return products;
    }

}
