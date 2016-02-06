package info.acidflow.cookee.injection.component;

import dagger.Component;
import info.acidflow.cookee.injection.module.FragmentModule;
import info.acidflow.cookee.injection.scope.FragmentScope;
import info.acidflow.cookee.ui.recipe.fragment.RecipeFragment;
import info.acidflow.cookee.ui.recipe.fragment.ingredient.IngredientsFragment;
import info.acidflow.cookee.ui.recipe.fragment.steps.StepsFragment;

/**
 * Created by paul on 23/01/16.
 */
@FragmentScope
@Component(dependencies = {ActivityComponent.class}, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject( RecipeFragment fragment );
    void inject( IngredientsFragment fragment );
    void inject( StepsFragment fragment );
}
