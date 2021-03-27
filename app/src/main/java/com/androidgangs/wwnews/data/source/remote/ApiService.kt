package com.androidgangs.wwnews.data.source.remote

import com.androidgangs.wwnews.data.model.NewsResponse
import com.androidgangs.wwnews.util.NEWS_BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object NewsApi {
    fun getNewsClient() = Retrofit
        .Builder()
        .baseUrl(NEWS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApiServices::class.java)
}

interface NewsApiServices{
    @GET("v2/top-headlines")
    suspend fun fetchNewsData(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>
}