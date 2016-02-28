package info.acidflow.cookee.rest.service;


import info.acidflow.cookee.model.Recipe;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by paul on 21/01/16.
 */
public interface CookeeApiService {

    @GET( "recipe/{recipe_id}" )
    Observable< Recipe > getRecipe( @Path( "recipe_id" ) String id );
}
