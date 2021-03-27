package com.androidgangs.wwnews.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.androidgangs.wwnews.data.model.NewsResponse
import com.androidgangs.wwnews.data.source.Result
import com.androidgangs.wwnews.data.source.Result.Success
import com.androidgangs.wwnews.data.source.Result.Error
import com.androidgangs.wwnews.data.source.remote.INewsRemoteDataSource
import com.androidgangs.wwnews.data.source.remote.NewsRemoteDataSource

class NewsRepository(
    private val newsRemoteDataSource: INewsRemoteDataSource
): INewsRepository {

    fun observeArticlesListData(): LiveData<Result<NewsResponse>> {
        return newsRemoteDataSource.observeArticlesListData()
    }

    override suspend fun refreshArticlesListData(
        country: String,
        apiKey: String
    ) {
        val remoteArticlesListData = newsRemoteDataSource.fetchArticlesListData(
            country,
            apiKey
        )

        if(remoteArticlesListData is Success){
            newsRemoteDataSource.setArticlesListData(remoteArticlesListData)
        } else if (remoteArticlesListData is Error){
            throw remoteArticlesListData.exception
        }
    }
}