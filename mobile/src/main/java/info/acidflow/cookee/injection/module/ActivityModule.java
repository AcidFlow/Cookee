package info.acidflow.cookee.injection.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import info.acidflow.cookee.injection.qualifier.ActivityContext;

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
