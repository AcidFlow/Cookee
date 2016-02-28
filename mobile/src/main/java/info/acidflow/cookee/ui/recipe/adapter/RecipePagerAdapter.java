package info.acidflow.cookee.ui.recipe.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.base.fragment.BaseViewPagerFragment;
import info.acidflow.cookee.ui.recipe.fragment.ingredient.IngredientsFragment;
import info.acidflow.cookee.ui.recipe.fragment.steps.StepsFragment;

/**
 * Created by paul on 25/01/16.
 */
public class RecipePagerAdapter extends FragmentStatePagerAdapter {

    private List< BaseViewPagerFragment > mFragments;
    private Context mContext;

    public RecipePagerAdapter( Context context, FragmentManager fm, Recipe recipe ) {
        super( fm );
        mContext = context;
        mFragments = new ArrayList<>( 3 );
        mFragments.add( IngredientsFragment.newInstance(
                ( ArrayList< Ingredient > ) recipe.getIngredientList() )
        );
        mFragments.add( StepsFragment.newInstance(
                ( ArrayList< Step > ) recipe.getSteps() )
        );
    }

    @Override
    public Fragment getItem( int position ) {
        return mFragments.get( position );
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle( int position ) {
        return mContext.getString( mFragments.get( position ).getTitle() );
    }
}
