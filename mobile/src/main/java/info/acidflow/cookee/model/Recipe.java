package info.acidflow.cookee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by paul on 20/01/16.
 */
public class Recipe {

    @SerializedName( "name" )
    private final String mName;

    @SerializedName( "description" )
    private final String mDescription;

    @SerializedName( "people_count" )
    private final int mPeopleCount;

    @SerializedName( "ingredients" )
    private final List< Ingredient > mIngredientList;

    @SerializedName( "steps" )
    private final List< Step > mSteps;

    @SerializedName( "meal_type" )
    private final MealType mType;

    @SerializedName( "cost" )
    private final Cost mCost;

    @SerializedName( "difficulty" )
    private final Difficulty mDifficulty;

    public Recipe( String name, String description, int peopleCount,
                   List< Ingredient > ingredientList, List< Step > steps, MealType type, Cost cost,
                   Difficulty difficulty ) {
        mName = name;
        mDescription = description;
        mPeopleCount = peopleCount;
        mIngredientList = ingredientList;
        mSteps = steps;
        mType = type;
        mCost = cost;
        mDifficulty = difficulty;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getPeopleCount() {
        return mPeopleCount;
    }

    public List< Ingredient > getIngredientList() {
        return mIngredientList;
    }

    public Difficulty getDifficulty() {
        return mDifficulty;
    }

    public Cost getCost() {
        return mCost;
    }

    public MealType getType() {
        return mType;
    }
}
