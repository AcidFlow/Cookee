package info.acidflow.cookee.ui.cooking.service;

import info.acidflow.cookee.cooking.CookingStepTimer;
import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 27/02/16.
 */
public interface ICookingView extends IMvpView {

    void onNextCookingStep( int totalSteps, int currentStep, String text );

    void onCookingFinished();

    void onCookingCanceled();

    void onAddTimer( CookingStepTimer t );

}
