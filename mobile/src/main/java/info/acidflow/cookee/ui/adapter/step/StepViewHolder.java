package info.acidflow.cookee.ui.adapter.step;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.acidflow.cookee.R;

/**
 * Created by paul on 24/01/16.
 */
public class StepViewHolder extends RecyclerView.ViewHolder {

    @Bind( R.id.description )
    TextView description;

    public StepViewHolder( View itemView ) {
        super( itemView );
        ButterKnife.bind( this, itemView );
    }
}
