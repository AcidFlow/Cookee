package info.acidflow.cookee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by paul on 20/01/16.
 */
public class RecipeTest {

    private Gson gson;

    @Before
    public void setUp(){
        gson = new GsonBuilder().create();
    }

    @Test
    public void testDeserialisationValid(){
        //<editor-fold desc="String jsonString = ...">
        String jsonString = "{\n" +
                "  \"name\": \"name_test\", \n" +
                "  \"description\": \"description_test\", \n" +
                "  \"people_count\": 4, \n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"name\": \"test_1\",\n" +
                "      \"quantity\" : {}\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"test_2\",\n" +
                "      \"quantity\" : {}\n" +
                "    }\n" +
                "  ],\n" +
                "  \"meal_type\": \"MAIN_DISH\",\n" +
                "  \"cost\": \"CHEAP\",\n" +
                "  \"difficulty\": \"MEDIUM\"\n" +
                "}";
        //</editor-fold>
        Recipe r = gson.fromJson( jsonString, Recipe.class );
        assertEquals("name_test", r.getName());
        assertEquals("description_test", r.getDescription());
        assertEquals(4, r.getPeopleCount());
        assertEquals(2, r.getIngredientList().size());
        assertEquals(Difficulty.MEDIUM, r.getDifficulty());
        assertEquals(MealType.MAIN_DISH, r.getType());
        assertEquals(Cost.CHEAP, r.getCost());
    }
}
