package info.acidflow.cookee.ui.cooking.service;

import android.content.Intent;
import android.text.TextUtils;

import javax.inject.Inject;

import info.acidflow.cookee.cooking.CookingStepTimer;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.base.BasePresenter;

/**
 * Created by paul on 27/02/16.
 */
public class CookingPresenter extends BasePresenter< ICookingView > {

    public static final String EXTRA_RECIPE = "extra_recipe";
    public static final String START_COOKING = "start_cooking";
    public static final String NEXT_STEP = "next_step";
    public static final String CANCEL = "cancel";

    private Recipe mRecipe;
    private int mCurrentStep;

    @Inject
    public CookingPresenter() {

    }

    public boolean onActionReceived( Intent intent ) {
        if ( intent == null || TextUtils.isEmpty( intent.getAction() ) ) {
            return false;
        }
        switch ( intent.getAction() ) {
            case START_COOKING:
                mRecipe = intent.getParcelableExtra( EXTRA_RECIPE );
                mCurrentStep = 0;
                onCookingSessionStarted();
                return true;

            case NEXT_STEP:
                onNextStepRequested();
                return true;

            case CANCEL:
                onCookingSessionCanceled();
                return true;

            default:
                return false;
        }
    }

    protected void onCookingSessionStarted() {
        notifyStep();
    }

    protected void onNextStepRequested() {
        if ( mRecipe.getSteps().get( mCurrentStep ).hasTimer() ) {
            addTimer( mCurrentStep, mRecipe.getSteps().get( mCurrentStep ) );
        }
        mCurrentStep++;
        if ( mCurrentStep < mRecipe.getSteps().size() ) {
            notifyStep();
        } else {
            notifyFinished();
        }
    }

    private void notifyStep() {
        if ( isViewAttached() ) {
            getMvpView().onNextCookingStep( mRecipe.getSteps().size(), mCurrentStep,
                    mRecipe.getSteps().get( mCurrentStep ).getStepDescription() );
        }
    }

    private void notifyFinished() {
        if ( isViewAttached() ) {
            getMvpView().onCookingFinished();
        }
    }


    protected void onCookingSessionCanceled() {
        if ( isViewAttached() ) {
            getMvpView().onCookingCanceled();
        }
    }

    protected void addTimer( final int currentStep, final Step step ) {
        if ( isViewAttached() ) {
            getMvpView().onAddTimer( new CookingStepTimer( currentStep, step.getTimer() ) );
        }
    }

}
