package com.firozanwar.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.firozanwar.newsapp.db.ArticleDatabase
import com.firozanwar.newsapp.repository.NewsRepository
import com.firozanwar.newsapp.ui.NewsViewModel
import com.firozanwar.newsapp.ui.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Setting up the navigation
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
    }
}