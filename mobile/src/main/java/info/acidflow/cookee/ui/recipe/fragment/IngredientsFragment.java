package info.acidflow.cookee.ui.recipe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.acidflow.cookee.CookeeApplication;
import info.acidflow.cookee.R;
import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.adapter.ingredient.IngredientAdapter;
import info.acidflow.cookee.ui.base.fragment.BaseViewPagerFragment;

/**
 * Created by paul on 25/01/16.
 */
public class IngredientsFragment extends BaseViewPagerFragment {

    private static final String ARGS_INGREDIENTS = "args_ingredients";

    @Bind( R.id.recycler_ingredients )
    RecyclerView mRecyclerView;

    private IngredientAdapter mAdapter;

    public static IngredientsFragment newInstance( ArrayList< Ingredient > ingredients ) {
        Bundle args = new Bundle();
        args.putParcelableArrayList( ARGS_INGREDIENTS, ingredients );
        IngredientsFragment fragment = new IngredientsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_recipe_ingredients, container, false );
        ButterKnife.bind( this, view );
        mAdapter = new IngredientAdapter( CookeeApplication.get( getContext() )
                .getComponent().getQuantityFormatter()
        );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        mRecyclerView.setAdapter( mAdapter );
        mAdapter.setItems( getArguments().getParcelableArrayList( ARGS_INGREDIENTS ) );
        mAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind( this );
    }

    @Override
    public int getTitle() {
        return R.string.tab_title_ingredients;
    }
}
