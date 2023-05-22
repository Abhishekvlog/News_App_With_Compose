package com.example.newsappwithcompose.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithcompose.domain.repository.MyRepository
import com.example.newsappwithcompose.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val repository : MyRepository) : ViewModel() {
//    val repo = NewsRepository()
    private val newsArticalsLiveData = MutableLiveData<List<Article>>()
    var newsLiveData : LiveData<List<Article>> = newsArticalsLiveData

    init {
        viewModelScope.launch{
            getNews("tesla")
        }
    }

     fun getNews(search : String){
         viewModelScope.launch {
             newsArticalsLiveData.value = repository.getNewsApiCall(search = search)?.articles
         }
    }
}