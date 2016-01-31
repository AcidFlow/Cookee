package info.acidflow.cookee.format;

import android.content.Context;

import java.util.Locale;

import javax.inject.Inject;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;

/**
 * Created by paul on 31/01/16.
 */
public class PeopleCountFormatter extends AbstractFormatter<Integer> {

    @Inject
    public PeopleCountFormatter( @ApplicationContext Context context ) {
        super( context );
    }

    @Override
    public String format( Integer count ){
        return String.format( Locale.getDefault(), "%d people", count );
    }
}
