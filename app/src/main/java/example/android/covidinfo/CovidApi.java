package example.android.covidinfo;

import example.android.covidinfo.Model.Covid;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {

    @GET("summary")
    Call<Covid> getCovidList();



}
