package example.android.covidinfo;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder> implements Filterable {

    private ArrayList<OptionsListItem> optionsList;
    private ArrayList<OptionsListItem> optionsFullList;
    private Context context;

    public OptionsAdapter(Context context, ArrayList<OptionsListItem> optionsList){
        this.optionsList = optionsList;
        this.context = context;
        optionsFullList = new ArrayList<>(optionsList);
    }

    @NonNull
    @Override
    public OptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_list_item, parent, false);
        return new OptionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionsViewHolder holder, int position) {
        OptionsListItem optionsListItem =  optionsList.get(position);
        holder.optionsImage.setImageResource(optionsListItem.getImageUrl());
        holder.optionName.setText(optionsListItem.getOptionName());

        if (position % 3 == 0) {
            holder.optionCardView.setCardBackgroundColor(Color.parseColor("#9B59B6"));
        } else if(position % 3 == 1) {
            holder.optionCardView.setCardBackgroundColor(Color.parseColor("#ff4e5d"));
        } else if(position % 3 == 2) {
            holder.optionCardView.setCardBackgroundColor(Color.parseColor("#ffbd33"));
        }

    }

    @Override
    public int getItemCount() {
        return optionsList.size();
    }

    @Override
    public Filter getFilter() {
        return optionFilter;
    }

    private Filter optionFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<OptionsListItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(optionsFullList);
            }else {
                String filteredPattern = constraint.toString().toLowerCase().trim();
                for (OptionsListItem option : optionsFullList){
                    if (option.getOptionName().toLowerCase().contains(filteredPattern)){
                        filteredList.add(option);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            optionsList.clear();
            optionsList.addAll( (List)results.values);
            notifyDataSetChanged();
        }
    };


    public class OptionsViewHolder extends RecyclerView.ViewHolder{

        ImageView optionsImage;
        TextView optionName;
        CardView optionCardView;

        public OptionsViewHolder(@NonNull View itemView) {
            super(itemView);
            optionsImage = itemView.findViewById(R.id.optionsImage);
            optionName = itemView.findViewById(R.id.optionText);
            optionCardView = itemView.findViewById(R.id.optionCardView);
        }
    }
}
