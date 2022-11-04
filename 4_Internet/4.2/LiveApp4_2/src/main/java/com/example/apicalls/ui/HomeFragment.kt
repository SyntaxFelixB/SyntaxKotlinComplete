package com.example.apicalls.ui

import android.os.Bundle
import android.util.Log
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

//        val users = listOf<User>(
//            User("andre", "ich@me.i"),
//            User("you", "you@yourself.u")
//        )

        viewModel.users.observe(
            viewLifecycleOwner,
            Observer {
                Log.d("HomeFragment", "users Observer called")
                binding.userList.adapter = ItemAdapter(it)
            }
        )
    }
}
