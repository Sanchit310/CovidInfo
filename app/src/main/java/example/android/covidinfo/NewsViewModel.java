package example.android.covidinfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import example.android.covidinfo.Model.News;

public class NewsViewModel extends ViewModel {

    private NewsRepository newsRepository;
    private MutableLiveData<News> newsMutableLiveData;

    public void init(){
        if (newsMutableLiveData != null){
            return;
        }

        newsRepository = NewsRepository.getInstance();
        newsMutableLiveData = newsRepository.getNews();
    }

    public MutableLiveData<News> getNewsMutableLiveData(){
        return newsMutableLiveData;
    }

}
