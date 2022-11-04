package com.example.recyclerwiederholung_news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.recyclerwiederholung_news.MainViewModel
import com.example.recyclerwiederholung_news.adapter.NewsAdapter
import com.example.recyclerwiederholung_news.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.news.observe(
            viewLifecycleOwner,
            Observer {
                // dieser Code wird immer dann ausgeführt wenn sich Wert von news ändert
                binding.homeNewsRecycler.adapter = NewsAdapter(it)
            }
        )
    }
}
