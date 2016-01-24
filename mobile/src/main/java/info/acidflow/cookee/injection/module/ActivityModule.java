package info.acidflow.cookee.injection.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.acidflow.cookee.injection.qualifier.ActivityContext;
import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.rest.api.CookeeApi;

/**
 * Created by paul on 23/01/16.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule( Activity activity ) {
        super();
        mActivity = activity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

}
