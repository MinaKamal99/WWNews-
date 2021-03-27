package com.androidgangs.wwnews.ui.news

import androidx.lifecycle.*
import com.androidgangs.wwnews.data.model.ArticlesItem
import com.androidgangs.wwnews.data.model.NewsResponse
import com.androidgangs.wwnews.data.repo.INewsRepository
import com.androidgangs.wwnews.data.repo.NewsRepository
import com.androidgangs.wwnews.data.source.Result
import com.androidgangs.wwnews.data.source.Result.Success
import com.androidgangs.wwnews.data.source.Result.Error
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository
): ViewModel() {

    private var _forceUpdate = MutableLiveData<Boolean>(false)

    private var _articlesList: LiveData<List<ArticlesItem?>> = _forceUpdate.switchMap{ forceUpdate ->
        if(forceUpdate){
            viewModelScope.launch {
                newsRepository.refreshArticlesListData(
                    "EG",
                    "4dc3f2a9df944bd0ab813feabd9ee76b"
                )
            }
        }
        newsRepository.observeArticlesListData().switchMap { handleArticlesResult(it) }
    }
    var articlesList: LiveData<List<ArticlesItem?>> = _articlesList

    private fun handleArticlesResult(articlesListResult: Result<NewsResponse>): MutableLiveData<List<ArticlesItem?>> {
        val result = MutableLiveData<List<ArticlesItem?>>()
        if(articlesListResult is Success){
            result.value = articlesListResult.data.articles!!
        } else {
            result.value = emptyList()
        }
        return result
    }
}

class NewsViewModelFactory(val newsRepository: NewsRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository)  as T
    }
}