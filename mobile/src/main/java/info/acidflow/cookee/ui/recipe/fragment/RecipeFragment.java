package info.acidflow.cookee.ui.recipe.fragment;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.acidflow.cookee.R;
import info.acidflow.cookee.injection.component.DaggerFragmentComponent;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.recipe.IRecipeView;
import info.acidflow.cookee.ui.recipe.RecipePresenter;
import info.acidflow.cookee.ui.recipe.adapter.RecipePagerAdapter;

/**
 * Created by paul on 23/01/16.
 */
public class RecipeFragment extends Fragment
        implements IRecipeView, TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    public static final String ARGS_RECIPE_ID = "args_recipe_id";

    @Inject
    RecipePresenter mPresenter;

    @Bind( R.id.recipe_name )
    TextView mRecipeTitle;

    @Bind( R.id.recipe_difficulty )
    TextView mRecipeDifficulty;

    @Bind( R.id.recipe_people )
    TextView mRecipePeople;

    @Bind( R.id.recipe_price )
    TextView mRecipePrice;

    @Bind( R.id.recipe_type )
    TextView mRecipeType;

    @Bind( R.id.recipe_cooking_time )
    TextView mRecipeCookingTime;

    @Bind( R.id.recipe_preparation_time )
    TextView mRecipePreparationTime;

    @Bind( R.id.recipe_fab )
    FloatingActionButton mFloatingActionButton;

    @Bind( R.id.recipe_viewpager )
    ViewPager mViewPager;

    @Bind( R.id.tabs )
    TabLayout mTabs;


    public static RecipeFragment newInstance( String recipeId ) {
        Bundle args = new Bundle();
        args.putString( ARGS_RECIPE_ID, recipeId );
        RecipeFragment fragment = new RecipeFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        DaggerFragmentComponent.builder()
                .activityComponent( ( ( BaseActivity ) getActivity() ).getActivityComponent() )
                .build()
                .inject( this );
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View v = inflater.inflate( R.layout.fragment_recipe, container, false );
        ButterKnife.bind( this, v );
        return v;
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated( view, savedInstanceState );
        mPresenter.attachView( this );
        mViewPager.addOnPageChangeListener( this );
        mTabs.setOnTabSelectedListener( this );
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
        mPresenter.loadRecipe( getArguments().getString( ARGS_RECIPE_ID ) );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mViewPager.removeOnPageChangeListener( this );
        ButterKnife.unbind( this );
    }

    @Override
    public void onTabSelected( TabLayout.Tab tab ) {
        mPresenter.onTabSelected( tab.getPosition() );
    }

    @Override
    public void onTabUnselected( TabLayout.Tab tab ) {

    }

    @Override
    public void onTabReselected( TabLayout.Tab tab ) {

    }

    @Override
    public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels ) {

    }

    @Override
    public void onPageSelected( int position ) {
        mPresenter.onPageSelected( position );
    }

    @Override
    public void onPageScrollStateChanged( int state ) {

    }

    @Override
    public void setRecipe( Recipe r ) {
        mViewPager.setAdapter( new RecipePagerAdapter( getContext(), getFragmentManager(), r ) );
        mTabs.setTabsFromPagerAdapter( mViewPager.getAdapter() );
        mFloatingActionButton.show();
    }

    @Override
    public void setName( String name ) {
        mRecipeTitle.setText( name );
    }

    @Override
    public void setDifficulty( String difficulty ) {
        mRecipeDifficulty.setText( difficulty );
    }

    @Override
    public void setCost( String cost ) {
        mRecipePrice.setText( cost );
    }

    @Override
    public void setType( String type ) {
        mRecipeType.setText( type );
    }

    @Override
    public void setPrice( String price ) {
        mRecipePrice.setText( price );
    }

    @Override
    public void setPeople( String people ) {
        mRecipePeople.setText( people );
    }

    @Override
    public void selectTab( int position ) {
        mTabs.getTabAt( position ).select();
    }

    @Override
    public void selectPage( int position ) {
        mViewPager.setCurrentItem( position, true );
    }

    @Override
    public void setFabIcon( int position ) {
        @DrawableRes int drawableRes = -1;
        switch ( position ) {
            case 0:
                drawableRes = R.drawable.ic_group_black_24dp;
                break;
            case 1:
                drawableRes = R.drawable.ic_play_arrow_black_24dp;
                break;
        }
        mFloatingActionButton.setImageResource( drawableRes );
    }

    @Override
    @OnClick( R.id.recipe_fab )
    public void onFabClicked() {
        mPresenter.onFabClicked( mViewPager.getCurrentItem() );
    }
}
