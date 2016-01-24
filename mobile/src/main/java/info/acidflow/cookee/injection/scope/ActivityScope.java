package info.acidflow.cookee.injection.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by paul on 23/01/16.
 */
@Scope
@Retention( RUNTIME )
public @interface ActivityScope {
}
