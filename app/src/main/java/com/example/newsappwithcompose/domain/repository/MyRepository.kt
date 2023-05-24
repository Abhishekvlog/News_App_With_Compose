package com.example.newsappwithcompose.domain.repository

import androidx.paging.PagingData
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.model.NewsResoponse
import kotlinx.coroutines.flow.Flow

interface MyRepository {
     fun getNewsApiCall(search : String) : Flow<PagingData<Article>>
}