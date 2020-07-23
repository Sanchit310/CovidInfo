package example.android.covidinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Model.Symptom;
import example.android.covidinfo.R;

public class SymptomAdapter extends RecyclerView.Adapter<SymptomAdapter.SymptomViewHolder>{

    private ArrayList<Symptom> symptomList;

    private Context context;

    public SymptomAdapter(ArrayList<Symptom> symptomList, Context context) {
        this.symptomList = symptomList;
        this.context = context;

    }

    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sympton_item, parent, false);
        return new SymptomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomViewHolder holder, int position) {
        Symptom symptom = symptomList.get(position);
        holder.symptomImage.setImageResource(symptom.getSymptomImage());
        holder.symptomName.setText(symptom.getSymptomName());
        holder.symptomDesc.setText(symptom.getSymptomDesc());

    }

    @Override
    public int getItemCount() {
        return symptomList.size();
    }

    public class SymptomViewHolder extends RecyclerView.ViewHolder{

        TextView symptomName, symptomDesc;
        ImageView symptomImage;

        public SymptomViewHolder(@NonNull View itemView) {
            super(itemView);
            symptomName = itemView.findViewById(R.id.symptomName);
            symptomImage = itemView.findViewById(R.id.symptomImage);
            symptomDesc = itemView.findViewById(R.id.symptomDesc);
        }
    }
}
