package info.acidflow.cookee;

import android.app.Application;
import android.content.Context;

import info.acidflow.cookee.injection.component.ApplicationComponent;
import info.acidflow.cookee.injection.component.DaggerApplicationComponent;
import info.acidflow.cookee.injection.module.ApplicationModule;

/**
 * Created by paul on 23/01/16.
 */
public class CookeeApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule( new ApplicationModule( this ) )
                .build();
    }

    public static CookeeApplication get( Context context ) {
        return ( CookeeApplication ) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent( ApplicationComponent applicationComponent ) {
        mApplicationComponent = applicationComponent;
    }
}
