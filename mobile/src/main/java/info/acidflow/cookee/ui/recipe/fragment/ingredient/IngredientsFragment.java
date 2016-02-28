package info.acidflow.cookee.ui.recipe.fragment.ingredient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.acidflow.cookee.R;
import info.acidflow.cookee.injection.component.DaggerFragmentComponent;
import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.adapter.ingredient.IngredientAdapter;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.base.fragment.BaseViewPagerFragment;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by paul on 25/01/16.
 */
public class IngredientsFragment extends BaseViewPagerFragment implements IIngredientsView {

    private static final String ARGS_INGREDIENTS = "args_ingredients";

    @Bind( R.id.recycler_ingredients )
    RecyclerView mRecyclerView;

    @Inject
    IngredientsPresenter mPresenter;

    @Inject
    IngredientAdapter mAdapter;


    public static IngredientsFragment newInstance( ArrayList< Ingredient > ingredients ) {
        Bundle args = new Bundle();
        args.putParcelableArrayList( ARGS_INGREDIENTS, ingredients );
        IngredientsFragment fragment = new IngredientsFragment();
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
        mPresenter.setIngredients( getArguments().getParcelableArrayList( ARGS_INGREDIENTS ) );
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_recipe_ingredients, container, false );
        ButterKnife.bind( this, view );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        mRecyclerView.setItemAnimator( new SlideInUpAnimator() );
        mRecyclerView.setAdapter( mAdapter );
        return view;
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated( view, savedInstanceState );
        mPresenter.attachView( this );
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
        mPresenter.loadIngredients();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        ButterKnife.unbind( this );
    }

    @Override
    public int getTitle() {
        return R.string.tab_title_ingredients;
    }

    @Override
    public void addIngredient( Ingredient ingredient ) {
        mAdapter.addItem( ingredient );
        mAdapter.notifyItemInserted( 0 );
    }
}
