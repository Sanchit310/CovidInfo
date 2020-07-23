package example.android.covidinfo.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextSwitcher;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Model.Countries;
import example.android.covidinfo.R;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.CovidViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Countries> countriesList;
    private ArrayList<Countries> filteredCountryList;

    public CovidAdapter(Context context, ArrayList<Countries> countriesList) {
        this.context = context;
        this.countriesList = countriesList;
        filteredCountryList = countriesList;

    }

    @NonNull
    @Override
    public CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new CovidViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolder holder, int position) {
        Countries countries = filteredCountryList.get(position);
        holder.countryName.setText(countries.getCountry());
        holder.confirmed.setText(countries.getTotalConfirmedCases());
        holder.recovered.setText(countries.getTotalRecoveredCases());
        holder.death.setText(countries.getTotalDeathCases());

    }

    @Override
    public int getItemCount() {
        return filteredCountryList.size();
    }

    @Override
    public Filter getFilter() {
        return covidFilter;
    }

    private Filter covidFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filteredPattern = constraint.toString().toLowerCase();
            Log.d("___", "performFiltering: " + filteredPattern);
            if (filteredPattern.toString().isEmpty()){
                filteredCountryList = countriesList;
            }else {
                ArrayList<Countries> filteredList = new ArrayList<>();

                for (Countries country : countriesList){
                    if (country.getCountry().toLowerCase().contains(filteredPattern)){
                        filteredList.add(country);
                    }
                }
                filteredCountryList = filteredList;
            }
            FilterResults results = new FilterResults();
            results.values = filteredCountryList;
            Log.d("___", "performFiltering: " + filteredCountryList.size());
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            filteredCountryList = (ArrayList<Countries>) results.values;
            Log.d("___", "performFiltering: " + filteredCountryList.size());
            notifyDataSetChanged();
        }
    };

    public class CovidViewHolder extends RecyclerView.ViewHolder{

        TextSwitcher countryName, confirmed, recovered, death;

        public CovidViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            confirmed = itemView.findViewById(R.id.confirmed);
            recovered = itemView.findViewById(R.id.recovered);
            death =  itemView.findViewById(R.id.death);
        }
    }
}
