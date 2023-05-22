package com.example.newsappwithcompose.model.repository

import android.app.Application
import com.example.newsappwithcompose.Util.API_KEY
import com.example.newsappwithcompose.Util.FROM
import com.example.newsappwithcompose.Util.PUBLISH
import com.example.newsappwithcompose.domain.repository.MyRepository
import com.example.newsappwithcompose.model.NewsResoponse
import com.example.newsappwithcompose.model.remote.ApiInterface
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface, private val context : Application) : MyRepository {

    override suspend fun getNewsApiCall(serach: String): NewsResoponse? {
        return apiInterface.getNews(
            q = serach,
            from = FROM,
            sortBy = PUBLISH,
            apiKey = API_KEY
        ).body()
    }
}