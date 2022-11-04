package de.syntaxinstitut.firebaselogin.ui.authentication

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.firebaselogin.R
import de.syntaxinstitut.firebaselogin.data.Player
import de.syntaxinstitut.firebaselogin.databinding.FragmentSignupBinding
import de.syntaxinstitut.firebaselogin.ui.MainViewModel

/**
 * SignUpFragment enthält das UI um einen neuen User zu registrieren
 */
class SignUpFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupCancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.signupSignupButton.setOnClickListener {
            signUp()
        }

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
//                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(requireContext())
                        .setMessage(it)
                        .create()
                        .show()
                }
            }
        )

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.mainFragment)
                }
            }
        )
    }

    private fun signUp() {
        val email = binding.signupMail.text.toString()
        val password = binding.signupPassword.text.toString()
        val name = binding.signupNickname.text.toString()
        val level = binding.signupLevel.text.toString().toLong()

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            val newPlayer = Player(name = name, level = level)
            viewModel.signUp(email, password, newPlayer)
        }
    }
}