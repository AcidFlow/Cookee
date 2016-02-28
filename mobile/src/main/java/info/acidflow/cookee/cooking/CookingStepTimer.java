package info.acidflow.cookee.cooking;

import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;

import info.acidflow.cookee.model.Timer;

/**
 * Created by paul on 28/02/16.
 */
public class CookingStepTimer extends CountDownTimer implements Parcelable {

    public interface TickListener {
        void onTick( int step, Timer t, long remainingMillis );

        void onFinish( int step, Timer t );
    }

    private static final long COUNT_DOWN_STEP_MS = 1000;

    private int mRecipeStep;
    private long mDurationMs;
    private Timer mTimer;
    private TickListener mListener;

    public CookingStepTimer( int recipeStep, Timer timer ) {
        super( timer.getDurationMs(), COUNT_DOWN_STEP_MS );
        mDurationMs = timer.getDurationMs();
        mRecipeStep = recipeStep;
        mTimer = timer;
    }

    public CookingStepTimer( Parcel in ) {
        super( in.readLong(), COUNT_DOWN_STEP_MS);
        mRecipeStep = in.readInt();
        mTimer = in.readParcelable( Timer.class.getClassLoader() );
        in.setDataPosition( 0 );
        mDurationMs = in.readLong();
    }

    public void setListener( TickListener listener ) {
        mListener = listener;
    }

    @Override
    public void onTick( long millisUntilFinished ) {
        if ( mListener != null ) {
            mListener.onTick( mRecipeStep, mTimer, millisUntilFinished );
        }
    }

    @Override
    public void onFinish() {
        if ( mListener != null ) {
            mListener.onFinish( mRecipeStep, mTimer );
        }
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeLong( mDurationMs );
        dest.writeInt( mRecipeStep );
        dest.writeParcelable( mTimer, flags );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< CookingStepTimer > CREATOR = new Creator< CookingStepTimer >() {
        @Override
        public CookingStepTimer createFromParcel( Parcel in ) {
            return new CookingStepTimer( in );
        }

        @Override
        public CookingStepTimer[] newArray( int size ) {
            return new CookingStepTimer[ size ];
        }
    };
}
