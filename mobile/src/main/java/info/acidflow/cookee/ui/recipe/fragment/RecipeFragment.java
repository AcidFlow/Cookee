package info.acidflow.cookee.ui.recipe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.acidflow.cookee.R;
import info.acidflow.cookee.injection.component.DaggerFragmentComponent;
import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.ui.adapter.ingredient.IngredientAdapter;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.recipe.IRecipeView;
import info.acidflow.cookee.ui.recipe.RecipePresenter;

/**
 * Created by paul on 23/01/16.
 */
public class RecipeFragment extends Fragment implements IRecipeView {

    public static final String ARGS_RECIPE_ID = "args_recipe_id";

    @Inject
    RecipePresenter mPresenter;

    private IngredientAdapter mAdapter;

    @Bind( R.id.recycler_ingredients )
    RecyclerView mRecyclerView;

    @Bind( R.id.recipe_name )
    TextView mRecipeTitle;

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
                .activityComponent( ( (BaseActivity ) getActivity() ).getActivityComponent() )
                .build()
                .inject( this );
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View v = inflater.inflate( R.layout.fragment_recipe, container, false );
        ButterKnife.bind( this, v );
        mAdapter = new IngredientAdapter(getContext(), R.layout.list_item_card_placeholder, R.layout.list_item_card_header, R.layout.list_item_card_footer);
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        mRecyclerView.setAdapter( mAdapter );
        return v;
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated( view, savedInstanceState );
        mPresenter.attachView( this );
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.loadRecipe( getArguments().getString( ARGS_RECIPE_ID ) );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        ButterKnife.unbind( this );
    }

    @Override
    public void showRecipe( Recipe r ) {
        mRecipeTitle.setText( r.getName() );
        List<Ingredient> l = new ArrayList<>(  );
        for(int i = 0; i < 10; ++i){
            l.addAll( r.getIngredientList() );
        }
        mAdapter.setItems( l );
        mAdapter.notifyDataSetChanged();
    }
}
