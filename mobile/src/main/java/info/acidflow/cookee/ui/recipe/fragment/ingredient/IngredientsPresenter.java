package info.acidflow.cookee.ui.recipe.fragment.ingredient;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.base.BasePresenter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paul on 06/02/16.
 */
public class IngredientsPresenter extends BasePresenter<IIngredientsView> {

    private List<Ingredient> mIngredients;
    private Subscription mIngredientSubscription;

    @Inject
    public IngredientsPresenter() {
        super();
    }

    public void setIngredients( List< Ingredient > ingredients ) {
        mIngredients = ingredients;
    }

    public void loadIngredients(){
        mIngredientSubscription = Observable.from( mIngredients )
                .delay( 500, TimeUnit.MILLISECONDS )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( this::addIngredient );
    }

    private void addIngredient(Ingredient ingredient){
        if( isViewAttached() ){
            getMvpView().addIngredient( ingredient );
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        mIngredientSubscription.unsubscribe();
    }
}
