package example.android.covidinfo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MythAdapter extends RecyclerView.Adapter<MythAdapter.MythViewHolder> {

    Context context;
    List<FaqnMyth> mythList;
    OnItemclikListener mListener;

    public interface OnItemclikListener {
        void OnItemClick(int position);
    }

    public void setOnClickListener(OnItemclikListener listener) {
        mListener = listener;
    }

    public MythAdapter(Context context, List<FaqnMyth> mythList) {
        this.context = context;
        this.mythList = mythList;
    }

    @NonNull
    @Override
    public MythViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myth_item, parent, false);
        return new MythViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MythViewHolder holder, int position) {
        FaqnMyth faqnMyth = mythList.get(position);
        holder.mythImg.setImageResource(faqnMyth.getImg());
        holder.mythQues.setText(faqnMyth.getQues());
        holder.mythAns.setText(faqnMyth.getAns());

        if (!faqnMyth.isExpanded()) {
            holder.mythAns.setVisibility(View.GONE);

        } else {
            holder.mythAns.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mythList.size();
    }

    public class MythViewHolder extends RecyclerView.ViewHolder {

        ImageView mythImg;
        TextView mythQues, mythAns;

        public MythViewHolder(@NonNull View itemView, OnItemclikListener listener) {
            super(itemView);
            mythImg = itemView.findViewById(R.id.mythImg);
            mythQues = itemView.findViewById(R.id.mythQues);
            mythAns = itemView.findViewById(R.id.mythSol);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
