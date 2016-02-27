package info.acidflow.cookee.model.units;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by paul on 20/01/16.
 */
public class Unit implements Parcelable {

    private final UnitType mType;

    protected Unit( UnitType type){
        super();
        mType = type;
    }


    public final UnitType getType(){
        return mType;
    }

    protected Unit( Parcel in ) {
        super();
        mType = UnitType.values()[in.readInt()];
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeInt( mType.ordinal() );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Unit > CREATOR = new Creator< Unit >() {
        @Override
        public Unit createFromParcel( Parcel in ) {
            return new Unit( in );
        }

        @Override
        public Unit[] newArray( int size ) {
            return new Unit[ size ];
        }
    };

}
