package info.acidflow.cookee.injection.component;

import dagger.Component;
import info.acidflow.cookee.injection.module.ActivityModule;
import info.acidflow.cookee.injection.scope.ActivityScope;
import info.acidflow.cookee.rest.api.CookeeApi;

/**
 * Created by paul on 23/01/16.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    CookeeApi getCookeApi();
}
