package com.example.android.concisnews.apiInterface;

import com.example.android.concisnews.Dtos.SourceDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("top-headlines?category=general&apiKey=e1d2194d001540cd903f61c8f8966390&pageSize=100&country=in")
    Call<SourceDto> getNews();
}
