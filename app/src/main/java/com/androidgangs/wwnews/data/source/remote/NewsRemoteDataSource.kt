package com.androidgangs.wwnews.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidgangs.wwnews.data.model.NewsResponse
import com.androidgangs.wwnews.data.source.Result
import com.androidgangs.wwnews.data.source.Result.Success
import com.androidgangs.wwnews.data.source.Result.Error

class NewsRemoteDataSource: INewsRemoteDataSource {

    private val observableArticlesListData = MutableLiveData<Result<NewsResponse>>()

    override fun setArticlesListData(data: Result<NewsResponse>){
        observableArticlesListData.value = data
    }

    override fun observeArticlesListData(): LiveData<Result<NewsResponse>> {
        return observableArticlesListData
    }

    override suspend fun fetchArticlesListData(country: String, apiKey: String): Result<NewsResponse> {
        var result = NewsApi
            .getNewsClient()
            .fetchArticlesListData(
                country,
                apiKey
            )

        if(result.isSuccessful){
            return Success(result.body()!!)
        }
        return Error(Exception(result.toString()))
    }
}