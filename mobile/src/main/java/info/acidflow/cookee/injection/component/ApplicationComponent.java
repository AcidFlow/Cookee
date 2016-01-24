package info.acidflow.cookee.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import info.acidflow.cookee.injection.module.ApplicationModule;
import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.rest.api.CookeeApi;

/**
 * Created by paul on 23/01/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();
    CookeeApi getCookeApi();
}
