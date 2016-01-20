package info.acidflow.cookee.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 20/01/16.
 */
public class Ingredient {

    @SerializedName( "name" )
    private final String mName;

    @SerializedName( "quantity" )
    private final Quantity mQuantity;

    public Ingredient( String name, Quantity quantity ) {
        mName = name;
        mQuantity = quantity;
    }

    public String getName() {
        return mName;
    }

    public Quantity getQuantity() {
        return mQuantity;
    }
}
