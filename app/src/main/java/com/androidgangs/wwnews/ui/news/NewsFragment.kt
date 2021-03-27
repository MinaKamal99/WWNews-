package com.androidgangs.wwnews.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.androidgangs.wwnews.R
import com.androidgangs.wwnews.data.repo.NewsRepository
import com.androidgangs.wwnews.data.source.remote.INewsRemoteDataSource
import com.androidgangs.wwnews.data.source.remote.NewsRemoteDataSource
import com.androidgangs.wwnews.databinding.FragmentNewsBinding
import com.iti.mad41.taqs.adapter.NewsAdapter

class NewsFragment : Fragment() {

    private lateinit var newsRemoteDataSource: INewsRemoteDataSource

    private lateinit var newsRepository: NewsRepository

    private lateinit var newsFragmentBinding: FragmentNewsBinding

    private lateinit var newsAdapter: NewsAdapter

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

        newsFragmentBinding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            newsViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return newsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArticlesAdapter()

        viewModel.articlesList.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun setupArticlesAdapter(){
        val newsViewModel = newsFragmentBinding.newsViewModel

        if(newsViewModel != null){
            newsAdapter = NewsAdapter(newsViewModel)
            newsFragmentBinding.newsListAdapter.adapter = newsAdapter
        }
    }
}