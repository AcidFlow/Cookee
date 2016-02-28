package info.acidflow.cookee.rest.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import info.acidflow.cookee.BuildConfig;
import info.acidflow.cookee.model.Recipe;
import info.acidflow.cookee.model.units.Unit;
import info.acidflow.cookee.rest.gson.deserializer.UnitDeserializer;
import info.acidflow.cookee.rest.service.CookeeApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by paul on 21/01/16.
 */
public class CookeeApi {

    private final CookeeApiService mApiService;
    private final Gson mGson;
    private final OkHttpClient mOkhttpClient;

    public CookeeApi() {
        super();
        // Creating Gson
        mGson = new GsonBuilder()
                .registerTypeAdapter( Unit.class, new UnitDeserializer() )
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel( BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE );
        mOkhttpClient = new OkHttpClient.Builder().addInterceptor( logging ).build();

        // Building retrofit service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( BuildConfig.REST_ENDPOINT )
                .addConverterFactory( GsonConverterFactory.create( mGson ) )
                .addCallAdapterFactory( RxJavaCallAdapterFactory.create() )
                .build();

        mApiService = retrofit.create( CookeeApiService.class );
    }

    public Observable< Recipe > getRecipe( String recipeId ) {
        return mApiService.getRecipe( recipeId );
    }
}
