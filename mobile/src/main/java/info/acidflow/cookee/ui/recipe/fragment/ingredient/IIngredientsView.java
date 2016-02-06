package info.acidflow.cookee.ui.recipe.fragment.ingredient;

import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 06/02/16.
 */
public interface IIngredientsView extends IMvpView {

    void addIngredient( Ingredient ingredient);
}
