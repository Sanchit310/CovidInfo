package example.android.covidinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllCountryFragment extends Fragment {
    RecyclerView recyclerView;
    CovidAdapter covidAdapter;
    CovidViewModel covidViewModel;
    ArrayList<Countries> countriesArrayList = new ArrayList<>();

    public AllCountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.allCountryListRecyclerView);

        Toolbar toolbar =  view.findViewById(R.id.countryToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        covidViewModel = ViewModelProviders.of(this).get(CovidViewModel.class);
        covidViewModel.init();
        covidViewModel.getCovidMutableLiveData().observe(getViewLifecycleOwner(), covidResponse -> {
            List<Countries> countryCases = covidResponse.getCountries();
            countriesArrayList.addAll(countryCases);
            Countries country = countryCases.get(0);
            String  name = country.getCountry();
            covidAdapter.notifyDataSetChanged();
        });

        setRecyclerView();


    }



    public void setRecyclerView(){

        if (covidAdapter == null){
            covidAdapter = new CovidAdapter(getContext(), countriesArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(covidAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        }
        else {
            covidAdapter.notifyDataSetChanged();
        }

    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getActivity().getMenuInflater();
//        menuInflater.inflate(R.menu.menu_items, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                covidAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_items, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                covidAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}
