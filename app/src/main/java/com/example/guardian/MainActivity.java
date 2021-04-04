package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.guardian.adapter.NewsAdapter;
import com.example.guardian.api.WebServiceCaller;
import com.example.guardian.model.IMessageListener;
import com.example.guardian.model.News;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WebServiceCaller webServiceCaller;
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.rc_main);
        webServiceCaller = new WebServiceCaller();
        webServiceCaller.getNews(new IMessageListener() {
            @Override
            public void onsucess(Object responseMessage) {
                Log.e("","");
                NewsAdapter newsAdapter = new NewsAdapter(getApplicationContext(),(List<News>) responseMessage);
                recyclerView.setAdapter(newsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


    }
}