package com.example.newsappwithcompose.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsappwithcompose.Util.API_KEY
import com.example.newsappwithcompose.Util.FROM
import com.example.newsappwithcompose.Util.PUBLISH
import com.example.newsappwithcompose.model.Article
import com.example.newsappwithcompose.model.remote.ApiInterface

class NewsPagingSource (private val apiInterface: ApiInterface , private val q : String ) :
    PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.prevKey?.plus(1) ?: state.closestPageToPosition(
                anchorPos
            )?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page  = params.key ?: 1
            val response  = apiInterface.getNews( page = page, q = q).body()
            Log.d("pagingData", "Paging: ${response?.articles?.get(0)?.title}")
            LoadResult.Page(
                data = response?.articles ?: emptyList(),
                prevKey = if (page == 1) null else page - 1 ,
                nextKey = if (response?.articles?.isEmpty() == true) null else page + 1

            )
        }catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}