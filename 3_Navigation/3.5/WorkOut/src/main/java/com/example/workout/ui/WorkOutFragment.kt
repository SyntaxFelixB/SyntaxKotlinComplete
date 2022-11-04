package com.example.workout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workout.R
import com.example.workout.databinding.FragmentWorkoutBinding

class WorkOutFragment : Fragment() {

    lateinit var binding: FragmentWorkoutBinding

    private var level = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            level = it.getInt("level")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_workout, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.workoutCounter.text = level.toString()

        binding.workoutButton.setOnClickListener {
            level --
            binding.workoutCounter.text = level.toString()

            if (level == 0) {
                findNavController().navigate(WorkOutFragmentDirections.actionWorkOutFragmentToEndFragment())
            }
        }
    }
}
