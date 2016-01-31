package info.acidflow.cookee.ui.recipe;

import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.ui.base.IMvpView;

/**
 * Created by paul on 23/01/16.
 */
public interface IRecipeView extends IMvpView{

    void setName( String name );
    void setDifficulty( String difficulty );
    void setCost( String cost );
    void setType( String type );
    void setPrice( String price );
    void setPeople( String people );
    void setRecipe( Recipe r );
}
