package info.acidflow.cookee.ui.adapter.ingredient;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.acidflow.cookee.R;
import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.adapter.base.RecyclerViewCardBaseAdapter;

/**
 * Created by paul on 24/01/16.
 */
public class IngredientAdapter extends RecyclerViewCardBaseAdapter<Ingredient> {

    public IngredientAdapter( Context context, @LayoutRes int layoutResPlaceHolder,
                              @LayoutRes int layoutResCardHeader,
                              @LayoutRes int layoutResCardFooter ) {
        super( context, layoutResPlaceHolder, layoutResCardHeader, layoutResCardFooter );
    }

    @Override
    protected ViewHolder onCreateContentItemViewHolder( ViewGroup parent, int contentViewType ) {
        View v = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.list_item_ingredient, parent, false);
        return new IngredientViewHolder( v );
    }

    @Override
    protected void onBindContentItemViewHolder( ViewHolder contentViewHolder, int position ) {
        ((IngredientViewHolder)contentViewHolder).name.setText( getItem( position ).getName() );
    }
}
