package com.example.guardian.api;

import android.util.Log;

import com.example.guardian.model.IMessageListener;

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
        Call<List<News>> call = iService.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listener.onsucess(response.body());
                Log.e("","");
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
                Log.e("","");
            }
        });
    }
}
