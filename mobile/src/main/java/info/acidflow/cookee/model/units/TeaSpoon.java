package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 20/01/16.
 */
public class TeaSpoon extends Unit {

    public TeaSpoon() {
        super( UnitType.TEA_SPOON );
    }

    protected TeaSpoon( Parcel in ) {
        super( in );
    }

    public static final Creator< TeaSpoon > CREATOR = new Creator< TeaSpoon >() {
        @Override
        public TeaSpoon createFromParcel( Parcel in ) {
            return new TeaSpoon( in );
        }

        @Override
        public TeaSpoon[] newArray( int size ) {
            return new TeaSpoon[ size ];
        }
    };
}
