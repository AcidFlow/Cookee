package info.acidflow.cookee.ui.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 28/01/16.
 */
public abstract class BaseRecyclerViewAdapter< T, VH extends RecyclerView.ViewHolder > extends RecyclerView.Adapter< VH > {

    private List< T > mItems;

    public BaseRecyclerViewAdapter() {
        super();
        mItems = new ArrayList<>();
    }

    public void addItem( T item ) {
        mItems.add( item );
    }

    public void setItems( List< T > items ) {
        mItems = items;
    }

    public List< T > getItems() {
        return mItems;
    }

    public T getItem( int position ) {
        return mItems.get( position );
    }

    @Override
    public abstract VH onCreateViewHolder( ViewGroup parent, int viewType );

    @Override
    public abstract void onBindViewHolder( VH holder, int position );

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }
}
