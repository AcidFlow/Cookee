package info.acidflow.cookee.ui.recipe;

import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 23/01/16.
 */
public interface IRecipeView extends IMvpView{

    void showRecipe( Recipe r );
}
