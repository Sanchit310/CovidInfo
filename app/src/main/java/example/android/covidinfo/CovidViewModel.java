package example.android.covidinfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CovidViewModel extends ViewModel {

    private MutableLiveData<Covid> covidMutableLiveData;
    private CovidRepository covidRepository;

    public void init(){
        if (covidMutableLiveData != null){
            return;
        }

        covidRepository = CovidRepository.getInstance();
        covidMutableLiveData = covidRepository.getCovid();

    }

    public MutableLiveData<Covid> getCovidMutableLiveData(){
        return covidMutableLiveData;
    }
}
