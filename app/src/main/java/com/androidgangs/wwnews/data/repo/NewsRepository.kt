package com.androidgangs.wwnews.data.repo

import com.androidgangs.wwnews.data.source.remote.INewsRemoteDataSource
import com.androidgangs.wwnews.data.source.remote.NewsRemoteDataSource

class NewsRepository(
    private val newsRemoteDataSource: INewsRemoteDataSource
): INewsRepository {

}