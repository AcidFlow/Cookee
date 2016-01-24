package info.acidflow.cookee.ui.recipe.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import info.acidflow.cookee.CookeeApplication;
import info.acidflow.cookee.R;
import info.acidflow.cookee.rest.api.CookeeApi;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.recipe.fragment.RecipeFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by paul on 21/01/16.
 */
public class RecipeActivity extends BaseActivity {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recipe );
        if( savedInstanceState == null ){
            getSupportFragmentManager().beginTransaction()
                .add( R.id.fragment_container_recipe, RecipeFragment.newInstance( "1" ) )
                .commit();
        }
    }
}
