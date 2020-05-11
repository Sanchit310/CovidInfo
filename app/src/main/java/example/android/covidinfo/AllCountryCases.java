package example.android.covidinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class AllCountryCases extends AppCompatActivity {

    RecyclerView recyclerView;
    CovidAdapter covidAdapter;
    CovidViewModel covidViewModel;
    ArrayList<Countries> countriesArrayList = new ArrayList<>();
    EditText searchEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_country_cases);

        recyclerView = findViewById(R.id.allCountryListRecyclerView);

        Toolbar toolbar =  findViewById(R.id.countryToolbar);
        setSupportActionBar(toolbar);

        covidViewModel = ViewModelProviders.of(this).get(CovidViewModel.class);
        covidViewModel.init();
        covidViewModel.getCovidMutableLiveData().observe(this, covidResponse -> {
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
            covidAdapter = new CovidAdapter(AllCountryCases.this, countriesArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(covidAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        }
        else {
            covidAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
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
        return true;
    }


}
