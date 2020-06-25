package com.firozanwar.newsapp.api

import com.firozanwar.newsapp.util.Utils
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") API_KEY: String = Utils.API_KEY
    )

    @GET("/v2/everything")
    suspend fun searchNews(
        @Query("q") queryString: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") API_KEY: String = Utils.API_KEY
    )
}