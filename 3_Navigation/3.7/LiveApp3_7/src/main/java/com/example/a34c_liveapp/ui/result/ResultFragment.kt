package com.example.a34c_liveapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.a34c_liveapp.databinding.FragmentResultBinding
import com.example.a34c_liveapp.ui.game.QuizViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)

        binding.xmlViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.resultText.text = "Gratuliere du hast ${viewModel.score.value} Punkte erreicht!!"

//        binding.resultLastquestionText.text = viewModel.currentVip.value?.name

        binding.resultRestartButton.setOnClickListener {
            viewModel.restartGame()
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToGameFragment())
        }
    }
}
