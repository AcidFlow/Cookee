package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 28/02/16.
 */
public class Milliliter extends Unit {

    public Milliliter() {
        super( UnitType.MILLILITER );
    }

    public Milliliter( Parcel in ) {
        super( in );
    }

    public static final Creator< Milliliter > CREATOR = new Creator< Milliliter >() {
        @Override
        public Milliliter createFromParcel( Parcel in ) {
            return new Milliliter( in );
        }

        @Override
        public Milliliter[] newArray( int size ) {
            return new Milliliter[ size ];
        }
    };
}
