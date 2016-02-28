package info.acidflow.cookee.rest.gson.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import info.acidflow.cookee.model.units.Unit;
import info.acidflow.cookee.model.units.UnitType;
import info.acidflow.cookee.model.units.factory.UnitFactory;

/**
 * Created by paul on 20/01/16.
 */
public final class UnitDeserializer implements JsonDeserializer< Unit > {

    @Override
    public Unit deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext context )
            throws JsonParseException {
        return UnitFactory.getUnit( UnitType.valueOf(
                json.getAsJsonObject().get( "type" ).getAsString()
                )
        );
    }
}
