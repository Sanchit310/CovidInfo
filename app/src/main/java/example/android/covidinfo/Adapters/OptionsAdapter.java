package example.android.covidinfo.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Model.OptionsListItem;
import example.android.covidinfo.R;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder> {

    private ArrayList<OptionsListItem> optionsList;

    private Context context;
   OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        mlistener = listener;
    }



    public OptionsAdapter(Context context, ArrayList<OptionsListItem> optionsList, NavController navController){
        this.optionsList = optionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public OptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_list_item, parent, false);
        return new OptionsViewHolder(view, mlistener);
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
        return 5;
    }

    public class OptionsViewHolder extends RecyclerView.ViewHolder{

        ImageView optionsImage;
        TextView optionName;
        CardView optionCardView;


        public OptionsViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            optionsImage = itemView.findViewById(R.id.optionsImage);
            optionName = itemView.findViewById(R.id.optionText);
            optionCardView = itemView.findViewById(R.id.optionCardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
