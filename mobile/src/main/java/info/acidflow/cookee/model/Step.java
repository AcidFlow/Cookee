package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 20/01/16.
 */
public class Step implements Parcelable{

    @SerializedName( "description" )
    private final String mStepDescription;

    public Step( String stepDescription ) {
        mStepDescription = stepDescription;
    }

    public String getStepDescription() {
        return mStepDescription;
    }

    protected Step( Parcel in ) {
        mStepDescription = in.readString();
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString( mStepDescription );
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
