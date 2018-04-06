package gp.web.and.mobile.retrofitandmvp;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mayada on 4/5/2018.
 */

public class ModelClass implements Contract.Model {

    String[] heroes;
    @Override
    public String[] getData() {
        if (heroes ==null ) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Call<List<Hero>> call = api.getHeroes();
            call.enqueue(new Callback<List<Hero>>() {
                @Override
                public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                    List<Hero> heroList = response.body();
                    heroes = new String[heroList.size()];
                    for (int i = 0; i < heroList.size(); i++) {
                        heroes[i] = heroList.get(i).getRealname();
                        Log.i("Hero's name: ", heroes[i]);
                    }
                }
                @Override
                public void onFailure(Call<List<Hero>> call, Throwable t) {
                    heroes = null;
                }
            });
        }
        return heroes;
    }
}
