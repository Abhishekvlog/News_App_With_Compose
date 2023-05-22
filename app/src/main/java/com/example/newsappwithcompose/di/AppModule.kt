package com.example.newsappwithcompose.di

import android.app.Application
import com.example.newsappwithcompose.domain.repository.MyRepository
import com.example.newsappwithcompose.model.remote.ApiInterface
import com.example.newsappwithcompose.model.remote.NetworkBuilder
import com.example.newsappwithcompose.model.repository.MyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ApiCall() : ApiInterface{
        return Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(api : ApiInterface, app : Application) : MyRepository{
        return MyRepositoryImpl(api, app)
    }
}