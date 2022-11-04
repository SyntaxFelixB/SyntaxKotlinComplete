package de.syntaxinstitut.room.ui.add

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.room.R
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.databinding.FragmentAddBinding
import de.syntaxinstitut.room.ui.main.MainViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
            container,
            false
        )

        // damit LiveData automatisch observed wird vom layout
        binding.lifecycleOwner = this.viewLifecycleOwner

        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.foodSpinner.setOnTouchListener { view, motionEvent ->
            val imm: InputMethodManager =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        binding.saveButton.setOnClickListener {
            getValuesAndSave()
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
        }

        viewModel.complete.observe(
            viewLifecycleOwner,
            Observer {
                if (it) {
                    findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
                    viewModel.unsetComplete()
                }
            }
        )
    }

    private fun getValuesAndSave() {
        val name = binding.nameEdit.text.toString()
        val food = binding.foodSpinner.selectedItem.toString()
        val newGuest = Guest(name = name, food = food)
        viewModel.insertGuest(newGuest)
    }
}
