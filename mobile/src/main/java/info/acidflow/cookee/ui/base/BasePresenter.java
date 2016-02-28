package info.acidflow.cookee.ui.base;

import android.support.annotation.NonNull;

/**
 * Created by paul on 24/01/16.
 */
public abstract class BasePresenter< T extends IMvpView > implements IPresenter< T > {

    private T mMvpView;

    @Override
    public void attachView( @NonNull T view ) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    protected T getMvpView() {
        return mMvpView;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

}
