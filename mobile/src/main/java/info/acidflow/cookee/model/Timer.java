package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 28/02/16.
 */
public class Timer implements Parcelable {

    @SerializedName( "duration" )
    private final long mDurationMs;

    @SerializedName( "description" )
    private final String mDescription;

    public Timer( long durationMs, String description ) {
        super();
        mDurationMs = durationMs;
        mDescription = description;
    }

    public long getDurationMs() {
        return mDurationMs;
    }

    public String getDescription() {
        return mDescription;
    }

    protected Timer( Parcel in ) {
        mDurationMs = in.readLong();
        mDescription = in.readString();
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeLong( mDurationMs );
        dest.writeString( mDescription );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Timer > CREATOR = new Creator< Timer >() {
        @Override
        public Timer createFromParcel( Parcel in ) {
            return new Timer( in );
        }

        @Override
        public Timer[] newArray( int size ) {
            return new Timer[ size ];
        }
    };
}
