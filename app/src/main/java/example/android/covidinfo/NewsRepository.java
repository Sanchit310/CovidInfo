package example.android.covidinfo;

import androidx.lifecycle.MutableLiveData;
import example.android.covidinfo.Model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    public static final String key = "c15efb6ad4ce45f4ac093af0fd3a218e";
    public static final String c = "in";

    private static NewsRepository newsRepository;

    public  static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private NewsApi newsApi;

    public NewsRepository(){
        newsApi = NewsService.createService(NewsApi.class);
    }

    public MutableLiveData<News> getNews(){
        final MutableLiveData<News> newsMutableLiveData = new MutableLiveData<>();
        newsApi.getNewsList(c,key).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
        return newsMutableLiveData;
    }
}
