package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import info.acidflow.cookee.model.units.Unit;

/**
 * Created by paul on 20/01/16.
 */
public class Quantity implements Parcelable {

    @SerializedName( "unit" )
    private final Unit mUnit;

    @SerializedName( "quantity" )
    private final double mQuantity;

    public Quantity( Unit unit, double quantity ) {
        mUnit = unit;
        mQuantity = quantity;
    }

    protected Quantity( Parcel in ) {
        mUnit = in.readParcelable( Unit.class.getClassLoader() );
        mQuantity = in.readDouble();
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeParcelable( mUnit, flags );
        dest.writeDouble( mQuantity );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Quantity > CREATOR = new Creator< Quantity >() {
        @Override
        public Quantity createFromParcel( Parcel in ) {
            return new Quantity( in );
        }

        @Override
        public Quantity[] newArray( int size ) {
            return new Quantity[ size ];
        }
    };

    public Unit getUnit() {
        return mUnit;
    }

    public double getQuantity() {
        return mQuantity;
    }
}
