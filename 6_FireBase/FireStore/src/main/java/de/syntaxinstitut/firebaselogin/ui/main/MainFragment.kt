package de.syntaxinstitut.firebaselogin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.firebaselogin.R
import de.syntaxinstitut.firebaselogin.databinding.FragmentMainBinding
import de.syntaxinstitut.firebaselogin.ui.MainViewModel

/**
 * Das MainFragment ist der Begrüßungsscreen unserer App
 * sollte kein User eingeloggt sein wird man automatisch zum Login weitergeleitet
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.loginFragment)
                } else {
                    viewModel.getPlayerData()
                }
            }
        )


        viewModel.player.observe(
            viewLifecycleOwner,
        Observer {
            binding.playerNameText.text = it.name
            binding.playerLevelText.text = it.level.toString()
        })

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        )

        binding.levelUpCard.setOnClickListener {
            viewModel.levelUp()
        }

        binding.logoutButton.setOnClickListener {
            viewModel.logout()
        }
    }
}
