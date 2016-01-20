package info.acidflow.cookee.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paul on 20/01/16.
 */
public class Step {

    @SerializedName( "description" )
    private final String mStepDescription;

    public Step( String stepDescription ) {
        mStepDescription = stepDescription;
    }
}
