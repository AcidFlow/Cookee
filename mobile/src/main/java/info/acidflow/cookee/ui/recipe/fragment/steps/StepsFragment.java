package info.acidflow.cookee.ui.recipe.fragment.steps;

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
import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.adapter.step.StepAdapter;
import info.acidflow.cookee.ui.base.BaseActivity;
import info.acidflow.cookee.ui.base.fragment.BaseViewPagerFragment;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by paul on 25/01/16.
 */
public class StepsFragment extends BaseViewPagerFragment implements IStepsView {

    private static final String ARGS_STEPS = "args_ingredients";

    @Bind( R.id.recycler_steps )
    RecyclerView mRecyclerView;

    @Inject
    StepsPresenter mPresenter;

    @Inject
    StepAdapter mAdapter;

    public static StepsFragment newInstance( ArrayList< Step > steps ) {
        Bundle args = new Bundle();
        args.putParcelableArrayList( ARGS_STEPS, steps );
        StepsFragment fragment = new StepsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        DaggerFragmentComponent.builder()
                .activityComponent( ((BaseActivity) getActivity()).getActivityComponent() )
                .build()
                .inject( this );
        mPresenter.setSteps( getArguments().getParcelableArrayList( ARGS_STEPS ) );
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_recipe_steps, container, false );
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
        mPresenter.loadSteps();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        ButterKnife.unbind( this );
    }

    @Override
    public int getTitle() {
        return R.string.tab_title_recipe;
    }

    @Override
    public void addStep( Step step ) {
        mAdapter.addItem( step );
        mAdapter.notifyItemInserted( 0 );
    }
}
