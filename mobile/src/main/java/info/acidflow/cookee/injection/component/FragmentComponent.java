package info.acidflow.cookee.injection.component;

import dagger.Component;
import info.acidflow.cookee.injection.module.ActivityModule;
import info.acidflow.cookee.injection.module.FragmentModule;
import info.acidflow.cookee.injection.scope.ActivityScope;
import info.acidflow.cookee.injection.scope.FragmentScope;
import info.acidflow.cookee.rest.api.CookeeApi;
import info.acidflow.cookee.ui.recipe.fragment.RecipeFragment;

/**
 * Created by paul on 23/01/16.
 */
@FragmentScope
@Component(dependencies = {ActivityComponent.class}, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject( RecipeFragment fragment );
}
