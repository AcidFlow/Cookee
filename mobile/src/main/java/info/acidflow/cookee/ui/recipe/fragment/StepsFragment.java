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
import info.acidflow.cookee.R;
import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.adapter.step.StepAdapter;
import info.acidflow.cookee.ui.base.fragment.BaseViewPagerFragment;

/**
 * Created by paul on 25/01/16.
 */
public class StepsFragment extends BaseViewPagerFragment {

    private static final String ARGS_STEPS = "args_ingredients";

    @Bind( R.id.recycler_ingredients )
    RecyclerView mRecyclerView;

    private StepAdapter mAdapter;

    public static StepsFragment newInstance( ArrayList< Step > steps ) {
        Bundle args = new Bundle();
        args.putParcelableArrayList( ARGS_STEPS, steps );
        StepsFragment fragment = new StepsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_recipe_ingredients, container, false );
        ButterKnife.bind( this, view );
        mAdapter = new StepAdapter();
        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        mRecyclerView.setAdapter( mAdapter );
        mAdapter.setItems( getArguments().getParcelableArrayList( ARGS_STEPS ) );
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
        return R.string.tab_title_recipe;
    }
}
