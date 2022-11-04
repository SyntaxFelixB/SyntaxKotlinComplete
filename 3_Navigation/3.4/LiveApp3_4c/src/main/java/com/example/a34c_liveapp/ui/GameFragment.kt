package com.example.a34c_liveapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a34c_liveapp.data.DataSource
import com.example.a34c_liveapp.data.model.Vip
import com.example.a34c_liveapp.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private var score = 0

    private lateinit var currentVip: Vip

    private val vipList = DataSource().loadVips()

    private var index = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGameBinding.inflate(layoutInflater)

//        ist dasselbe wie
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        currentVip = vipList[index]

        binding.scoreText.text = score.toString()
        binding.questionText.text = currentVip.name

        binding.musicianButton.setOnClickListener {
            checkAnswerandUpdate(true)
        }

        binding.playerButton.setOnClickListener {
            checkAnswerandUpdate(false)
        }
    }

    private fun checkAnswerandUpdate(clickedAnswer: Boolean) {

        if (clickedAnswer == currentVip.isMusician) {
            score ++
        }

        if (index < vipList.size - 1) {
            index ++
        } else {
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToResultFragment(score))
        }
        currentVip = vipList[index]

        // update UI
        binding.questionText.text = currentVip.name
        binding.scoreText.text = score.toString()
    }
}
