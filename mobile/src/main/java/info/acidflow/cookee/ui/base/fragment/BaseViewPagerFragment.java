package info.acidflow.cookee.ui.base.fragment;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

/**
 * Created by paul on 30/01/16.
 */
public abstract class BaseViewPagerFragment extends Fragment {

    public abstract
    @StringRes
    int getTitle();
}
