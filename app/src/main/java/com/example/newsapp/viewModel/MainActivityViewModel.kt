package com.example.newsapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.repository.NewsRepository

class MainActivityViewModel : ViewModel() {
    var newsLiveData: MutableLiveData<List<ArticlesItem>>? = null

    fun getNews(countryId: String, apiKey: String): LiveData<List<ArticlesItem>>? {
        newsLiveData = NewsRepository.getNewsApiCall(countryId, apiKey)
        return newsLiveData
    }
}