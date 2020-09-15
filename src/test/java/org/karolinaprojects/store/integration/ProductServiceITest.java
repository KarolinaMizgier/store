package org.karolinaprojects.store.integration;

import org.junit.Test;
import org.karolinaprojects.store.model.Product;
import org.karolinaprojects.store.service.ProductService;
import org.karolinaprojects.store.utils.FileUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductServiceITest {
    @Test
    public void testProductServiceIntegration(){
        Map<Integer, Product> additionalProducts = Map.of(
                1, new Product("tomato", "consumable", 1, Date.valueOf(LocalDate.now())),
                2, new Product("potato", "consumable", 2, Date.valueOf(LocalDate.now()))
        );
        Map<Integer, Product> expectedProducts = Map.of(
                1, new Product("tomato", "consumable", 1, Date.valueOf(LocalDate.now())),
                2, new Product("potato", "consumable", 2, Date.valueOf(LocalDate.now()))
        );
        List<String> list = FileUtil.read("./src/test/resources/products");
        Map<Integer,Product> productsMap = ProductService.replace(additionalProducts, list);

        assertEquals(productsMap,expectedProducts);

    }

}
