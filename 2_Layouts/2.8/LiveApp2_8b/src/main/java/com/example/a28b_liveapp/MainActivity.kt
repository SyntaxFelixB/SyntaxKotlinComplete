package com.example.a28b_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a28b_liveapp.adapter.BlogAdapter
import com.example.a28b_liveapp.data.Datasource
import com.example.a28b_liveapp.data.model.BlogEntry
import com.example.a28b_liveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // val blogEntries = Datasource().loadBlogEntries()

        val datasource = Datasource()

        val blogEntries: List<BlogEntry> = datasource.loadBlogEntries()

        binding.canRecycler.adapter = BlogAdapter(blogEntries)

        binding.canRecycler.setHasFixedSize(true)

    }
}
