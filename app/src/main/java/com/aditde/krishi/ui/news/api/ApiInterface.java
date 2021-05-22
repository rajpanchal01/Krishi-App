package com.aditde.krishi.ui.news.api;

import com.aditde.krishi.ui.news.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("everything")
    Call<News> getNewsSearch(

        @Query("q") String keyword,
        @Query("language") String language,
        @Query("sortBy") String sortBy,
        @Query("apiKey") String apiKey

    );

}
