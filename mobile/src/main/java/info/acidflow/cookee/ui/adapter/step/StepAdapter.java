package info.acidflow.cookee.ui.adapter.step;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import info.acidflow.cookee.R;
import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.adapter.base.BaseRecyclerViewAdapter;

/**
 * Created by paul on 24/01/16.
 */
public class StepAdapter extends BaseRecyclerViewAdapter<Step, StepViewHolder > {

    @Inject
    public StepAdapter(){
        super();
    }

    @Override
    public StepViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        View v = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.list_item_step, parent, false);
        return new StepViewHolder( v );
    }

    @Override
    public void onBindViewHolder( StepViewHolder holder, int position ) {
        holder.description.setText( getItem( position ).getStepDescription() );
    }
}
