package com.androidgangs.wwnews.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidgangs.wwnews.data.repo.INewsRepository
import com.androidgangs.wwnews.data.repo.NewsRepository

class NewsViewModel(
    private val newsRepository: NewsRepository
): ViewModel() {

}

class NewsViewModelFactory(val newsRepository: NewsRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository)  as T
    }
}