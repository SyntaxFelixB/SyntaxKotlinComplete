package com.example.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recyclerview.R
import com.example.recyclerview.adapter.ItemAdapter
import com.example.recyclerview.data.Datasource
import com.example.recyclerview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val vacations = Datasource().loadVacations()

        binding.vacationRecycler.adapter = ItemAdapter(requireContext(), vacations)

        binding.vacationRecycler.setHasFixedSize(true)
    }
}
