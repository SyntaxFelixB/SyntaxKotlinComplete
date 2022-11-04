package com.example.apicalls.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.apicalls.data.model.User
import com.example.apicalls.databinding.FragmentNewBinding

class AddFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentNewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            if (binding.nameEdit.text.isNotEmpty() && binding.mailEdit.text.isNotEmpty()) {
                addUser()
            } else {
                Toast.makeText(requireContext(), "name and email must be provided", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun addUser() {
        val newUser = User(
            binding.nameEdit.text.toString(),
            binding.mailEdit.text.toString(),
            "female",
            "active"
        )
        viewModel.addUser(newUser)

        Toast.makeText(requireContext(), "${newUser.name} added", Toast.LENGTH_SHORT)
            .show()

        findNavController().navigate(AddFragmentDirections.actionAddFragmentToHomeFragment())
    }
}
