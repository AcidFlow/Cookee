package info.acidflow.cookee.ui.adapter.ingredient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.acidflow.cookee.R;
import info.acidflow.cookee.format.QuantityFormatter;
import info.acidflow.cookee.model.Ingredient;
import info.acidflow.cookee.ui.adapter.base.BaseRecyclerViewAdapter;

/**
 * Created by paul on 24/01/16.
 */
public class IngredientAdapter extends BaseRecyclerViewAdapter<Ingredient, IngredientViewHolder> {

    private final QuantityFormatter mQuantityFormatter;

    public IngredientAdapter(QuantityFormatter quantityFormatter) {
        super();
        mQuantityFormatter = quantityFormatter;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        View v = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.list_item_ingredient, parent, false);
        return new IngredientViewHolder( v );
    }

    @Override
    public void onBindViewHolder( IngredientViewHolder holder, int position ) {
        holder.name.setText( getItem( position ).getName() );
        holder.quantity.setText( mQuantityFormatter.format( getItem( position ).getQuantity() ) );
    }
}
