package de.syntax_institut.filmestreamingservice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.syntax_institut.filmestreamingservice.data.Datasource
import de.syntax_institut.filmestreamingservice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       // TODO: lade das Layout in die BindingVariable

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val movieTitles = Datasource(requireContext()).loadMovies()

        //TODO: lade den ItemAdapter in die RecyclerView
    }

}