package example.android.covidinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Model.FaqnMyth;
import example.android.covidinfo.R;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqnMythViewHolder> {


    onItemClickListener mListener;
    List<FaqnMyth> faqnMythList;
    Context context;

    public FaqAdapter(List<FaqnMyth> faqnMythList, Context context) {
        this.faqnMythList = faqnMythList;
        this.context = context;

    }

    public interface onItemClickListener{
        void onItemClick(int postion);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }


    @NonNull
    @Override
    public FaqnMythViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_item, parent, false);
        return new FaqnMythViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqnMythViewHolder holder, int position) {
        FaqnMyth faqnMyth = faqnMythList.get(position);
        holder.img.setImageResource(faqnMyth.getImg());
        holder.ques.setText(faqnMyth.getQues());
        holder.ans.setText(faqnMyth.getAns());


        if (!faqnMyth.isExpanded()){
            holder.ans.setVisibility(View.GONE);
            holder.img.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);


        }else {
            holder.ans.setVisibility(View.VISIBLE);
            holder.img.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);


        }


    }

    @Override
    public int getItemCount() {
        return faqnMythList.size();
    }

    public class FaqnMythViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView ques, ans;

        public FaqnMythViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            ques = itemView.findViewById(R.id.ques);
            ans = itemView.findViewById(R.id.ans);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
