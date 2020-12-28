package com.example.newsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.ArticlesItem

class NewsAdapter(private val listNews: List<ArticlesItem>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listNews[position]) {
                binding.tvTitle.text = title
                binding.tvDescription.text = description
                Glide.with(holder.itemView)
                    .load(urlToImage)
                    .apply(RequestOptions().centerCrop().error(R.drawable.ic_launcher_background))
                    .into(binding.imgNews)
            }
        }
    }
}