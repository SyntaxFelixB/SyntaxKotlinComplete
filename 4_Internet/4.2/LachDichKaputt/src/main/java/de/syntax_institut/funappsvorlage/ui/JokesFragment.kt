package de.syntax_institut.funappsvorlage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.syntax_institut.funappsvorlage.adapter.JokeAdapter
import de.syntax_institut.funappsvorlage.databinding.FragmentJokesBinding

class JokesFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: JokesViewModel by viewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentJokesBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Hier wird der Informationsabruf gestartet
        // TODO

        binding = FragmentJokesBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bei einem Klick auf btnRefresh sollen die Informationen erneut abgerufen werden
        // TODO

        // Verbesserte Performance bei fixer Listengröße
        binding.rvJokes.setHasFixedSize(true)

        // Die Variable jokes wird beobachtet und bei einer Änderung wird der Adapter der
        // Recyclerview neu gesetzt
        // TODO
    }
}
