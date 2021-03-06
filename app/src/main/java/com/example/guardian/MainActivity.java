package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.guardian.adapter.NewsAdapter;
import com.example.guardian.api.WebServiceCaller;
import com.example.guardian.model.Fields;
import com.example.guardian.model.IMessageListener;
import com.example.guardian.model.News;
import com.example.guardian.model.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WebServiceCaller webServiceCaller;
    Toolbar toolbar;
    RecyclerView recyclerView;
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
                News news = (News)responseMessage;
                NewsAdapter newsAdapter = new NewsAdapter(getApplicationContext(),news.getResponse().getResults());
                recyclerView.setAdapter(newsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("Guardian Service","Error Message Was: "+errorResponseMessage);
            }
        });


    }
}