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
import com.example.guardian.model.Result;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    Context context;
    List<Result> resultList;
    public NewsAdapter(Context context,List<Result> resultList){
        this.context=context;
        this.resultList=resultList;

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
        Result result = resultList.get(position);
        holder.txt_title.setText(result.getWebTitle());
        holder.txt_date.setText(result.getWebPublicationDate());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
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
