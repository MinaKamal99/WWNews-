package com.androidgangs.wwnews.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.androidgangs.wwnews.R
import com.androidgangs.wwnews.data.repo.NewsRepository
import com.androidgangs.wwnews.data.source.remote.INewsRemoteDataSource
import com.androidgangs.wwnews.data.source.remote.NewsRemoteDataSource

class NewsFragment : Fragment() {

    private lateinit var newsRemoteDataSource: INewsRemoteDataSource

    private lateinit var newsRepository: NewsRepository

    private val viewModel by viewModels<NewsViewModel>{
        newsRemoteDataSource = NewsRemoteDataSource()
        newsRepository = NewsRepository(newsRemoteDataSource)
        NewsViewModelFactory(newsRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        

        return inflater.inflate(R.layout.fragment_news, container, false)
    }
}