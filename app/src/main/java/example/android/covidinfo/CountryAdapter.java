package example.android.covidinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    private ArrayList<CountryCases> countryCasesList;

    private Context context;

    public CountryAdapter(ArrayList<CountryCases> countryCasesList, Context context) {
        this.countryCasesList = countryCasesList;
        this.context = context;

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryCases countryCases = countryCasesList.get(position);
        holder.countryName.setText(countryCases.getCountryName());
        holder.confirmed.setText(countryCases.getConfirmedCases());
        holder.recovered.setText(countryCases.getRecoveredCases());
        holder.death.setText(countryCases.getDeathCases());
    }

    @Override
    public int getItemCount() {
        return countryCasesList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView countryName, confirmed, recovered, death;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            confirmed = itemView.findViewById(R.id.confirmed);
            recovered = itemView.findViewById(R.id.recovered);
            death =  itemView.findViewById(R.id.death);
        }
    }
}
