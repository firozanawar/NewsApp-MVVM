package com.firozanwar.newsapp.repository

import com.androiddevs.mvvmnewsapp.Article
import com.firozanwar.newsapp.api.RetrofitInstance
import com.firozanwar.newsapp.db.ArticleDatabase

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(queryString: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(queryString, pageNumber)

    suspend fun upset(article: Article) = db.getArticleDao().upset(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles();

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}