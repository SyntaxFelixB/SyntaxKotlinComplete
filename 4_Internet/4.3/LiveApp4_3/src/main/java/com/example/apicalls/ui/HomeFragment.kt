package com.example.apicalls.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.apicalls.adapter.ItemAdapter
import com.example.apicalls.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.imageList.observe(
            viewLifecycleOwner,
            Observer {
                binding.imageList.adapter = ItemAdapter(it)
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    ApiStatus.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    ApiStatus.DONE -> binding.progressBar.visibility = View.GONE
                    ApiStatus.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorImage.visibility = View.VISIBLE
                    }
                }
            }
        )
    }
}
