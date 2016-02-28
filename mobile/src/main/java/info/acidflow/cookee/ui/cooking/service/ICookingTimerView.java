package info.acidflow.cookee.ui.cooking.service;

import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 27/02/16.
 */
public interface ICookingTimerView extends IMvpView {

    void onTimerFinished( int step, String timerDescription );

    void onTimerUpdated( int step, String timerDescription, long remainingSec );

    void onTimersCanceled();

}
