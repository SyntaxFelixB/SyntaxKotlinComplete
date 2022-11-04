package de.syntax_institut.telefonbuch.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.telefonbuch.R
import de.syntax_institut.telefonbuch.databinding.FragmentEditBinding
import de.syntax_institut.telefonbuch.ui.add.AddFragmentDirections
import de.syntax_institut.telefonbuch.ui.main.MainViewModel

/**
 * Dieses Fragment verwaltet das Bearbeiten eines Kontakts
 */
class EditFragment : Fragment() {

    // Initialisiere binding & viewModel
    private lateinit var binding: FragmentEditBinding
    private val viewModel: MainViewModel by activityViewModels()

    // Hier wird die ContactID des zu bearbeitenden Kontakts gespeichert
    private var contactId: Long = 0

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_edit, container, false
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

        // Hole die contactId aus den Arguments
        contactId = requireArguments().getLong("contactId")

        // Finde den Kontakt mit der contactId in der Kontaktliste
        // TODO

        // Falls es einen Kontakt mit dieser ID gab, setze Namen und Telefonnummer
        // TODO

        // Es wird der Status der Aktion beobachtet, also ob die Aktion bereits ausgeführt wurde
        // TODO

        // Setze einen Click Listener auf den Edit Button, in dem der aktuelle Kontakt mit dem
        // eingegebenen Name und der eingegebenen Telefonnummer aktualisiert wird
        // TODO

        // Setze einen Click Listener auf den Delete Button,
        // in dem der aktuelle Kontakt gelöscht wird, falls die Variable nicht null ist
        // TODO
    }
}
