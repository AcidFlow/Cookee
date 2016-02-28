package info.acidflow.cookee.injection.module.rest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.acidflow.cookee.rest.api.CookeeApi;

/**
 * Created by paul on 31/01/16.
 */
@Module
public class CookeeApiModule {

    @Provides
    @Singleton
    CookeeApi provideCookeeApi() {
        return new CookeeApi();
    }
}
