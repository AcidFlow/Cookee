package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 28/02/16.
 */
public class NoUnit extends Unit {

    public NoUnit() {
        super( UnitType.NO_UNIT );
    }

    public NoUnit( Parcel in ) {
        super( in );
    }

    public static final Creator< NoUnit > CREATOR = new Creator< NoUnit >() {
        @Override
        public NoUnit createFromParcel( Parcel in ) {
            return new NoUnit( in );
        }

        @Override
        public NoUnit[] newArray( int size ) {
            return new NoUnit[ size ];
        }
    };
}
