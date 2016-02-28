package info.acidflow.cookee.ui.base;

import android.support.annotation.NonNull;

/**
 * Created by paul on 24/01/16.
 */
public interface IPresenter< T extends IMvpView > {

    void attachView( @NonNull T view );

    void detachView();


}
