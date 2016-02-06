package info.acidflow.cookee.ui.recipe.fragment.steps;

import info.acidflow.cookee.model.Step;
import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 06/02/16.
 */
public interface IStepsView extends IMvpView {

    void addStep( Step step );
}
