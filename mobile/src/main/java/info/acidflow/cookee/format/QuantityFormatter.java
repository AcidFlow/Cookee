package info.acidflow.cookee.format;

import android.content.Context;

import java.util.Locale;

import javax.inject.Inject;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.model.Quantity;

/**
 * Created by paul on 31/01/16.
 */
public class QuantityFormatter extends AbstractFormatter<Quantity> {

    @Inject
    public QuantityFormatter( @ApplicationContext Context context ) {
        super( context );
    }

    @Override
    public String format( Quantity quantity ){
        return String.format( Locale.getDefault(), "%,.2f %s",
                quantity.getQuantity(), quantity.getUnit().getType().name()
        );
    }

}
