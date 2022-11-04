package com.example.a34c_liveapp.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.a34c_liveapp.databinding.FragmentGameBinding

private const val TAG = "GameFragment"

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "onCreateView")

        binding = FragmentGameBinding.inflate(layoutInflater)

        binding.xmlViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

//        ist dasselbe wie
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.score.observe(
            viewLifecycleOwner,
            Observer {
                // wird immer ausgeführt wenn sich die  LiveDaten im Viewmodel ändern

                Log.d(TAG, "score Observer triggered")
                binding.scoreText.text = it.toString()
//                Toast.makeText(requireContext(), "weiter so", Toast.LENGTH_SHORT).show()
            }
        )

//        viewModel.currentVip.observe(
//            viewLifecycleOwner,
//            Observer {
//                // wird immer ausgeführt wenn sich die  LiveDaten im Viewmodel ändern
//
//                binding.questionText.text = it.name
//            }
//        )

        viewModel.finished.observe(
            viewLifecycleOwner,
            Observer {
                Log.d(TAG, "finished Observer triggered with value $it")
                if (it == true) {
                    findNavController().navigate(
                        GameFragmentDirections.actionGameFragmentToResultFragment()
                    )
                }
            }
        )

        binding.musicianButton.setOnClickListener {
            viewModel.checkAnswer(true)
        }

        binding.playerButton.setOnClickListener {
            viewModel.checkAnswer(false)
        }
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun restartGame() {
        viewModel.restartGame()
    }
}
