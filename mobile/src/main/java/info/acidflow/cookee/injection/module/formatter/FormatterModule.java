package info.acidflow.cookee.injection.module.formatter;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.acidflow.cookee.format.CostFormatter;
import info.acidflow.cookee.format.DifficultyFormatter;
import info.acidflow.cookee.format.MealTypeFormatter;
import info.acidflow.cookee.format.PeopleCountFormatter;
import info.acidflow.cookee.format.QuantityFormatter;
import info.acidflow.cookee.injection.qualifier.ApplicationContext;

/**
 * Created by paul on 31/01/16.
 */
@Module
public class FormatterModule {

    @Provides
    @Singleton
    CostFormatter provideCostFormatter( @ApplicationContext Context context ) {
        return new CostFormatter( context );
    }

    @Provides
    @Singleton
    DifficultyFormatter provideDifficultyFormatter( @ApplicationContext Context context ) {
        return new DifficultyFormatter( context );
    }

    @Provides
    @Singleton
    MealTypeFormatter provideMealTypeFormatter( @ApplicationContext Context context ) {
        return new MealTypeFormatter( context );
    }

    @Provides
    @Singleton
    PeopleCountFormatter providePeopleCountFormatter( @ApplicationContext Context context ) {
        return new PeopleCountFormatter( context );
    }

    @Provides
    @Singleton
    QuantityFormatter proQuantityFormatter( @ApplicationContext Context context ) {
        return new QuantityFormatter( context );
    }
}
