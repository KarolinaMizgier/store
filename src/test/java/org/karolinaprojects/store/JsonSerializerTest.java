package org.karolinaprojects.store;
import org.junit.Test;
import org.karolinaprojects.store.utils.TestUtil;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonSerializerTest {

    @Test
    public void TestJsonSerializer(){

        List<Product> products = new ArrayList<>();
        products.add(new Product("salt","consumable",1, TestUtil.formatDate("6-Aug-2013")));
        String jsonPattern = "[ {\n" +
                "  \"name\" : \"salt\",\n" +
                "  \"type\" : \"consumable\",\n" +
                "  \"id\" : 1,\n" +
                "  \"date\" : \"06/08/2013\"\n" +
                "} ]";
       String jsonFinal = JsonSerializer.serializeObject(products);

       assertNotNull(jsonFinal);
       assertEquals(jsonPattern,jsonFinal);
    }
}