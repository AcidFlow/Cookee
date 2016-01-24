package info.acidflow.cookee.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paul on 24/01/16.
 */
public abstract class RecyclerViewCardAdapter extends HeaderFooterRecyclerViewAdapter {

    private final int HEADER_VIEW_TYPE_PLACEHOLDER = 0;
    private final int HEADER_VIEW_TYPE_CARD_HEADER = 1;
    private final int FOOTER_VIEW_TYPE_CARD_FOOTER = 0;

    @LayoutRes
    private final int mLayoutResPlaceHolder;

    @LayoutRes
    private final int mLayoutResCardHeader;

    @LayoutRes
    private final int mLayoutResCardFooter;

    protected RecyclerViewCardAdapter( Context context,
                                    @LayoutRes int layoutResPlaceHolder,
                                    @LayoutRes int layoutResCardHeader,
                                    @LayoutRes int layoutResCardFooter ) {
        super();
        mLayoutResPlaceHolder = layoutResPlaceHolder;
        mLayoutResCardHeader = layoutResCardHeader;
        mLayoutResCardFooter = layoutResCardFooter;
    }

    @Override
    protected int getHeaderItemCount() {
        return 2;
    }

    @Override
    protected int getFooterItemCount() {
        return 1;
    }

    @Override
    protected int getHeaderItemViewType( int position ) {
        if( position == 0 ){
            return HEADER_VIEW_TYPE_PLACEHOLDER;
        } else if( position == 1 ){
            return HEADER_VIEW_TYPE_CARD_HEADER;
        }
        return super.getHeaderItemViewType( position );
    }

    @Override
    protected int getFooterItemViewType( int position ) {
        if( position == getItemCount() - 1 ){
            return FOOTER_VIEW_TYPE_CARD_FOOTER;
        }
        return super.getFooterItemViewType( position );
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderItemViewHolder( ViewGroup parent, int headerViewType ) {
        View v;
        switch ( headerViewType ){
            case HEADER_VIEW_TYPE_PLACEHOLDER:
                v = LayoutInflater.from( parent.getContext() )
                        .inflate( mLayoutResPlaceHolder, parent, false );
                return new HeaderPlaceHolderViewHolder( v );
            case HEADER_VIEW_TYPE_CARD_HEADER:
                v = LayoutInflater.from( parent.getContext() )
                        .inflate( mLayoutResCardHeader, parent, false );
                return new HeaderCardViewHolder( v );
            default:
                throw new IllegalArgumentException( "Unknown header view type" );
        }
    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterItemViewHolder( ViewGroup parent, int footerViewType ) {
        View v;
        switch ( footerViewType ){
            case FOOTER_VIEW_TYPE_CARD_FOOTER:
                v = LayoutInflater.from( parent.getContext() )
                        .inflate( mLayoutResCardFooter, parent, false );
                return new FooterCardViewHolder( v );
            default:
                throw new IllegalArgumentException( "Unknown header view type" );
        }
    }

    @Override
    protected void onBindHeaderItemViewHolder( RecyclerView.ViewHolder headerViewHolder, int position ) {

    }

    @Override
    protected void onBindFooterItemViewHolder( RecyclerView.ViewHolder footerViewHolder, int position ) {

    }

    static class HeaderPlaceHolderViewHolder extends RecyclerView.ViewHolder {

        public HeaderPlaceHolderViewHolder( View itemView ) {
            super( itemView );
        }
    }

    static class HeaderCardViewHolder extends RecyclerView.ViewHolder {

        public HeaderCardViewHolder( View itemView ) {
            super( itemView );
        }
    }

    static class FooterCardViewHolder extends RecyclerView.ViewHolder {

        public FooterCardViewHolder( View itemView ) {
            super( itemView );
        }
    }

}
