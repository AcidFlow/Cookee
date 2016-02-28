package info.acidflow.cookee.ui.cooking.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import javax.inject.Inject;

import info.acidflow.cookee.CookeeApplication;
import info.acidflow.cookee.R;
import info.acidflow.cookee.cooking.CookingStepTimer;

/**
 * Created by paul on 27/02/16.
 */
public class CookingService extends Service implements ICookingView {

    private static final int COOKING_STEP_NOTIFICATION_ID = 1;
    private static final int COOKING_FINISHED_NOTIFICATION_ID = 2;

    private NotificationManagerCompat mNotificationManager;

    @Inject
    CookingPresenter mPresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = NotificationManagerCompat.from( this );
        CookeeApplication.get( this ).getComponent().inject( this );
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
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onNextCookingStep( int totalSteps, int step, String text ) {
        mNotificationManager.cancel( COOKING_STEP_NOTIFICATION_ID );

        Intent nextStepIntent = new Intent( CookingPresenter.NEXT_STEP );
        nextStepIntent.setClass( this, CookingService.class );
        PendingIntent pendingIntent = PendingIntent.getService( this, 0, nextStepIntent, 0 );

        Intent cancelIntent = new Intent( CookingPresenter.CANCEL );
        nextStepIntent.setClass( this, CookingService.class );
        PendingIntent pendingCancelIntent = PendingIntent.getService( this, 0, cancelIntent, 0 );


        String title = getResources().getString(
                R.string.notification_cooking_step_progress, step, totalSteps );

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText( text );
        style.setBigContentTitle( title );

        NotificationCompat.Action.Builder doneAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_done_black_24dp,
                getString( R.string.notification_action_cooking_step_done ),
                pendingIntent
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder( this );
        builder.setContentTitle( title )
                .setContentText( text )
                .setPriority( Notification.PRIORITY_DEFAULT )
                .setSmallIcon( R.drawable.ic_cookee_chef_24dp )
                .setDefaults( step == 0 ? Notification.DEFAULT_VIBRATE : 0 )
                .addAction( doneAction.build() )
                .setDeleteIntent( pendingCancelIntent )
                .setStyle( style )
                .extend( new NotificationCompat.WearableExtender()
                        .setHintScreenTimeout(
                                NotificationCompat.WearableExtender.SCREEN_TIMEOUT_SHORT
                        )
                        .setBackground( BitmapFactory.decodeResource(
                                getResources(), R.drawable.background_wear_notification )
                        )
                );
        mNotificationManager.notify( COOKING_STEP_NOTIFICATION_ID, builder.build() );
    }

    @Override
    public void onCookingFinished() {
        mNotificationManager.cancel( COOKING_STEP_NOTIFICATION_ID );
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this );
        builder.setContentTitle( getString( R.string.notification_cooking_finished_title ) )
                .setContentText( getString( R.string.notification_cooking_finished_message ) )
                .setSmallIcon( R.drawable.ic_cookee_chef_24dp )
                .extend( new NotificationCompat.WearableExtender()
                        .setHintScreenTimeout(
                                NotificationCompat.WearableExtender.SCREEN_TIMEOUT_SHORT
                        )
                        .setBackground( BitmapFactory.decodeResource(
                                getResources(), R.drawable.background_wear_notification )
                        )
                );
        mNotificationManager.notify( COOKING_FINISHED_NOTIFICATION_ID, builder.build() );
        stopSelf();
    }

    @Override
    public void onCookingCanceled() {
        mNotificationManager.cancel( COOKING_STEP_NOTIFICATION_ID );
        mNotificationManager.cancel( COOKING_FINISHED_NOTIFICATION_ID );
        Intent intent = new Intent( this, CookingTimerService.class );
        intent.setAction( CookingTimerPresenter.ACTION_CANCEL_TIMERS );
        startService( intent );
        stopSelf();
    }

    @Override
    public void onAddTimer( CookingStepTimer t ) {
        Intent intent = new Intent( this, CookingTimerService.class );
        intent.setAction( CookingTimerPresenter.ACTION_NEW_TIMER );
        intent.putExtra( CookingTimerPresenter.EXTRA_TIMER, t );
        startService( intent );
    }
}
