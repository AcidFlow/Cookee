package info.acidflow.cookee.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by paul on 20/01/16.
 */
public class Recipe implements Parcelable {

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

    public List< Step > getSteps() {
        return mSteps;
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString( mName );
        dest.writeString( mDescription );
        dest.writeInt( mPeopleCount );
        dest.writeTypedList( mIngredientList );
        dest.writeTypedList( mSteps );
        dest.writeInt( mType.ordinal() );
        dest.writeInt( mCost.ordinal() );
        dest.writeInt( mDifficulty.ordinal() );
    }

    protected Recipe( Parcel in ) {
        mName = in.readString();
        mDescription = in.readString();
        mPeopleCount = in.readInt();
        mIngredientList = in.createTypedArrayList( Ingredient.CREATOR );
        mSteps = in.createTypedArrayList( Step.CREATOR );
        mType = MealType.values()[ in.readInt() ];
        mCost = Cost.values()[ in.readInt() ];
        mDifficulty = Difficulty.values()[ in.readInt() ];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator< Recipe > CREATOR = new Creator< Recipe >() {
        @Override
        public Recipe createFromParcel( Parcel in ) {
            return new Recipe( in );
        }

        @Override
        public Recipe[] newArray( int size ) {
            return new Recipe[ size ];
        }
    };
}
