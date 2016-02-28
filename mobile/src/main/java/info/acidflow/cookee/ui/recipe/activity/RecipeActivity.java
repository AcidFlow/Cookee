package info.acidflow.cookee.ui.recipe.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import info.acidflow.cookee.R;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.recipe.fragment.RecipeFragment;

/**
 * Created by paul on 21/01/16.
 */
public class RecipeActivity extends BaseActivity {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recipe );
        if ( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction()
                    .add( R.id.fragment_container_recipe, RecipeFragment.newInstance( "2" ) )
                    .commit();
        }
    }
}
