package com.example.guardian.api;

import android.util.Log;

import com.example.guardian.model.IMessageListener;
import com.example.guardian.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceCaller {
    IService iService;
    public WebServiceCaller(){
       iService = ApiClient.getRetrofit().create(IService.class);
    }
    public void getNews(IMessageListener listener){
        Call<News> call = iService.getNews();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                listener.onsucess(response.body());
                Log.e("","");
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
                Log.e("","");
            }
        });
    }
}
