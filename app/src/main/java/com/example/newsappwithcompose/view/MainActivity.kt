package com.example.newsappwithcompose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.ui.theme.NewsAppWithComposeTheme
import com.example.newsappwithcompose.viewModel.NewsViewModel

class MainActivity : ComponentActivity() {
    val newsViewModel: NewsViewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppWithComposeTheme {
                var list = remember {
                    mutableStateListOf<Article>()
                }
                var searchText = remember {
                    mutableStateOf("")
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    newsViewModel.newsLiveData.observe(this) { articleList ->
                        list.clear()
                        list.addAll(articleList)
                    }
                    Column {
                        SearchField(name = searchText.value) {
                            searchText.value = it
                            if (it.isNotEmpty()) newsViewModel.getNews(it)
                        }
                        counterView(size = list.size.toString())
                        LazyColumn(Modifier.clickable { false }) {
                            items(list) { item ->
                                ItemView(list = item)
                            }
                        }

                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(name: String, updateText: (String) -> Unit) {
    OutlinedTextField(
        value = name, onValueChange = { updateText(it) },
        placeholder = {
            Text(text = "What's in your mind")
        },
        label = { Text(text = "Search", color = Color.Black) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            cursorColor = Color.Gray,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun counterView(size: String) {
    Card(shape = CircleShape, modifier = Modifier.padding(start = 12.dp)) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Result : $size", modifier = Modifier
                , color = Color.Black, fontSize = 12.sp
            )
        }
    }
}