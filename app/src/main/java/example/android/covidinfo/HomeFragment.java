package example.android.covidinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    OptionsAdapter optionsAdapter;
    ArrayList<OptionsListItem> optionsListItems = new ArrayList<>() ;
    PieChart pieChart;
    TextView seeMoreOption;
    CovidViewModel covidViewModel;
    TextSwitcher countryName, confirmed, recovered, death, indName, indianConfirmedCases, indianRecoveredCases, indianDeathCases, mGlobal, globalConfirmedCases, globalRecoveredCases, globalDeathCases;
    ArrayList<Countries> countries = new ArrayList<>();
    int num;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View view3 = view.findViewById(R.id.layout1);
        View view1 = view.findViewById(R.id.layout2);
        View view2 = view.findViewById(R.id.layout3);
        countryName = view3.findViewById(R.id.countryName);
        confirmed = view3.findViewById(R.id.confirmed);
        recovered = view3.findViewById(R.id.recovered);
        death = view3.findViewById(R.id.death);

        mGlobal = view2.findViewById(R.id.countryName);
        globalConfirmedCases = view2.findViewById(R.id.confirmed);
        globalRecoveredCases = view2.findViewById(R.id.recovered);
        globalDeathCases = view2.findViewById(R.id.death);

        indName = view1.findViewById(R.id.countryName);
        indianConfirmedCases = view1.findViewById(R.id.confirmed);
        indianRecoveredCases = view1.findViewById(R.id.recovered);
        indianDeathCases = view1.findViewById(R.id.death);
        mGlobal.setText("Worldwide cases");

        countryName.setInAnimation(getContext(), android.R.anim.slide_in_left);
        countryName.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        confirmed.setInAnimation(getContext(), android.R.anim.slide_in_left);
        confirmed.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        recovered.setInAnimation(getContext(), android.R.anim.slide_in_left);
        recovered.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        death.setInAnimation(getContext(), android.R.anim.slide_in_left);
        death.setOutAnimation(getContext(), android.R.anim.slide_out_right);

        NavController navController = Navigation.findNavController(view);


        covidViewModel = ViewModelProviders.of(this).get(CovidViewModel.class);
        covidViewModel.init();
        covidViewModel.getCovidMutableLiveData().observe(getViewLifecycleOwner(), covidResponse ->{
            List<Countries> country = covidResponse.getCountries();
            Global global = covidResponse.getGlobal();
            countries.addAll(country);
            indName.setText(countries.get(76).getCountry());
            indianConfirmedCases.setText(countries.get(76).getTotalConfirmedCases());
            indianRecoveredCases.setText(countries.get(76).getTotalRecoveredCases());
            indianDeathCases.setText(countries.get(76).getTotalDeathCases());

            globalConfirmedCases.setText(global.getWorldConfirmedCases());
            globalRecoveredCases.setText(global.getWorldRecoveredCases());
            globalDeathCases.setText(global.getWorldDeathCases());
            int cnf = Integer.parseInt(global.getWorldConfirmedCases());
            int rcvrd = Integer.parseInt(global.getWorldRecoveredCases());
            int dth = Integer.parseInt(global.getWorldDeathCases());



            pieChart.setUsePercentValues(true);
            pieChart.getDescription().setEnabled(false);
            pieChart.setExtraOffsets(5,10,5,5);
            pieChart.setDragDecelerationFrictionCoef(0.9f);
            pieChart.setDrawHoleEnabled(true);
            pieChart.setHoleRadius(70f);
            pieChart.setTransparentCircleRadius(81f);
            pieChart.setHoleColor(Color.WHITE);
            pieChart.animateY(3000, Easing.EaseInCirc);



            ArrayList<PieEntry> pieEntries = new ArrayList<>();
            pieEntries.add(new PieEntry(cnf, "Confirmed"));
            pieEntries.add(new PieEntry(rcvrd, "Recovered"));
            pieEntries.add(new PieEntry(dth, "Deaths"));

            PieDataSet pieDataSet = new PieDataSet(pieEntries, "World");
            pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            pieDataSet.setSliceSpace(4f);
            pieDataSet.setSelectionShift(10f);


            PieData pieData = new PieData(pieDataSet);
            pieData.setValueTextSize(10f);
            pieData.setValueTextColor(Color.WHITE);
            pieChart.setData(pieData);

            Log.d("___", "onCreate: " + countries.size());

            countryName.post(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int pos = random.nextInt(184);
                    Log.d("___", "run: " + pos);
                    Log.d("___", "run: " + countries.size());
                    getNum(pos);
                    countryName.setText(countries.get(pos).getCountry());
//
//                    recovered.setText(countries.get(i).getTotalRecoveredCases());
//                    death.setText(countries.get(i).getTotalDeathCases());

                    countryName.postDelayed(this, 5000);
//
//                    recovered.postDelayed(this, 5000);
//                    death.postDelayed(this, 5000);


                }
            });
            confirmed.post(new Runnable() {
                @Override
                public void run() {
                    confirmed.setText(countries.get(num).getTotalConfirmedCases());
                    confirmed.postDelayed(this, 5000);
                }
            });
            recovered.post(new Runnable() {
                @Override
                public void run() {
                    recovered.setText(countries.get(num).getTotalRecoveredCases());
                    recovered.postDelayed(this, 5000);
                }
            });
            death.post(new Runnable() {
                @Override
                public void run() {
                    death.setText(countries.get(num).getTotalDeathCases());
                    death.postDelayed(this, 5000);
                }
            });



        });


        seeMoreOption = view.findViewById(R.id.seeMore);
        seeMoreOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), AllCountryCases.class);
//                startActivity(intent);
                navController.navigate(R.id.action_mainFragment_to_allCountryFragment2);

            }
        });

        pieChart = view.findViewById(R.id.worldPieChart);


        optionsListItems.add(new OptionsListItem(R.drawable.runny_nose,"Symptoms"));
        optionsListItems.add(new OptionsListItem(R.drawable.precaution3,"Precautions"));
        optionsListItems.add(new OptionsListItem(R.drawable.newss,"News"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"Symptoms"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"Precautions"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"News"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"Symptoms"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"Precautions"));
        optionsListItems.add(new OptionsListItem(R.drawable.nose_symp,"News"));


        recyclerView = view.findViewById(R.id.optionRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        optionsAdapter = new OptionsAdapter(getActivity(), optionsListItems );
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(optionsAdapter);

    }



    public void getNum(int i){
        num = i;
    }


}
