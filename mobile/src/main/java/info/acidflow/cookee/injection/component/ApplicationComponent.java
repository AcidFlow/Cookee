package info.acidflow.cookee.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import info.acidflow.cookee.format.CostFormatter;
import info.acidflow.cookee.format.DifficultyFormatter;
import info.acidflow.cookee.format.MealTypeFormatter;
import info.acidflow.cookee.format.PeopleCountFormatter;
import info.acidflow.cookee.format.QuantityFormatter;
import info.acidflow.cookee.injection.module.ApplicationModule;
import info.acidflow.cookee.injection.module.formatter.FormatterModule;
import info.acidflow.cookee.injection.module.rest.CookeeApiModule;
import info.acidflow.cookee.injection.qualifier.ApplicationContext;
import info.acidflow.cookee.rest.api.CookeeApi;
import info.acidflow.cookee.ui.cooking.service.CookingService;

/**
 * Created by paul on 23/01/16.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        FormatterModule.class,
        CookeeApiModule.class
})
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();
    CookeeApi getCookeApi();

    CostFormatter getCostFormatter();
    DifficultyFormatter getDifficultyFormatter();
    MealTypeFormatter getMealTypeFormatter();
    PeopleCountFormatter getPeopleCountFormatter();
    QuantityFormatter getQuantityFormatter();

    void inject( CookingService service );
}
