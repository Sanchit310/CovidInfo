package example.android.covidinfo;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import example.android.covidinfo.Model.Covid;

public class CovidViewModel extends ViewModel {

    Context context;

    private MutableLiveData<Covid> covidMutableLiveData;
    private CovidRepository covidRepository;

    public void init(Context context){
        if (covidMutableLiveData != null){
            this.context = context;
            return;
        }

        covidRepository = CovidRepository.getInstance();
        covidMutableLiveData = covidRepository.getCovid(context);

    }

    public MutableLiveData<Covid> getCovidMutableLiveData(){
        return covidMutableLiveData;
    }
}
