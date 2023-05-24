package com.example.newsappwithcompose.model.remote

import androidx.compose.foundation.pager.PageSize
import com.example.newsappwithcompose.Util.API_KEY
import com.example.newsappwithcompose.Util.FROM
import com.example.newsappwithcompose.Util.PUBLISH
import com.example.newsappwithcompose.model.NewsResoponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String ,
        @Query("from") from: String = FROM,
        @Query("sortBy") sortBy: String = PUBLISH,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 4

    ): Response<NewsResoponse>
}