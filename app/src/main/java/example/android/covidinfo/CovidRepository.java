package example.android.covidinfo;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import example.android.covidinfo.Model.Covid;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidRepository {

    Context context;

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

    public MutableLiveData<Covid> getCovid(Context context){
        this.context = context;
        final MutableLiveData<Covid> covidMutableLiveData = new MutableLiveData<>();
        covidApi.getCovidList().enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                if (response.isSuccessful()){
                    covidMutableLiveData.setValue(response.body());
                }
                else {
                    Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
               Toast.makeText(context, "Network error, please check you internet", Toast.LENGTH_SHORT).show();
            }
        });

        return covidMutableLiveData;
    }

}
