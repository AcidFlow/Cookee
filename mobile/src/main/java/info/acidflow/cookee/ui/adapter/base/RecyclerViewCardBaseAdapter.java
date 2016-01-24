package info.acidflow.cookee.ui.adapter.base;

import android.content.Context;
import android.support.annotation.LayoutRes;

import java.util.List;

import info.acidflow.cookee.ui.adapter.RecyclerViewCardAdapter;

/**
 * Created by paul on 24/01/16.
 */
public abstract class RecyclerViewCardBaseAdapter<T> extends RecyclerViewCardAdapter {

    private List<T> mItems;

    protected RecyclerViewCardBaseAdapter( Context context, @LayoutRes int layoutResPlaceHolder,
                                        @LayoutRes int layoutResCardHeader,
                                        @LayoutRes int layoutResCardFooter ) {
        super( context, layoutResPlaceHolder, layoutResCardHeader, layoutResCardFooter );
    }

    public void setItems( List<T> items ){
        mItems = items;
    }

    @Override
    protected int getContentItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public List<T> getItems(){
        return mItems;
    }

    public T getItem( int position ){
        return mItems.get( position );
    }
}
