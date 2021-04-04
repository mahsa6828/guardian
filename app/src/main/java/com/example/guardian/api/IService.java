package com.example.guardian.api;

import com.example.guardian.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {
    @GET("search?q=sport&api-key=test")
    Call<News> getNews();
}
