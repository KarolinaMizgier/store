package org.karolinaprojects.store;

import org.junit.Test;
import org.karolinaprojects.store.model.Product;
import org.karolinaprojects.store.service.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @Test
    public void testSortById() throws ParseException {

        // given init input
        List<Product> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        list.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        list.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));
        list.add(new Product("sugar", "consumable", 2, formatter.parse("6-Aug-2013")));
        String key = "id";
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        expected.add(new Product("sugar", "consumable", 2, formatter.parse("6-Aug-2013")));
        expected.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));

        // when
        List<Product> products = ProductService.sortBy(list, key);
        // then

        assertNotNull(products);
       for (int i=0; i<products.size(); i++){
           assertEquals(products.get(i),expected.get(i));
       }


        //System.out.println(products);
    }
    @Test
    public void testSortByName() throws ParseException {

        List<Product> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        list.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        list.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));
        list.add(new Product("cinnamon", "consumable", 2, formatter.parse("6-Aug-2013")));
        String key = "name";
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        expected.add(new Product("cinnamon", "consumable", 2, formatter.parse("6-Aug-2013")));
        expected.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));

        // when
        List<Product> products = ProductService.sortBy(list, key);
        // then

        assertNotNull(products);
        for (int i=0; i<products.size(); i++){
            assertEquals(products.get(i),expected.get(i));
        }


    }
    @Test
    public void testSortByDate() throws ParseException {
        List<Product> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        list.add(new Product("sugar", "consumable", 2, formatter.parse("6-Aug-2013")));
        list.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        list.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));

        String key = "date";
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("bread", "consumable", 1, formatter.parse("1-Jun-2013")));
        expected.add(new Product("salt", "consumable", 3, formatter.parse("2-Aug-2013")));
        expected.add(new Product("sugar", "consumable", 2, formatter.parse("6-Aug-2013")));


        // when
        List<Product> products = ProductService.sortBy(list, key);
        // then

        assertNotNull(products);
        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i), expected.get(i));
        }

    }
}
//sortowanie innych typow
//klasa testujaca productMapper