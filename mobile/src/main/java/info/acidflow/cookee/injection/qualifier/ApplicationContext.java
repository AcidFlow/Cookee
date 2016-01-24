package info.acidflow.cookee.injection.qualifier;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by paul on 23/01/16.
 */
@Qualifier
@Retention( RUNTIME )
public @interface ApplicationContext {
}
