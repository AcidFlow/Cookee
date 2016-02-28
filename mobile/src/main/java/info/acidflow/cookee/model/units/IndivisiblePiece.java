package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 20/01/16.
 */
public class IndivisiblePiece extends Unit {

    public IndivisiblePiece() {
        super( UnitType.INDIVISIBLE_PIECE );
    }

    protected IndivisiblePiece( Parcel in ) {
        super( in );
    }

    public static final Creator< IndivisiblePiece > CREATOR = new Creator< IndivisiblePiece >() {
        @Override
        public IndivisiblePiece createFromParcel( Parcel in ) {
            return new IndivisiblePiece( in );
        }

        @Override
        public IndivisiblePiece[] newArray( int size ) {
            return new IndivisiblePiece[ size ];
        }
    };

}
