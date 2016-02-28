package info.acidflow.cookee.format;

import android.content.Context;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;

/**
 * Created by paul on 31/01/16.
 */
abstract class AbstractFormatter< T > {

    private final Context mContext;

    public AbstractFormatter( @ApplicationContext Context context ) {
        super();
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    public abstract String format( T toFormat );
}
