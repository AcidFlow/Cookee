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
public class QuantityTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder().registerTypeAdapter( Unit.class, new UnitDeserializer() ).create();
    }

    @Test
    public void testDeserialisation(){
        //<editor-fold desc="String jsonString = ...">
        String jsonString = "{\n" +
                "  unit: {\n" +
                "    type: \"GRAM\"\n" +
                "  },\n" +
                "  quantity: 250\n" +
                "}";
        //</editor-fold>
        Quantity test = gson.fromJson( jsonString, Quantity.class );
        assertEquals( 250, test.getQuantity(), 0 );
        assertEquals( Gram.class, test.getUnit().getClass() );
    }
}