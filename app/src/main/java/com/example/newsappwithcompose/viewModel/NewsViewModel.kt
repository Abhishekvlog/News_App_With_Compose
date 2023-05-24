package com.example.newsappwithcompose.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.flatMap
import com.example.newsappwithcompose.domain.repository.MyRepository
import com.example.newsappwithcompose.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.cache
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val repository : MyRepository) : ViewModel() {

    private val _data = MutableStateFlow("tesla")

    val response  = _data.flatMapLatest { query ->
        repository.getNewsApiCall(query).cachedIn(viewModelScope)
    }

    internal fun updateQuery(query: String) {
        viewModelScope.launch {
            _data.emit(query)
        }
    }
}