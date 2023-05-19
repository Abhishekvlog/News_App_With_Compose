package com.example.newsappwithcompose.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBuilder {
    val BASE_URL= "https://newsapi.org/"

    val retrofit  = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInteface  = retrofit.create(ApiInterface::class.java)
}