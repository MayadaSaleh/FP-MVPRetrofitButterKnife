package gp.web.and.mobile.retrofitandmvp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mayada on 4/4/2018.
 */

public interface Api {

String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
