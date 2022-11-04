package com.example.a34c_liveapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.a34c_liveapp.databinding.FragmentGameBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private val viewModel: QuizViewModel by viewModels()

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

        binding.scoreText.text = viewModel.score.toString()

        binding.questionText.text = viewModel.currentVip.name

        binding.musicianButton.setOnClickListener {
            viewModel.checkAnswer(true)

            if (viewModel.finished) {
                showEndDialog()
            }

            binding.scoreText.text = viewModel.score.toString()
            binding.questionText.text = viewModel.currentVip.name
        }

        binding.playerButton.setOnClickListener {
            viewModel.checkAnswer(false)

            if (viewModel.finished) {
                showEndDialog()
            }

            binding.scoreText.text = viewModel.score.toString()
            binding.questionText.text = viewModel.currentVip.name
        }
    }

    private fun showEndDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Gut geraten!")
            .setMessage("Du hast ${viewModel.score} mal richtig geantwortet")
            .setCancelable(false)
            .setNegativeButton("verlassen") { _, _ ->
                exitGame()
            }
            .setPositiveButton("spiel nochmal") { _, _ ->
                restartGame()
            }
            .show()
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun restartGame() {
        viewModel.restartGame()
        binding.scoreText.text = viewModel.score.toString()
        binding.questionText.text = viewModel.currentVip.name
    }
}
