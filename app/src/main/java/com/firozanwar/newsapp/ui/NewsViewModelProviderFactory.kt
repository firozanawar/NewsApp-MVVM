package com.firozanwar.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firozanwar.newsapp.repository.NewsRepository

class NewsViewModelProviderFactory(val newsRepository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}