package com.example.newsapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.networking.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

object NewsRepository {
    val newsData = MutableLiveData<List<ArticlesItem>>()

    fun getNewsApiCall(countryId: String, apiKey: String) : MutableLiveData<List<ArticlesItem>> {
        val call = ApiClient.apiInterface.getNews(countryId, apiKey)

        call.enqueue(object: Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
               newsData.value = response.body()!!.articles
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }
        })

        return newsData
    }
}