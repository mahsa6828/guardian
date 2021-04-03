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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    Context context;
    public NewsAdapter(Context context){
        this.context=context;

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

    }

    @Override
    public int getItemCount() {
        return 0;
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
