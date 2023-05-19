package com.example.newsappwithcompose.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.model.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    val repo = NewsRepository()
    private val newsArticalsLiveData = MutableLiveData<List<Article>>()
    var newsLiveData : LiveData<List<Article>> = newsArticalsLiveData

    init {
        viewModelScope.launch{
            getNews()
        }
    }

    suspend fun getNews(){
        newsArticalsLiveData.value = repo.getNews().articles
    }
}