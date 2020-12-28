package com.example.newsapp.model

data class NewsResponse(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem>? = null,
	val status: String? = null
)



