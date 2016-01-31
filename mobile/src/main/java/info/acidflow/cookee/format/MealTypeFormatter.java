package info.acidflow.cookee.format;

import android.content.Context;

import javax.inject.Inject;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.model.MealType;

/**
 * Created by paul on 31/01/16.
 */
public class MealTypeFormatter extends AbstractFormatter<MealType> {

    @Inject
    public MealTypeFormatter( @ApplicationContext Context context ) {
        super( context );
    }

    @Override
    public String format( MealType mealType ){
        return mealType.name();
    }
    
}
