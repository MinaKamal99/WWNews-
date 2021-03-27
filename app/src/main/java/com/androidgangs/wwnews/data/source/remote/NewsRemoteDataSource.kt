package com.androidgangs.wwnews.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidgangs.wwnews.data.model.NewsResponse
import com.androidgangs.wwnews.data.source.Result
import com.androidgangs.wwnews.data.source.Result.Success
import com.androidgangs.wwnews.data.source.Result.Error

class NewsRemoteDataSource: INewsRemoteDataSource {

    private val observableNewsData = MutableLiveData<Result<NewsResponse>>()

    override fun setNewsData(data: Result<NewsResponse>){
        observableNewsData.value = data
    }

    override fun observeNewsData(): LiveData<Result<NewsResponse>> {
        return observableNewsData
    }

    override suspend fun fetchNewsData(country: String, apiKey: String): Result<NewsResponse> {
        var result = NewsApi
            .getNewsClient()
            .fetchNewsData(
                country,
                apiKey
            )

        if(result.isSuccessful){
            return Success(result.body()!!)
        }
        return Error(Exception(result.toString()))
    }
}