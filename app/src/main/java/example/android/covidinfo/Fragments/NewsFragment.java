package example.android.covidinfo.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Adapters.CovidAdapter;
import example.android.covidinfo.Adapters.NewsAdapter;
import example.android.covidinfo.AllCountryCases;
import example.android.covidinfo.Model.Articles;
import example.android.covidinfo.Model.News;
import example.android.covidinfo.NewsViewModel;
import example.android.covidinfo.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    RecyclerView newsRcyclerView;
    NewsAdapter newsAdapter;
    NewsViewModel newsViewModel;
    ArrayList<Articles> articlesArrayList = new ArrayList<>();

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        Log.d("___", "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsRcyclerView = view.findViewById(R.id.newsRecyclerView);
        NavController navController = Navigation.findNavController(view);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getNewsMutableLiveData().observe(getViewLifecycleOwner(), newsResponse -> {
            ArrayList<Articles> articles = newsResponse.getArticles();
            articlesArrayList.addAll(articles);
            newsAdapter.notifyDataSetChanged();
        });

        Log.d("___", "onViewCreated: ");
        setRecyclerView();
        newsAdapter.setOnItemClickListener(new NewsAdapter.onItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                News news = new News(articlesArrayList);
                NewsFragmentDirections.ActionNewsFragmentToNewsDetailsFragment action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(news);
                action.setPos(position);
                navController.navigate(action);
            }
        });
    }

    public void setRecyclerView(){

        if (newsAdapter == null){
            newsAdapter = new NewsAdapter(articlesArrayList, getContext());
            newsRcyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            newsRcyclerView.setAdapter(newsAdapter);
            newsRcyclerView.setNestedScrollingEnabled(true);
        }
        else {
            newsAdapter.notifyDataSetChanged();
        }

    }
}
