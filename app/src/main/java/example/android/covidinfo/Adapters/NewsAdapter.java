package example.android.covidinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.android.covidinfo.Model.Articles;
import example.android.covidinfo.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    ArrayList<Articles> articlesArrayList;
    Context context;
    onItemClickListener mListener;

    public interface onItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public NewsAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.newsTitle.setText(articles.getTitle());
        holder.newsDesc.setText(articles.getDescription());
        holder.newsDate.setText(articles.getPublishedAt());
        Glide.with(context).load(articles.getUrlToImage()).into(holder.newsImage);

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView newsImage;
        TextView newsTitle, newsDesc, newsDate;

        public NewsViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDesc = itemView.findViewById(R.id.newsDesc);
            newsDate = itemView.findViewById(R.id.newsDate);

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
