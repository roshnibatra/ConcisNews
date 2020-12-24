package com.example.android.concisnews.apiInterface;

import com.example.android.concisnews.Dtos.News;
import com.example.android.concisnews.Dtos.SourceDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("posts")
    Call<List<News>> getNews();
}
