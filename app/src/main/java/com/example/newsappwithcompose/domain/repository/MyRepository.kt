package com.example.newsappwithcompose.domain.repository

import com.example.newsappwithcompose.model.NewsResoponse

interface MyRepository {
    suspend fun getNewsApiCall(search : String) : NewsResoponse?
}