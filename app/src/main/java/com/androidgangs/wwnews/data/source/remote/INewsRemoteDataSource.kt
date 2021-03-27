package com.androidgangs.wwnews.data.source.remote

import androidx.lifecycle.LiveData
import com.androidgangs.wwnews.data.model.NewsResponse

import com.androidgangs.wwnews.data.source.Result

interface INewsRemoteDataSource {

    fun setNewsData(data: Result<NewsResponse>)

    fun observeNewsData(): LiveData<Result<NewsResponse>>

    suspend fun fetchNewsData(
        country: String,
        apiKey: String
    ): Result<NewsResponse>
}