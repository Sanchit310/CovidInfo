package example.android.covidinfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {

    @GET("summary")
    Call<Covid> getCovidList();



}
