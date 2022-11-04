package de.syntaxinstitut.room.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.room.R
import de.syntaxinstitut.room.data.datamodels.Guest
import de.syntaxinstitut.room.databinding.FragmentEditBinding
import de.syntaxinstitut.room.ui.main.MainViewModel

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var guestId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            guestId = it.getLong("guestId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_edit,
            container,
            false
        )

        // damit LiveData automatisch observed wird vom layout
        binding.lifecycleOwner = this.viewLifecycleOwner

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val guest = viewModel.guestList.value?.find { it.id == guestId }

        if (guest != null) {
            binding.editNameEdit.setText(guest.name)
            val index = resources.getStringArray(R.array.food_array).indexOf(guest.food)
            binding.editFoodSpinner.setSelection(index)
        }

        binding.editSaveButton.setOnClickListener {
            if (guest != null) {
                getValuesAndUpdate(guest)
            }
        }

        binding.editDeleteButton.setOnClickListener {
            if (guest != null) {
               viewModel.deleteGuest(guest.id)
            }
        }

        viewModel.complete.observe(
            viewLifecycleOwner,
            Observer {
                if(it) {
                    findNavController().navigate(EditFragmentDirections.actionEditFragmentToMainFragment())
                    viewModel.unsetComplete()
                }
            }
        )
    }

    private fun getValuesAndUpdate(guest: Guest) {
        guest.name = binding.editNameEdit.text.toString()
        guest.food = binding.editFoodSpinner.selectedItem.toString()
        viewModel.updateGuest(guest)
    }
}
