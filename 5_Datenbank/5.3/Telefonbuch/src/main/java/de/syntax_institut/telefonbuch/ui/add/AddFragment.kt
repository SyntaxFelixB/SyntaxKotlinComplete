package de.syntax_institut.telefonbuch.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.telefonbuch.R
import de.syntax_institut.telefonbuch.databinding.FragmentAddBinding
import de.syntax_institut.telefonbuch.ui.main.MainViewModel

/**
 * Dieses Fragment verwaltet das Hinzufügen neuer Kontakte
 */
class AddFragment : Fragment() {

    // Initialisiere binding & viewModel
    private lateinit var binding: FragmentAddBinding
    private val viewModel: MainViewModel by activityViewModels()

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
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

        // Der LifecycleOwner wird zugewiesem, damit LiveData automatisch vom Layout beobachtet wird
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Es wird der Status der Aktion beobachtet, also ob die Aktion bereits ausgeführt wurde
        // TODO

        // Setze einen Click Listener auf den Add Button, in dem ein neuer Kontakt mit dem
        // eingegebenen Namen und der eingegebenen Telefonnummer eingefügt wird
        // TODO

        // Setze einen Click Listener auf den Cancel Button,
        // in dem wieder zum Mainfragment navigiert wird
        binding.addBtnCancel.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToMainFragment())
        }
    }
}
