package com.example.newsappwithcompose.model

data class NewsResoponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)