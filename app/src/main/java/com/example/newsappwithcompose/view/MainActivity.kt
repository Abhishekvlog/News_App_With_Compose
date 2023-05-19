package com.example.newsappwithcompose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme
import com.example.newsappwithcompose.viewModel.NewsViewModel

class MainActivity : ComponentActivity() {
    val newsViewModel : NewsViewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppWithComposeTheme {
                var list = remember {
                    mutableStateListOf<Article>()
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    newsViewModel.newsLiveData.observe(this){articleList->
                       list.clear()
                        list.addAll(articleList)                    }

                    LazyColumn(Modifier.clickable { false }){
                        items(list){item ->
                            ItemView(list = item)
                        }
                    }
                }
            }
        }
    }
}
