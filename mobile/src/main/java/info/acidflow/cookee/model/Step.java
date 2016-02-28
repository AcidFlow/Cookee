package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 20/01/16.
 */
public class Step implements Parcelable {

    @SerializedName( "description" )
    private final String mStepDescription;

    @SerializedName( "timer" )
    private final Timer mTimer;

    public Step( String stepDescription ) {
        this( stepDescription, null );
    }

    public Step( String stepDescription, Timer timer ) {
        mStepDescription = stepDescription;
        mTimer = timer;
    }

    public String getStepDescription() {
        return mStepDescription;
    }

    public boolean hasTimer() {
        return mTimer != null;
    }

    public Timer getTimer() {
        return mTimer;
    }

    protected Step( Parcel in ) {
        mStepDescription = in.readString();
        mTimer = in.readParcelable( Timer.class.getClassLoader() );
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString( mStepDescription );
        dest.writeParcelable( mTimer, flags );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Step > CREATOR = new Creator< Step >() {
        @Override
        public Step createFromParcel( Parcel in ) {
            return new Step( in );
        }

        @Override
        public Step[] newArray( int size ) {
            return new Step[ size ];
        }
    };
}
