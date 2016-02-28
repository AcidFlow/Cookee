package info.acidflow.cookee.ui.cooking.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import info.acidflow.cookee.R;

/**
 * Created by paul on 28/02/16.
 */
public class CookingTimerService extends Service implements ICookingTimerView {

    private static final int COOKING_TIMER_NOTIFICATION_ID = 100;
    private NotificationManagerCompat mNotificationManager;

    private CookingTimerPresenter mPresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = NotificationManagerCompat.from( this );
        mPresenter = new CookingTimerPresenter();
        mPresenter.attachView( this );
    }

    @Nullable
    @Override
    public IBinder onBind( Intent intent ) {
        return null;
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId ) {
        if ( mPresenter.onActionReceived( intent ) ) {
            return START_STICKY_COMPATIBILITY;
        }
        return super.onStartCommand( intent, flags, startId );
    }

    @Override
    public void onTimerFinished( int step, String timerDescription ) {
        mNotificationManager.cancel( COOKING_TIMER_NOTIFICATION_ID + step );
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this );
        builder.setContentTitle( getString( R.string.notification_cooking_timer_finished_title ) )
                .setContentText( timerDescription )
                .setSmallIcon( R.drawable.ic_cookee_chef_24dp )
                .setVibrate( new long[]{ 0, 800, 400, 800, 400, 800 } )
                .setPriority( Notification.PRIORITY_MAX )
                .setAutoCancel( true )
                .extend( new NotificationCompat.WearableExtender()
                        .setHintScreenTimeout(
                                NotificationCompat.WearableExtender.SCREEN_TIMEOUT_SHORT
                        )
                        .setBackground( BitmapFactory.decodeResource(
                                getResources(), R.drawable.background_wear_notification )
                        )
                );
        mNotificationManager.notify( COOKING_TIMER_NOTIFICATION_ID + step, builder.build() );
    }

    @Override
    public void onTimerUpdated( int step, String timerDescription, long remainingSec ) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this );
        builder.setContentTitle( getString(
                R.string.notification_cooking_timer_remaining_time_title, remainingSec )
        )
                .setContentText( timerDescription )
                .setSmallIcon( R.drawable.ic_cookee_chef_24dp )
                .setPriority( Notification.PRIORITY_LOW )
                .extend( new NotificationCompat.WearableExtender()
                        .setBackground( BitmapFactory.decodeResource(
                                getResources(), R.drawable.background_wear_notification )
                        )
                );
        mNotificationManager.notify( COOKING_TIMER_NOTIFICATION_ID + step, builder.build() );
    }

    @Override
    public void onTimersCanceled() {
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
