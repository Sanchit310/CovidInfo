package example.android.covidinfo;

import example.android.covidinfo.Model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/top-headlines")
    Call<News> getNewsList(
            @Query("country") String countryNews,
            @Query("apiKey") String key
    );

}
