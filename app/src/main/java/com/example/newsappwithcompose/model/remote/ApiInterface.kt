package com.example.newsappwithcompose.model.remote

import com.example.newsappwithcompose.model.NewsResoponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q : String,
        @Query("from") from : String,
        @Query("sortBy") sortBy : String,
        @Query("apiKey") apiKey : String,
    ) : NewsResoponse
}