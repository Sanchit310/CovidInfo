package example.android.covidinfo;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidRepository {

    private static CovidRepository covidRepository;

    public static CovidRepository getInstance(){

        if (covidRepository == null){
            covidRepository = new CovidRepository();
        }
        return covidRepository;
    }

    private CovidApi covidApi;

    public CovidRepository(){
        covidApi = RetrofitService.createService(CovidApi.class);
    }

    public MutableLiveData<Covid> getCovid(){
        final MutableLiveData<Covid> covidMutableLiveData = new MutableLiveData<>();
        covidApi.getCovidList().enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                if (response.isSuccessful()){
                    covidMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
                covidMutableLiveData.setValue(null);
            }
        });

        return covidMutableLiveData;
    }

}
