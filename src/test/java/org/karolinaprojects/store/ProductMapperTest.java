package org.karolinaprojects.store;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductMapperTest {

    @Test
    public void testProductMapper () throws ParseException {
        List<String> input = new ArrayList<>();
        input.add("1,salt,consumable,13/02/2020");
        List<Product> pattern = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        pattern.add(new Product("salt","consumable", 1, formatter.parse("13-Feb-2020")));
        List<Product> output = new ArrayList<>();
        output = ProductMapper.mapStringsToProducts(input);



        assertNotNull(output);
        for (int i=0; i<output.size(); i++){
            assertEquals(output.get(i),pattern.get(i));
        }
    }

}
