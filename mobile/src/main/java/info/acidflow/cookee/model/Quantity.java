package info.acidflow.cookee.model;

import com.google.gson.annotations.SerializedName;

import info.acidflow.cookee.model.units.Unit;

/**
 * Created by paul on 20/01/16.
 */
public class Quantity {

    @SerializedName( "unit" )
    private final Unit mUnit;

    @SerializedName( "quantity" )
    private final double mQuantity;

    public Quantity( Unit unit, double quantity ) {
        mUnit = unit;
        mQuantity = quantity;
    }

    public Unit getUnit() {
        return mUnit;
    }

    public double getQuantity() {
        return mQuantity;
    }
}
