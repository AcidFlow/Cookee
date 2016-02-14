package info.acidflow.cookee.ui.widget.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class ScrollAwareFabBehavior extends FloatingActionButton.Behavior {

    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();
    private final long mInAnimationDuration;
    private final long mOutAnimationDuration;

    public ScrollAwareFabBehavior( Context context, AttributeSet attrs ) {
        super();
        Resources res = context.getResources();
        mInAnimationDuration = res.getInteger( android.R.integer.config_shortAnimTime );
        mOutAnimationDuration = res.getInteger( android.R.integer.config_shortAnimTime );
    }

    @Override
    public boolean onStartNestedScroll( CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                                        View directTargetChild, View target, int nestedScrollAxes ) {
        // Ensure we react to vertical scrolling
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll( coordinatorLayout, child, directTargetChild, target, nestedScrollAxes );
    }

    @Override
    public void onNestedScroll( CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                                View target, int dxConsumed, int dyConsumed,
                                int dxUnconsumed, int dyUnconsumed ) {
        super.onNestedScroll( coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed );
        if ( dyConsumed > 0 ) {
            // User scrolled down and the FAB is currently visible -> hide the FAB
            animateOut( child );
        } else if ( dyConsumed < 0 ) {
            // User scrolled up and the FAB is currently not visible -> show the FAB
            animateIn( child );
        }
    }

    @Override
    public boolean onNestedFling( CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                                  View target, float velocityX, float velocityY, boolean consumed ) {
        if ( velocityY > 0 ) {
            animateOut( child );
        } else if ( velocityY < 0 ) {
            animateIn( child );
        }
        return super.onNestedFling( coordinatorLayout, child, target, velocityX, velocityY, consumed );
    }

    private void animateOut( FloatingActionButton fab ) {
        ViewGroup.MarginLayoutParams lp = ( ViewGroup.MarginLayoutParams ) fab.getLayoutParams();
        fab.animate()
                .translationY( fab.getHeight() + lp.bottomMargin )
                .setDuration( mOutAnimationDuration )
                .setInterpolator( INTERPOLATOR )
                .start();
    }

    private void animateIn( FloatingActionButton fab ) {
        fab.animate()
                .translationY( 0 )
                .setDuration( mInAnimationDuration )
                .setInterpolator( INTERPOLATOR )
                .start();
    }
}