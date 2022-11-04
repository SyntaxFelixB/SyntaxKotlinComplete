package com.example.workout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workout.R
import com.example.workout.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.startAmateurButton.setOnClickListener { findNavController().navigate(StartFragmentDirections.actionStartFragmentToWorkOutFragment(7))
        }

        binding.startAdvancedButton.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToWorkOutFragment(15))
        }

        binding.startProButton.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToWorkOutFragment(30))
        }
    }
}
