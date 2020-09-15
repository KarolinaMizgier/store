package org.karolinaprojects.store;

import org.junit.Test;
import org.karolinaprojects.store.components.JsonDeserializer;
import org.karolinaprojects.store.model.Product;
import org.karolinaprojects.store.utils.TestUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonDeserializerTest {

    @Test
    public void testJsonDeserializer() throws ParseException {
        String jsonInput = "[ {\n" +
                "  \"name\" : \"salt\",\n" +
                "  \"type\" : \"consumable\",\n" +
                "  \"id\" : 1,\n" +
                "  \"date\" : \"06/08/2013\"\n" +
                "} ]";

        List<Product> productsExpected = new ArrayList<>();
        productsExpected.add(new Product("salt","consumable",1, TestUtil.formatDate("6-Aug-2013")));

        List<Product> productsFinal = JsonDeserializer.deserializeJson(jsonInput);

        assertNotNull(productsFinal);
        assertEquals(productsExpected,productsFinal);


    }




}
