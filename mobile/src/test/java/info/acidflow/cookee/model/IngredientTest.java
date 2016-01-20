package info.acidflow.cookee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import info.acidflow.cookee.model.units.Gram;
import info.acidflow.cookee.model.units.Unit;
import info.acidflow.cookee.rest.gson.deserializer.UnitDeserializer;

import static org.junit.Assert.*;

/**
 * Created by paul on 20/01/16.
 */
public class IngredientTest {

    private Gson gson;

    @Before
    public void setUp( ) throws Exception {
        gson = new GsonBuilder().registerTypeAdapter( Unit.class, new UnitDeserializer() ).create();
    }

    @Test
    public void testDeserialisationValid(){
        //<editor-fold desc="jsonString = Test string">
        String jsonString = "{\n" +
                "  name: \"test\", \n" +
                "  quantity: {\n" +
                "    unit: {\n" +
                "      type: \"GRAM\"\n" +
                "    },\n" +
                "    quantity: 250\n" +
                "  }\n" +
                "}";
        //</editor-fold>
        Ingredient test = gson.fromJson( jsonString, Ingredient.class );
        assertEquals( test.getName(), "test" );
        assertEquals( test.getQuantity().getUnit().getClass(), Gram.class );
        assertEquals( test.getQuantity().getQuantity(), 250, 0);
    }
}