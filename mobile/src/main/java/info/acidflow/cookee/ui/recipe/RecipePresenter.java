package info.acidflow.cookee.ui.recipe;

import javax.inject.Inject;

import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.rest.api.CookeeApi;
import info.acidflow.cookee.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paul on 23/01/16.
 */
public class RecipePresenter extends BasePresenter<IRecipeView> {

    private final CookeeApi mApi;

    @Inject
    public RecipePresenter( CookeeApi api ) {
        super();
        mApi = api;
    }

    public void loadRecipe( String recipeId ) {
        mApi.getRecipe( recipeId )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( this::onRecipeLoaded );
    }

    private void onRecipeLoaded( Recipe r ) {
        if ( isViewAttached() ) {
            getMvpView().showRecipe( r );
        }
    }
}
