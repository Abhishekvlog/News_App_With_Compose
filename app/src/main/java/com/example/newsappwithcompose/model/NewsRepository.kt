package com.example.newsappwithcompose.model

import com.example.newsappwithcompose.Util.API_KEY
import com.example.newsappwithcompose.Util.FROM
import com.example.newsappwithcompose.Util.PUBLISH
import com.example.newsappwithcompose.Util.q
import com.example.newsappwithcompose.model.remote.NetworkBuilder

class NewsRepository {

    suspend fun getNews() : NewsResoponse{
        return NetworkBuilder.apiInteface.getNews(q = q, from = FROM, sortBy = PUBLISH,API_KEY)
    }
}