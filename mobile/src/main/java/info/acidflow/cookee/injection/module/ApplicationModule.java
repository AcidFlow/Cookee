package info.acidflow.cookee.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.rest.api.CookeeApi;

/**
 * Created by paul on 23/01/16.
 */
@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule( Application application ) {
        super();
        mApplication = application;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    @Singleton
    CookeeApi provideCookeeApi(){
        return new CookeeApi();
    }
}
