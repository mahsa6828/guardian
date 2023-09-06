package com.example.guardian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardian.NewsActivity;
import com.example.guardian.R;
import com.example.guardian.model.Fields;
import com.example.guardian.model.News;
import com.example.guardian.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        Picasso.get().load(result.getFields().getThumbnail()).into(holder.img_rc);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("webUrl",result.getWebUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class NewsVH extends RecyclerView.ViewHolder{
        CircleImageView img_rc;
        AppCompatTextView txt_title,txt_date;
        RelativeLayout relativeLayout;

        public NewsVH(@NonNull View itemView) {
            super(itemView);
            img_rc=itemView.findViewById(R.id.img_rc);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_date = itemView.findViewById(R.id.txt_date);
            relativeLayout = itemView.findViewById(R.id.relative_news);
        }
    }
}
