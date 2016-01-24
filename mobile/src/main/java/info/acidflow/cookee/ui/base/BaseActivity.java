package info.acidflow.cookee.ui.base;

import android.support.v7.app.AppCompatActivity;

import info.acidflow.cookee.CookeeApplication;
import info.acidflow.cookee.injection.component.ActivityComponent;
import info.acidflow.cookee.injection.component.DaggerActivityComponent;
import info.acidflow.cookee.injection.module.ActivityModule;

/**
 * Created by paul on 23/01/16.
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent( CookeeApplication.get( this ).getComponent() )
                    .activityModule( new ActivityModule( this ) )
                    .build();
        }
        return mActivityComponent;
    }

}
