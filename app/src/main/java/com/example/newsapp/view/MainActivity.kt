package com.example.newsapp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    companion object {
        const val countryId = "id"
        const val apiKey = "166c3872e66347dfa3d9eb6ea47726a1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this@MainActivity
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        populateData()
    }

    fun populateData() {
        binding.loadBar.visibility = View.VISIBLE
        viewModel.getNews(countryId, apiKey)!!.observe(this, Observer { newsLiveData ->
            binding.loadBar.visibility = View.GONE
            binding.listNews.also {
                it.layoutManager= LinearLayoutManager(context)
                it.setHasFixedSize(true)
                it.adapter = NewsAdapter(newsLiveData)
            }
            binding.listNews.adapter!!.notifyDataSetChanged()
        })
    }
}