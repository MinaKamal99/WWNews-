package com.androidgangs.wwnews.data.repo

interface INewsRepository {

    suspend fun refreshArticlesListData(
        country: String,
        apiKey: String
    )
}