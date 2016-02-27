package info.acidflow.cookee.ui.recipe;

import android.util.Log;

import javax.inject.Inject;

import info.acidflow.cookee.format.CostFormatter;
import info.acidflow.cookee.format.DifficultyFormatter;
import info.acidflow.cookee.format.MealTypeFormatter;
import info.acidflow.cookee.format.PeopleCountFormatter;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.rest.api.CookeeApi;
import info.acidflow.cookee.ui.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by paul on 23/01/16.
 */
public class RecipePresenter extends BasePresenter< IRecipeView > {

    private final CostFormatter mCostFormatter;
    private final MealTypeFormatter mMealTypeFormatter;
    private final DifficultyFormatter mDifficultyFormatter;
    private final PeopleCountFormatter mPeopleCountFormatter;
    private final CookeeApi mApi;

    private Recipe mRecipe;

    @Inject
    public RecipePresenter( CookeeApi api, CostFormatter costFormatter, MealTypeFormatter mealTypeFormatter,
                            DifficultyFormatter difficultyFormatter, PeopleCountFormatter peopleCountFormatter ) {
        super();
        mApi = api;
        mCostFormatter = costFormatter;
        mMealTypeFormatter = mealTypeFormatter;
        mDifficultyFormatter = difficultyFormatter;
        mPeopleCountFormatter = peopleCountFormatter;
    }

    public void loadRecipe( String recipeId ) {
        mApi.getRecipe( recipeId )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( this::onRecipeLoaded, this::onLoadRecipeError );

    }

    private void onRecipeLoaded( Recipe r ) {
        mRecipe = r;
        if ( isViewAttached() ) {
            getMvpView().setRecipe( r );
            getMvpView().setName( r.getName() );
            getMvpView().setCost( mCostFormatter.format( r.getCost() ) );
            getMvpView().setDifficulty( mDifficultyFormatter.format( r.getDifficulty() ) );
            getMvpView().setPeople( mPeopleCountFormatter.format( r.getPeopleCount() ) );
            getMvpView().setType( mMealTypeFormatter.format( r.getType() ) );
        }
    }

    private void onLoadRecipeError( Throwable error ) {
        Log.e( getClass().getName(), "Error", error );
    }

    public void onPageSelected( int position ) {
        getMvpView().selectTab( position );
        getMvpView().setFabIcon( position );
    }

    public void onTabSelected( int position ) {
        getMvpView().selectPage( position );
        getMvpView().setFabIcon( position );
    }

    public void onFabClicked( int currentPosition ) {
        if(currentPosition == 1){
            getMvpView().startCooking(mRecipe);
        }
        Timber.d( "Clicked FAB on tab %d", currentPosition );
    }

}
