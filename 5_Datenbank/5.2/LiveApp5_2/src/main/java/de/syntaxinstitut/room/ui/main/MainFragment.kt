package de.syntaxinstitut.room.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.room.R
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.databinding.FragmentMainBinding
import de.syntaxinstitut.room.util.GuestAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container, false
        )

        // damit LiveData automatisch observed wird vom layout
        binding.lifecycleOwner = this.viewLifecycleOwner

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.guestlist

        viewModel.guestList.observe(
            viewLifecycleOwner,
            Observer {
                recyclerView.adapter = GuestAdapter(it)
            }
        )

        binding.addGuestButton.setOnClickListener {
            val newGuest = Guest(
                name = "dein Gast",
                food = "Essen"
            )
            viewModel.insertGuest(newGuest)
        }
    }
}
