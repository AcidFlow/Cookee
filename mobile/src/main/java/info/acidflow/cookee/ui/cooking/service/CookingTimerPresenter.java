package info.acidflow.cookee.ui.cooking.service;

import android.content.Intent;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import info.acidflow.cookee.cooking.CookingStepTimer;
import info.acidflow.cookee.model.Timer;
import info.acidflow.cookee.ui.base.BasePresenter;

/**
 * Created by paul on 28/02/16.
 */
public class CookingTimerPresenter extends BasePresenter< ICookingTimerView > implements CookingStepTimer.TickListener {

    public static final String ACTION_NEW_TIMER = "action_new_timer";
    public static final String ACTION_CANCEL_TIMERS = "action_cancel_timers";
    public static final String EXTRA_TIMER = "extra_timer";

    private List< CookingStepTimer > mTimers;

    public CookingTimerPresenter() {
        super();
        mTimers = new ArrayList<>();
    }

    public boolean onActionReceived( Intent intent ) {
        if ( intent == null || TextUtils.isEmpty( intent.getAction() ) ) {
            return false;
        }
        switch ( intent.getAction() ) {
            case ACTION_NEW_TIMER:
                onNewTimer( intent.getParcelableExtra( EXTRA_TIMER ) );
                return true;

            case ACTION_CANCEL_TIMERS:
                onCancelTimers();
                return true;

            default:
                return false;
        }
    }

    private void onCancelTimers() {
        for ( int i = 0, size = mTimers.size(); i < size; ++i ) {
            mTimers.get( i ).cancel();
        }
        if ( isViewAttached() ) {
            getMvpView().onTimersCanceled();
        }
    }

    private void onNewTimer( CookingStepTimer timer ) {
        timer.setListener( this );
        mTimers.add( timer );
        timer.start();
    }


    @Override
    public void onTick( int step, Timer t, long remainingMillis ) {
        if ( isViewAttached() ) {
            getMvpView().onTimerUpdated( step, t.getDescription(), remainingMillis / 1000 );
        }
    }

    @Override
    public void onFinish( int step, Timer t ) {
        if ( isViewAttached() ) {
            getMvpView().onTimerFinished( step, t.getDescription() );
        }
    }
}
