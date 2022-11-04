package com.example.mywhatever.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywhatever.R
import com.example.mywhatever.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.gameOneImage.setOnClickListener {
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToEndFragment(false))
        }

        binding.gameTwoImage.setOnClickListener {
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToEndFragment(true))
        }

        binding.gameThreeImage.setOnClickListener {
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToEndFragment(false))
        }
    }
}