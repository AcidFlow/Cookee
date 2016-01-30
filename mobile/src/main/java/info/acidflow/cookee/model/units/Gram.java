package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 20/01/16.
 */
public class Gram extends Unit {

    public Gram() {
        super( UnitType.GRAM );
    }

    protected Gram( Parcel in ) {
        super( in );
    }

    public static final Creator< Gram > CREATOR = new Creator< Gram >() {
        @Override
        public Gram createFromParcel( Parcel in ) {
            return new Gram( in );
        }

        @Override
        public Gram[] newArray( int size ) {
            return new Gram[ size ];
        }
    };
}
