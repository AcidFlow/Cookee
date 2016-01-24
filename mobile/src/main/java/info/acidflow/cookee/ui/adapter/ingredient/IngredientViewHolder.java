package info.acidflow.cookee.ui.adapter.ingredient;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.acidflow.cookee.R;

/**
 * Created by paul on 24/01/16.
 */
public class IngredientViewHolder extends RecyclerView.ViewHolder {

    @Bind( R.id.name )
    TextView name;

    public IngredientViewHolder( View itemView ) {
        super( itemView );
        ButterKnife.bind( this, itemView );
    }
}
