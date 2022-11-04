package com.example.recyclerwiederholung_news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.recyclerwiederholung_news.adapter.NewsAdapter
import com.example.recyclerwiederholung_news.data.Repository
import com.example.recyclerwiederholung_news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = Repository()

        val newsList = repository.loadNews()

        binding.newsRecycler.adapter = NewsAdapter(newsList)


//        val snapHelper: SnapHelper = PagerSnapHelper()
//        snapHelper.attachToRecyclerView(binding.newsRecycler)
    }
}
