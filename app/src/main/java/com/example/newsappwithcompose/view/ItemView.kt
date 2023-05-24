package com.example.newsappwithcompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.newsappwithcompose.model.Article

@Composable
fun ItemView(list : Article) {
    Card(
        shape = RoundedCornerShape(6.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(text = list.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(6.dp))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = list.description, fontWeight = FontWeight.Medium, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            RowView(str1 = list.source.name, str2 = list.publishedAt)
        }
    }
}

@Composable
fun RowView(str1: String, str2 : String){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = str1,  color = Color.Black, fontSize = 14.sp)
        Text(text = str2,  color = Color.Black, fontSize = 14.sp)
    }
}