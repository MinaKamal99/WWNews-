package com.androidgangs.wwnews.data.source.remote

import androidx.lifecycle.LiveData
import com.androidgangs.wwnews.data.model.NewsResponse

import com.androidgangs.wwnews.data.source.Result

interface INewsRemoteDataSource {

    fun setArticlesListData(data: Result<NewsResponse>)

    fun observeArticlesListData(): LiveData<Result<NewsResponse>>

    suspend fun fetchArticlesListData(
        country: String,
        apiKey: String
    ): Result<NewsResponse>
}