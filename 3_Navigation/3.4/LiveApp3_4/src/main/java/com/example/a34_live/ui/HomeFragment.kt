package com.example.a34_live.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a34_live.R
import com.example.a34_live.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.homeFragmentOneButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToOneFragment())
        }

        binding.homeFragmentTwoButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTwoFragment("das ist ein Test"))
        }
    }

}