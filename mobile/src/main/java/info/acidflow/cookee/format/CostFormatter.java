package info.acidflow.cookee.format;

import android.content.Context;

import javax.inject.Inject;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.model.Cost;

/**
 * Created by paul on 31/01/16.
 */
public class CostFormatter extends AbstractFormatter< Cost > {

    @Inject
    public CostFormatter( @ApplicationContext Context context ) {
        super( context );
    }

    @Override
    public String format( Cost cost ) {
        return cost.name();
    }

}
