package com.firozanwar.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.NewsResponse
import com.firozanwar.newsapp.repository.NewsRepository
import com.firozanwar.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val breakingNewsPage: Int = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countyCode: String) = viewModelScope.launch {

        // Show the loading
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countyCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {

        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }

        return Resource.Error(response.message())
    }
}