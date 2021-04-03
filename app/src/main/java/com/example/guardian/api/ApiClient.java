package com.example.guardian.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl("http://content.guardianapis.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
