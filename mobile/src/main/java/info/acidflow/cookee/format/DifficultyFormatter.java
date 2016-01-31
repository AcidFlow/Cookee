package info.acidflow.cookee.format;

import android.content.Context;

import javax.inject.Inject;

import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.model.Difficulty;

/**
 * Created by paul on 31/01/16.
 */
public class DifficultyFormatter extends AbstractFormatter<Difficulty> {

    @Inject
    public DifficultyFormatter( @ApplicationContext Context context ) {
        super( context );
    }

    @Override
    public String format( Difficulty difficulty ){
        return difficulty.name();
    }
    
}
