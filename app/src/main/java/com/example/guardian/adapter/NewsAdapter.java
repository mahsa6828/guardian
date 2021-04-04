package com.example.guardian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardian.R;
import com.example.guardian.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    Context context;
    List<News> newsList;
    public NewsAdapter(Context context,List<News> newsList){
        this.context=context;
        this.newsList=newsList;

    }
    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc_row,null);
        NewsVH newsVH = new NewsVH(view);
        return newsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {
        News news = newsList.get(position);
        holder.txt_title.setText(news.getWebTitle());
        holder.txt_date.setText(news.getWebPublicationDate());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsVH extends RecyclerView.ViewHolder{
        AppCompatImageView img_rc;
        AppCompatTextView txt_title,txt_date;

        public NewsVH(@NonNull View itemView) {
            super(itemView);
            img_rc=itemView.findViewById(R.id.img_rc);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_date = itemView.findViewById(R.id.txt_date);
        }
    }
}
