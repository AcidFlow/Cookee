package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 20/01/16.
 */
public class Piece extends Unit {

    public Piece() {
        super( UnitType.PIECE );
    }

    protected Piece( Parcel in ) {
        super( in );
    }

    public static final Creator< Piece > CREATOR = new Creator< Piece >() {
        @Override
        public Piece createFromParcel( Parcel in ) {
            return new Piece( in );
        }

        @Override
        public Piece[] newArray( int size ) {
            return new Piece[ size ];
        }
    };

}
