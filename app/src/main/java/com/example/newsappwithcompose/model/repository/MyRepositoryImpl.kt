package com.example.newsappwithcompose.model.repository

import android.app.Application
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsappwithcompose.domain.repository.MyRepository
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.model.remote.ApiInterface
import com.example.newsappwithcompose.paging.NewsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val context: Application
) : MyRepository {

    override fun getNewsApiCall(search: String): Flow<PagingData<Article>> {
//        return apiInterface.getNews(
//            q = serach,
//            from = FROM,
//            sortBy = PUBLISH,
//            apiKey = API_KEY,
//            page = page,
//        ).body()?.articles!!

        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
            ), pagingSourceFactory = {
                NewsPagingSource(apiInterface, search)
            }).flow
    }
}