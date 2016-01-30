package info.acidflow.cookee.model.units;

import android.os.Parcel;

/**
 * Created by paul on 20/01/16.
 */
public class TableSpoon extends Unit {

    public TableSpoon() {
        super( UnitType.TABLE_SPOON );
    }

    protected TableSpoon( Parcel in ) {
        super( in );
    }

    public static final Creator< TableSpoon > CREATOR = new Creator< TableSpoon >() {
        @Override
        public TableSpoon createFromParcel( Parcel in ) {
            return new TableSpoon( in );
        }

        @Override
        public TableSpoon[] newArray( int size ) {
            return new TableSpoon[ size ];
        }
    };

}
