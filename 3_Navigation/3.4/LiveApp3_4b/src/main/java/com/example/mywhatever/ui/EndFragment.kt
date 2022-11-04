package com.example.mywhatever.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mywhatever.R
import com.example.mywhatever.databinding.FragmentEndBinding

class EndFragment : Fragment() {

    private lateinit var binding: FragmentEndBinding

    private var won: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            won = it.getBoolean("won")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_end, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//          val random = (0..1).random()

        if (won == true) {
            binding.endText.text = "Du hast 20 Mark gewonnen!"
        } else {
            binding.endText.text = "Verloren! Du schuldest mir 20 Euro ;)"
        }

        binding.endRestartButton.setOnClickListener {
            findNavController().navigate(EndFragmentDirections.actionEndFragmentToGameFragment2())
        }
    }
}
