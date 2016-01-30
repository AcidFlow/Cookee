package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 20/01/16.
 */
public class Ingredient implements Parcelable {

    @SerializedName( "name" )
    private final String mName;

    @SerializedName( "quantity" )
    private final Quantity mQuantity;

    public Ingredient( String name, Quantity quantity ) {
        mName = name;
        mQuantity = quantity;
    }

    protected Ingredient( Parcel in ) {
        mName = in.readString();
        mQuantity = in.readParcelable( Quantity.class.getClassLoader() );
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString( mName );
        dest.writeParcelable( mQuantity, flags );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Ingredient > CREATOR = new Creator< Ingredient >() {
        @Override
        public Ingredient createFromParcel( Parcel in ) {
            return new Ingredient( in );
        }

        @Override
        public Ingredient[] newArray( int size ) {
            return new Ingredient[ size ];
        }
    };

    public String getName() {
        return mName;
    }

    public Quantity getQuantity() {
        return mQuantity;
    }
}
