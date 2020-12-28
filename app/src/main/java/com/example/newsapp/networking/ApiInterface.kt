package com.example.newsapp.networking

import com.example.newsapp.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getNews(@Query("country") countryId: String,
                @Query("apiKey") apiKey: String
                ) : Call<NewsResponse>
}