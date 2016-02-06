package info.acidflow.cookee.ui.recipe.fragment.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.base.BasePresenter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paul on 06/02/16.
 */
public class StepsPresenter extends BasePresenter<IStepsView> {

    private List<Step> mSteps;
    private Subscription mStepsSubscription;

    @Inject
    public StepsPresenter() {
        super();
    }

    public void setSteps( List< Step > steps ) {
        mSteps = steps;
    }

    public void loadSteps(){
        mStepsSubscription = Observable.from( mSteps )
                .delay( 500, TimeUnit.MILLISECONDS )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( this::addStep );
    }

    private void addStep(Step step){
        if( isViewAttached() ){
            getMvpView().addStep( step );
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        mStepsSubscription.unsubscribe();
    }
}
